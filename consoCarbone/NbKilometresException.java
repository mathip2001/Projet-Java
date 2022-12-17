package consoCarbone;

public class NbKilometresException extends Exception {
    public NbKilometresException() {
        super("Erreur : Le nombre de kilomètres doit être positif");
    }

}
