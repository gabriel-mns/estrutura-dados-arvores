public class NodeAvl{
    
    private NodeAvl nodeDireita;
    private NodeAvl nodeEsquerda;
    private int dado;
    private int altura = 0;

    public NodeAvl(int dado) {
        this.dado = dado;
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

    public int calcularAltura(){

        int alturaDir = -1;
        int alturaEsq = -1;

        if(nodeDireita != null)  alturaDir = nodeDireita.calcularAltura();
        if(nodeEsquerda != null) alturaEsq = nodeEsquerda.calcularAltura();

        altura = getMaior(alturaDir, alturaEsq) + 1;

        return altura;

    }

    public int calcularFatorBalanceamento(){

        int alturaDir = -1;
        int alturaEsq = -1;

        if(nodeDireita  != null) alturaDir = nodeDireita.calcularAltura();
        if(nodeEsquerda != null) alturaEsq = nodeEsquerda.calcularAltura();

        return alturaEsq - alturaDir;

    }

    private int getMaior(int a, int b){

        return a > b ? a : b;

    }
}
