package consoCarbone;

public class ClasseEnergetiqueException extends Exception {
    public ClasseEnergetiqueException() {
        super("Erreur : Veuillez répondre par les lettres de 'A' à 'G'");
    }

    public ClasseEnergetiqueException(String s) {
        super(s);
    }
}
