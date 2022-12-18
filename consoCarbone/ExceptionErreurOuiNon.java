package consoCarbone;

public class ExceptionErreurOuiNon extends Exception {

    public ExceptionErreurOuiNon() {
        super("Veuillez répondre par 'Oui' ou 'Non'");
    }

    public ExceptionErreurOuiNon(String s) {
        super(s);
    }
}