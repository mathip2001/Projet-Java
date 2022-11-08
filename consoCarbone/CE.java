package consoCarbone;

public enum CE {
    // Enumérations
    A(0.005), B(0.01), C(0.02), D(0.035), E(0.055), F(0.08), G(0.1);

    // Attributs
    private double coefficient;

    // Constructeur
    private CE(double coefficient) {
        this.coefficient = coefficient;
    }

    // getter
    public double getCoefficient() {
        return coefficient;
    }
}
