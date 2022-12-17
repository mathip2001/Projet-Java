package consoCarbone;

public class AmmortissementException extends Exception {
    public AmmortissementException() {
        super("Erreur : l'amortissement doit être supérieur à 0");
    }

}
