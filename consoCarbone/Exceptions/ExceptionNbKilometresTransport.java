package consoCarbone.Exceptions;

public class ExceptionNbKilometresTransport extends Exception {
    public ExceptionNbKilometresTransport() {
        super("Erreur : Le nombre de kilomètres doit être positif");
    }

    public ExceptionNbKilometresTransport(String s) {
        super(s);
    }

}
