package consoCarbone;

/**
 * L'énumération CE permet de regrouper les constantes représentant la classe énergétique d'un logement
 */
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
    /**
     * La méthode getCoefficient permet de récupérer le coefficient multiplicatif dépendant de la classe énergétique d'un logement
     * 
     * @return le coefficient multiplicatif dépendant de la classe énergétique
     */
    public double getCoefficient() {
        return coefficient;
    }
}
