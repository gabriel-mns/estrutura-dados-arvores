public class ArvoreAvl{
    
    private NodeAvl root;

    //COSNTRUTORES
    public ArvoreAvl() {}
    
    public ArvoreAvl(NodeAvl root) {
        this.root = root;
    }

    public void insert(int dado){

        //insertRecursivo(dado, root);
        root = insertRec(dado, root);

    }

    public NodeAvl insertRec(int dado, NodeAvl nodeAtual){

        if(nodeAtual == null) { 

            return new NodeAvl(dado);

        }

        NodeAvl nodeDireita = nodeAtual.getNodeDireita();
        NodeAvl nodeEsquerda = nodeAtual.getNodeEsquerda();

        // Se ele vai para direita
        if(dado >= nodeAtual.getDado()){
                    
            nodeAtual.setNodeDireita(insertRec(dado, nodeDireita));

        } else {

            nodeAtual.setNodeEsquerda(insertRec(dado, nodeEsquerda));

        }

        atualizarAlturas();
        nodeAtual = rebalancear(nodeAtual);
        return nodeAtual;

    }

    public NodeAvl remover(NodeAvl atual, int dado){

        if(atual == null) return new NodeAvl();

        if(atual.getDado() == dado){

            boolean noFolha = atual.getNodeDireita() == null && atual.getNodeEsquerda() == null;
            boolean paiDeDoisFilhos = atual.getNodeDireita() != null && atual.getNodeEsquerda() != null;
            boolean esquerdaNaoVazia = atual.getNodeEsquerda() != null;

            // Se for nó folha
            if(noFolha){

                // Só vai falar que o novo valor dele é vazio (na chamada recursiva:
                // atual.setEsquerda(null)
                // )
                atualizarAlturas();
                root = rebalancear(root);

                return null;

            } else {

                if(paiDeDoisFilhos){

                    // Pega o menor dos maiores do node que será removido, ou seja, o que mais se aproxima do próximo do atual
                    NodeAvl menorNoDoLadoDireito = findMin(atual.getNodeDireita());
                    atual.setDado(menorNoDoLadoDireito.getDado());
                    menorNoDoLadoDireito.setDado(dado);
                    atual.setNodeDireita(remover(atual.getNodeDireita(), dado));
                    // root = rebalancear(root);
                    // atualizarAlturas();
                    return atual;

                }

                // Vai pegar a sub-árvore que não está vazia para ser definida no PAI
                NodeAvl auxiliar;

                // Se o filho estiver na esquerda
                if(esquerdaNaoVazia){

                    // Pega a sub-árvore na esquerda para por no PAI
                    auxiliar = atual.getNodeEsquerda();

                // Se o filho estiver na direita
                } else {

                    // Pega a sub-árvore na direita para por no PAI
                    auxiliar = atual.getNodeDireita();

                }

                // Vai retornar a nova sub-árvore do PAI
                root = rebalancear(root);
                atualizarAlturas();
                return auxiliar;

            }

        } else {

            if(dado >= atual.getDado()){

                atual.setNodeDireita(remover(atual.getNodeDireita(), dado));
                
                
            } else {
                
                atual.setNodeEsquerda(remover(atual.getNodeEsquerda(), dado));

            }

            root = rebalancear(root);
            atualizarAlturas();
            return atual;


        }

    }

    private NodeAvl rebalancear(NodeAvl atual) {

        NodeAvl nodeDir = atual.getNodeDireita();
        NodeAvl nodeEsq = atual.getNodeEsquerda();
        Integer fbNodeDir;
        Integer fbNodeEsq;

        if(nodeDir != null){

            fbNodeDir = nodeDir.calcularFatorBalanceamento();

            if(fbNodeDir == -2 || fbNodeDir == 2){
                
                atual.setNodeDireita(rebalancear(atual.getNodeDireita()));

            }

        }
        if(nodeEsq != null){

            fbNodeEsq = nodeEsq.calcularFatorBalanceamento();

            if(fbNodeEsq == -2 || fbNodeEsq == 2 ){
                
                atual.setNodeEsquerda((rebalancear(atual.getNodeEsquerda())));

            }

        }

        int fbAtual = atual.calcularFatorBalanceamento();

        if(fbAtual == -2 ){

            if(nodeDir.getNodeDireita() == null){

                return rotacionarDireitaEsquerda(atual);

            }

            return rotacionarEsquerda(atual);

        }

        if(fbAtual == 2){

            if(nodeEsq.getNodeEsquerda() == null){

                 return rotacionarEsquerdaDireita(atual);

            }

            return rotacionarDireita(atual);

        }

        return atual;

    }

    private NodeAvl findMin(NodeAvl nodeAtual){

        if(nodeAtual.getNodeEsquerda() == null) return nodeAtual;

        return findMin(nodeAtual.getNodeEsquerda());

    }
    
    public NodeAvl buscar(NodeAvl atual,int dado){

        if(atual == null) return new NodeAvl();

        if(atual.getDado() == dado) return atual;

        if(dado > atual.getDado()) return buscar(atual.getNodeDireita(), dado);

        return buscar(atual.getNodeEsquerda(), dado);

    }

    //GETTERS E SETTERS
    public NodeAvl getRoot() {
        return root;
    }

    public void setRoot(NodeAvl root) {
        this.root = root;
    }

    public String toString() {
        return toStringRecursivo(root, "", false);
    }

    public String toStringRecursivo(NodeAvl node, String prefix, boolean isLeft) {
        StringBuilder sb = new StringBuilder();

        if (node != null) {
            sb.append(prefix);
            sb.append(isLeft ? "d >  " : "e > ");
            sb.append(node.getDado());
            sb.append("\n");

            String newPrefix = prefix + (isLeft ? "│   " : "    ");
            sb.append(toStringRecursivo(node.getNodeDireita(), newPrefix, true));
            sb.append(toStringRecursivo(node.getNodeEsquerda(), newPrefix, false));
        }

        return sb.toString();
    }

    // ROTAÇÕES

    public NodeAvl rotacionarEsquerda(NodeAvl base){

        //System.out.println("Realizado: Rtc. Esquerda");

        // Filho base  = nó a direita do nó desbalanceado
        // Neto base = 
        NodeAvl filhoBase = base.getNodeDireita();
        NodeAvl netoBase  = filhoBase.getNodeEsquerda();

        base.setNodeDireita(netoBase);
        filhoBase.setNodeEsquerda(base);

        return filhoBase;

    }

    public NodeAvl rotacionarDireita(NodeAvl base){

        //System.out.println("Realizado: Rtc. Direita");

        // Filho base  = nó a esquerda do nó desbalanceado
        // Neto base   = filho do filho da base
        NodeAvl filhoBase = base.getNodeEsquerda();
        NodeAvl netoDireitaBase   = filhoBase.getNodeDireita();

        base.setNodeEsquerda(netoDireitaBase);
        filhoBase.setNodeDireita(base);
    

        return filhoBase;

    }

    public NodeAvl rotacionarDireitaEsquerda(NodeAvl base){

        base.setNodeDireita(rotacionarDireita(base.getNodeDireita()));
        return rotacionarEsquerda(base);
    }

    public NodeAvl rotacionarEsquerdaDireita(NodeAvl base){

        base.setNodeEsquerda(rotacionarEsquerda(base.getNodeEsquerda()));
        return rotacionarDireita(base);
    }

    public void atualizarAlturas(){
        
        root.calcularAltura();

    }

}
