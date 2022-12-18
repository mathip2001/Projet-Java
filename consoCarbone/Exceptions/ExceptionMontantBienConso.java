package consoCarbone.Exceptions;

public class ExceptionMontantBienConso extends Exception {
    public ExceptionMontantBienConso() {
        super("Erreur : le montant doit être positive");
    }

    public ExceptionMontantBienConso(String s) {
        super(s);
    }
}
