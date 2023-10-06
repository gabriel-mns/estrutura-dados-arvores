public class NodeAvl{
    
    private NodeAvl nodeDireita;
    private NodeAvl nodeEsquerda;
    private int dado;
    private int altura = 0;

    public NodeAvl(int dado) {
        this.dado = dado;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    } 

    public NodeAvl getNodeDireita() {
        return nodeDireita;
    }

    public void setNodeDireita(NodeAvl nodeDireita) {
        this.nodeDireita = nodeDireita;
    }

    public NodeAvl getNodeEsquerda() {
        return nodeEsquerda;
    }

    public void setNodeEsquerda(NodeAvl nodeEsquerda) {
        this.nodeEsquerda = nodeEsquerda;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getFatorBalanceamento(){

        return getAlturaNo(this.nodeEsquerda) - getAlturaNo(this.nodeDireita);

    }

    public static int getAlturaNo(NodeAvl node){

        if(node == null) return -1;

        return node.altura;

    }


}
