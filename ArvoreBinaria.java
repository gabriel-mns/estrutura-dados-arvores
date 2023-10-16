public class ArvoreBinaria {
    
    public Node root;

    // CONSTRUTORES

    public ArvoreBinaria() {
    }

    public ArvoreBinaria(Node root) {
        this.root = root;
    }

    //MÉTODOS

    public void insert(int dado){

        insertRecursivo(dado, root);

    }

    public void insertRecursivo(int dado, Node nodeAtual){

        if(root == null){

            root = new Node(dado);
            return;

        }

        Node nodeDireita = nodeAtual.getNodeDireita();
        Node nodeEsquerda = nodeAtual.getNodeEsquerda();

         // Se ele vai para direita
        if(dado >= nodeAtual.getDado()){
                    
            if(nodeDireita == null){
                nodeAtual.setNodeDireita(new Node(dado));
                return;
            }

            insertRecursivo(dado, nodeDireita);
            return;
        }

        // Se ele vai para esquerda
        if(nodeEsquerda == null){
            nodeAtual.setNodeEsquerda(new Node(dado));
            return;
        }

        insertRecursivo(dado, nodeEsquerda);


    }

    public Node remover(Node atual, int dado){

        if(atual.getDado() == dado){

            boolean noFolha = atual.getNodeDireita() == null && atual.getNodeEsquerda() == null;
            boolean paiDeDoisFilhos = atual.getNodeDireita() != null && atual.getNodeEsquerda() != null;
            boolean esquerdaNaoVazia = atual.getNodeEsquerda() != null;

            // Se for nó folha
            if(noFolha){

                // Só vai falar que o novo valor dele é vazio (na chamada recursiva:
                // atual.setEsquerda(null)
                // )
                return null;

            } else {

                if(paiDeDoisFilhos){

                    // Pega o menor dos maiores do node que será removido, ou seja, o que mais se aproxima do próximo do atual
                    Node menorNoDoLadoDireito = findMin(atual.getNodeDireita());
                    atual.setDado(menorNoDoLadoDireito.getDado());
                    menorNoDoLadoDireito.setDado(dado);
                    atual.setNodeDireita(remover(atual.getNodeDireita(), dado));
                    return atual;

                }

                // Vai pegar a sub-árvore que não está vazia para ser definida no PAI
                Node auxiliar;

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
                return auxiliar;

            }

        } else {

            if(dado >= atual.getDado()){

                atual.setNodeDireita(remover(atual.getNodeDireita(), dado));
                
            } else {
                
                atual.setNodeEsquerda(remover(atual.getNodeEsquerda(), dado));

            }

            return atual;


        }

    }

    public Node buscar(Node atual,int dado){

        if(atual == null) return new Node();

        if(atual.getDado() == dado) return atual;

        if(dado > atual.getDado()) return buscar(atual.getNodeDireita(), dado);

        return buscar(atual.getNodeEsquerda(), dado);

    }

    private Node findMin(Node nodeAtual){

        if(nodeAtual.getNodeEsquerda() == null) return nodeAtual;

        return findMin(nodeAtual.getNodeEsquerda());

    }
    
    public Node findNodePai(int dado){

        Node nodeAtual = root;
        
        if(dado == root.getDado()){

            return root;
            
        }

        while(true){

            // Se o dado estiver do lado direito
            if(dado >= nodeAtual.getDado()){

                // Se o lado direito estiver vazio, o item não está na árvore
                if(nodeAtual.getNodeDireita() == null){

                    System.out.println("ERRO! O item não está presente nessa árvore!");
                    return new Node();

                }

                // Se o do lado direito for o dado procurado, encontramos a Node pai
                if(dado == nodeAtual.getNodeDireita().getDado()){

                    break;

                }

                // Se não tiver encontrado passa para o próximo nó da direita
                nodeAtual = nodeAtual.getNodeDireita();

                // E passa para a próxima iteração
                continue;

            }

            // Se estiver para o lado esquerdo
            // Se o lado esquerdo estiver vazio, o item não está na árvore
            if(nodeAtual.getNodeEsquerda() == null){

                System.out.println("ERRO! O item não está presente nessa árvore!");
                return new Node();

            }

            // Se o lado esquerdo estiver vazio, o item não está na árvore
            if(dado == nodeAtual.getNodeEsquerda().getDado()){

                break;

            }

            // Se não tiver encontrado passa para o próximo nó da esquerda
            nodeAtual = nodeAtual.getNodeEsquerda();

        }

        return nodeAtual;
    }
    // GETTERS E SETTERS

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String toString() {
        return toStringRecursivo(root, "", true);
    }

    private String toStringRecursivo(Node node, String prefix, boolean isLeft) {
        StringBuilder sb = new StringBuilder();

        if (node != null) {
            sb.append(prefix);
            sb.append(isLeft ? "├── " : "└── ");
            sb.append(node.getDado());
            sb.append("\n");

            String newPrefix = prefix + (isLeft ? "│   " : "    ");
            sb.append(toStringRecursivo(node.getNodeEsquerda(), newPrefix, true));
            sb.append(toStringRecursivo(node.getNodeDireita(), newPrefix, false));
        }

        return sb.toString();
    }

    public int getAltura(Node atual){

        if(atual == null) return -1;

        int tamanhoDaSubarvoreEsquerda = getAltura(atual.getNodeEsquerda());
        int tamanhoDaSubarvoreDireita = getAltura(atual.getNodeDireita());

        if(tamanhoDaSubarvoreEsquerda > tamanhoDaSubarvoreDireita){

            return tamanhoDaSubarvoreEsquerda + 1;

        }

        return tamanhoDaSubarvoreDireita + 1;
    }

    // AUXILIARES
    private boolean precisaDeBalanceamento(int fatorBalanceamento){

        return fatorBalanceamento > 1 || fatorBalanceamento < -1;

    }

}
