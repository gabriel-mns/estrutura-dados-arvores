public class Node{

    public int  dado;
    public Node nodeEsquerda;
    public Node nodeDireita;

    // CONSTRUTORES

    public Node() {
    }

    public Node(int dado) {
        this.dado = dado;
    }

    public Node(int dado, Node leafMenor, Node leafMaior) {
        this.dado = dado;
        this.nodeEsquerda = leafMenor;
        this.nodeDireita = leafMaior;
    }


    // GETTERS E SETTERS


    public int getDado() {
        return dado;
    }
    public void setDado(int dado) {
        this.dado = dado;
    }
    public Node getNodeEsquerda() {
        return nodeEsquerda;
    }
    public void setNodeEsquerda(Node leafMenor) {
        this.nodeEsquerda = leafMenor;
    }
    public Node getNodeDireita() {
        return nodeDireita;
    }
    public void setNodeDireita(Node leafMaior) {
        this.nodeDireita = leafMaior;
    }

}