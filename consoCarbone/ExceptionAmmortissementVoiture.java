package consoCarbone;

public class ExceptionAmmortissementVoiture extends Exception {
    public ExceptionAmmortissementVoiture() {
        super("Erreur : l'amortissement doit être supérieur à 0");
    }

    public ExceptionAmmortissementVoiture(String s) {
        super(s);
    }
}
