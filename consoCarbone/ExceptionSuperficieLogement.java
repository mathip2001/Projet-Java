package consoCarbone;

public class ExceptionSuperficieLogement extends Exception {
    public ExceptionSuperficieLogement() {
        super("Erreur : la superficie doit être positive");
    }

    public ExceptionSuperficieLogement(String s) {
        super(s);
    }

}
