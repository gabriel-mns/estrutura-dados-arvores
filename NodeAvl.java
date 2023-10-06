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

    public static int calcularFatorBalanceamento(NodeAvl atual){

        NodeAvl nodeDireito = atual.getNodeDireita();
        NodeAvl nodeEsquerda = atual.getNodeEsquerda();

        if( nodeDireito == null &&  nodeEsquerda == null){

            return 0;

        } else if(nodeDireito == null){

            return calcularFatorBalanceamento(atual.getNodeEsquerda()) +1;

        } else if(nodeEsquerda == null){

            return calcularFatorBalanceamento(atual.getNodeDireita()) -1;

        }

        return calcularFatorBalanceamento(atual.getNodeEsquerda()) + calcularFatorBalanceamento(atual.getNodeDireita());

        
        /*
        * 
        * PARA O LÓGICA DE VER O BALANCEAMENTO
        * 
        * SE O DA DIREITA FOR NULL RETORNA FB DA ESQUERDA +1
        * 
        * SE O DA ESQUERDA FOR NULL RETORNA FB DA DIREITA -1
        * 
        * SE TIVER OS DOIS FILHOS RETORNA FB DIREITA + FB ESQUERDA
        * 
        */
    }

}
