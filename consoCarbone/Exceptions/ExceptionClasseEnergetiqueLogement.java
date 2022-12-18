package consoCarbone.Exceptions;

public class ExceptionClasseEnergetiqueLogement extends Exception {
    public ExceptionClasseEnergetiqueLogement() {
        super("Erreur : la classe énergétique doit avoir une lettre entre 'A' et 'G'");
    }

    public ExceptionClasseEnergetiqueLogement(String s) {
        super(s);
    }
}
