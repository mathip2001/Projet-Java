package consoCarbone.Exceptions;

public class ExceptionTauxAlimentation extends Exception {
    public ExceptionTauxAlimentation() {
        super("Erreur : le taux doit être en 0 et 1");
    }

    public ExceptionTauxAlimentation(String s) {
        super(s);
    }

}
