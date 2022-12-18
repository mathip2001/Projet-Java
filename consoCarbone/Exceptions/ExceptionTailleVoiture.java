package consoCarbone.Exceptions;

public class ExceptionTailleVoiture extends Exception {
    public ExceptionTailleVoiture() {
        super("Erreur : 2 types de taille sont possibles : 'P' ou 'G'");
    }

    public ExceptionTailleVoiture(String s) {
        super(s);
    }
}
