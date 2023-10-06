public class ArvoreAvl{
    
    private NodeAvl root;

    //COSNTRUTORES
    public ArvoreAvl() {}
    
    public ArvoreAvl(NodeAvl root) {
        this.root = root;
    }

    public void insert(int dado){

        insertRecursivo(dado, root);

    }

    public void insertRecursivo(int dado, NodeAvl nodeAtual){

        if(root == null){

            root = new NodeAvl(dado);
            return;

        }

        NodeAvl nodeDireita = nodeAtual.getNodeDireita();
        NodeAvl nodeEsquerda = nodeAtual.getNodeEsquerda();

         // Se ele vai para direita
        if(dado >= nodeAtual.getDado()){
                    
            if(nodeDireita == null){
                nodeAtual.setNodeDireita(new NodeAvl(dado));
                return;
            }

            insertRecursivo(dado, nodeDireita);
            return;
        }

        // Se ele vai para esquerda
        if(nodeEsquerda == null){
            nodeAtual.setNodeEsquerda(new NodeAvl(dado));
            return;
        }

        insertRecursivo(dado, nodeEsquerda);


    }

    private NodeAvl rebalancear(NodeAvl atual) {
        return null;
    }

    //GETTERS E SETTERS
    public NodeAvl getRoot() {
        return root;
    }

    public void setRoot(NodeAvl root) {
        this.root = root;
    }

    private int getMaior(int alturaA, int alturaB){
        return alturaA > alturaB ? alturaA : alturaB;
    }

    public String toString() {
        return toStringRecursivo(root, "", true);
    }

    private String toStringRecursivo(NodeAvl node, String prefix, boolean isLeft) {
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

    // ROTAÇÕES

    private NodeAvl rotacionarEsquerda(NodeAvl base){

        // Filho base  = nó a direita do nó desbalanceado
        // Neto base = 
        NodeAvl filhoBase = base.getNodeDireita();
        NodeAvl netoBase  = filhoBase.getNodeEsquerda();

        base.setNodeDireita(netoBase);
        filhoBase.setNodeEsquerda(base);
        
        base.setAltura(
            getMaior(
                NodeAvl.getAlturaNo(base.getNodeDireita()),
                NodeAvl.getAlturaNo(base.getNodeEsquerda())
            ) + 1
        );

        filhoBase.setAltura(
            getMaior(
                NodeAvl.getAlturaNo(filhoBase.getNodeDireita()),
                NodeAvl.getAlturaNo(filhoBase.getNodeEsquerda())
            ) + 1
        );

        return filhoBase;

    }

    private NodeAvl rotacionarDireita(NodeAvl base){

        // Filho base  = nó a direita do nó desbalanceado
        // Neto base = 
        NodeAvl filhoBase = base.getNodeEsquerda();
        NodeAvl netoBase  = filhoBase.getNodeDireita();

        base.setNodeEsquerda(netoBase);
        filhoBase.setNodeDireita(base);
        
        base.setAltura(
            getMaior(
                NodeAvl.getAlturaNo(base.getNodeDireita()),
                NodeAvl.getAlturaNo(base.getNodeEsquerda())
            ) + 1
        );

        filhoBase.setAltura(
            getMaior(
                NodeAvl.getAlturaNo(filhoBase.getNodeDireita()),
                NodeAvl.getAlturaNo(filhoBase.getNodeEsquerda())
            ) + 1
        );

        return filhoBase;

    }

    private NodeAvl rotacioanrDireitaEsquerda(NodeAvl base){

        base.setNodeDireita(rotacionarDireita(base.getNodeDireita()));
        return rotacionarEsquerda(base);
    }

    private NodeAvl rotacionarEsquerdaDireita(NodeAvl base){

        base.setNodeEsquerda(rotacionarEsquerda(base.getNodeEsquerda()));
        return rotacionarEsquerda(base);
    }
}
