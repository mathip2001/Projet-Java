package consoCarbone;

public class ObjetInconnuException extends Exception {
    public ObjetInconnuException() {
        super("Erreur : l'objet n'existe pas");
    }

}