import java.util.Random;

public class Relatorio {
 
    public static void testarAVL(int[] testes){

        ArvoreAvl abInsercao = new ArvoreAvl();
        ArvoreAvl arvoreBuscaRemocao = new ArvoreAvl();
        Random random = new Random(123456789);

        //Testes de inserção
        System.out.println("""

                    INÍCIO DOS TESTES DE INSERÇÃO

                """);
        for (int qtde : testes) {
            

            long tempoInicio = System.currentTimeMillis();
            for (int i = 0; i < qtde; i++) {

                abInsercao.insert(random.nextInt());
                
            }
            long tempoFim = System.currentTimeMillis();

            System.out.printf("""

            ************************
            Qtde. de inserções: %s
            Tempo de execução : %s ms
            ************************

            """, qtde, tempoFim - tempoInicio);

        }
        System.out.println("""

                    FIM DOS TESTES DE INSERÇÃO
                ===================================
                """);


        //Testes de busca
        System.out.println("""

            INÍCIO DOS TESTES DE BUSCA

        """);
        for (int i = 0; i < testes.length; i++) {

            int qtde = testes[i];

            // Populando arvore de busca
            arvoreBuscaRemocao = new ArvoreAvl();
            for (int j = 0; j < qtde; j++) {
                arvoreBuscaRemocao.insert(random.nextInt());
            }

            // Início do teste de busca
            long tempoInicio = System.currentTimeMillis();
            for (int j = 0; j < qtde; j++) {
                
                arvoreBuscaRemocao.buscar(arvoreBuscaRemocao.getRoot(),random.nextInt());
                
            }
            long tempoFim = System.currentTimeMillis();

            System.out.printf("""

            ************************
            Qtde. de buscas   : %s
            Tempo de execução : %s ms
            ************************

            """, qtde, tempoFim - tempoInicio);


        }
        System.out.println("""

                    FIM DOS TESTES DE BUSCA
                ===================================
        """);


         //Testes de busca
        System.out.println("""

            INÍCIO DOS TESTES DE REMOÇÃO

        """);
        for (int i = 0; i < testes.length; i++) {

            int qtde = testes[i];

            // Populando arvore de busca
            arvoreBuscaRemocao = new ArvoreAvl();
            for (int j = 0; j < qtde; j++) {
                arvoreBuscaRemocao.insert(j);
            }

            // Início do teste de busca
            long tempoInicio = System.currentTimeMillis();
            for (int j = 0; j < qtde; j++) {
                
                arvoreBuscaRemocao.remover(arvoreBuscaRemocao.getRoot(),j);
                
            }
            long tempoFim = System.currentTimeMillis();

            System.out.printf("""

            ************************
            Qtde. de buscas   : %s
            Tempo de execução : %s ms
            ************************

            """, qtde, tempoFim - tempoInicio);


        }

        

    }
 
    public static void testarBin(int[] testes){

    ArvoreBinaria abInsercao = new ArvoreBinaria();
    ArvoreBinaria arvoreBuscaRemocao = new ArvoreBinaria();
    Random random = new Random(123456789);

    //Testes de inserção
    System.out.println("""

                INÍCIO DOS TESTES DE INSERÇÃO

            """);
    for (int qtde : testes) {
        

        long tempoInicio = System.currentTimeMillis();
        for (int i = 0; i < qtde; i++) {

            abInsercao.insert(random.nextInt());
            
        }
        long tempoFim = System.currentTimeMillis();

        System.out.printf("""

        ************************
        Qtde. de inserções: %s
        Tempo de execução : %s ms
        ************************

        """, qtde, tempoFim - tempoInicio);

    }
    System.out.println("""

                FIM DOS TESTES DE INSERÇÃO
            ===================================
            """);


    //Testes de busca
    System.out.println("""

        INÍCIO DOS TESTES DE BUSCA

    """);
    for (int i = 0; i < testes.length; i++) {

        int qtde = testes[i];

        // Populando arvore de busca
        arvoreBuscaRemocao = new ArvoreBinaria();
        for (int j = 0; j < qtde; j++) {
            arvoreBuscaRemocao.insert(j);
        }

        // Início do teste de busca
        long tempoInicio = System.currentTimeMillis();
        for (int j = 0; j < qtde; j++) {
            
            arvoreBuscaRemocao.buscar(arvoreBuscaRemocao.getRoot(),j);
            
        }
        long tempoFim = System.currentTimeMillis();

        System.out.printf("""

        ************************
        Qtde. de buscas   : %s
        Tempo de execução : %s ms
        ************************

        """, qtde, tempoFim - tempoInicio);


    }
    System.out.println("""

                FIM DOS TESTES DE BUSCA
            ===================================
    """);


        //Testes de busca
    System.out.println("""

        INÍCIO DOS TESTES DE REMOÇÃO

    """);
    for (int i = 0; i < testes.length; i++) {

        int qtde = testes[i];

        // Populando arvore de busca
        arvoreBuscaRemocao = new ArvoreBinaria();
        for (int j = 0; j < qtde; j++) {
            arvoreBuscaRemocao.insert(j);
        }

        // Início do teste de busca
        long tempoInicio = System.currentTimeMillis();
        for (int j = 0; j < qtde; j++) {
            
            arvoreBuscaRemocao.remover(arvoreBuscaRemocao.getRoot(),j);
            
        }
        long tempoFim = System.currentTimeMillis();

        System.out.printf("""

        ************************
        Qtde. de buscas   : %s
        Tempo de execução : %s ms
        ************************

        """, qtde, tempoFim - tempoInicio);


    }

    

}


    public static void main(String[] args) {

        int[] testes = {100,500,1000,10000,20000};

        System.out.println("--------------- ARVORE AVL --------------- ");
        testarAVL(testes);
        
        
        System.out.println("--------------- ARVORE BINÁRIA --------------- ");
        testarBin(testes);

    }
}
