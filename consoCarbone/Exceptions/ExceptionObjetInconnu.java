package consoCarbone.Exceptions;

public class ExceptionObjetInconnu extends Exception {
    public ExceptionObjetInconnu() {
        super("Erreur : l'objet n'existe pas");
    }

}