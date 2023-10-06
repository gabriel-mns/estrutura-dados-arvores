public class Main {
    public static void main(String[] args) {
        
        ArvoreAvl ab = new ArvoreAvl();

        System.out.println(ab);

        ab.insert(583);
        ab.insert(245);
        ab.insert(731);
        ab.insert(684);
        ab.insert(893);
        ab.insert(123);
        ab.insert(389);
        ab.insert(200);
        ab.insert(278);

        System.out.println(ab);

        // ab.remover(ab.getRoot(), 245);

        // System.out.println(ab);

        // // ab.remover(ab.getRoot, 893);

        // System.out.println(ab);

        // // ab.remover(ab.getRoot, 583);

        // System.out.println(ab);

    }
}
