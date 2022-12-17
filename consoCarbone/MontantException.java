package consoCarbone;

public class MontantException extends Exception {
    public MontantException() {
        super("Erreur : le montant doit être positive");
    }
}
