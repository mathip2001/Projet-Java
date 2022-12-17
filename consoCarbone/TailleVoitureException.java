package consoCarbone;

public class TailleVoitureException extends Exception {
    public TailleVoitureException() {
        super("Erreur : Veuillez répondre par 'P' ou 'G'");
    }

    public TailleVoitureException(String s) {
        super(s);
    }
}
