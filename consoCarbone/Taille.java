package consoCarbone;

public enum Taille {
    // Enumérations
    P(4.2), G(19.0);

    // Attributs
    private double production;

    // Constructeur
    Taille(double production) {
        this.production = production;
    }

    // getter
    public double getProduction() {
        return production;
    }
}
