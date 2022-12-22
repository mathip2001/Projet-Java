package consoCarbone;

/**
 * L'énumération Taille permet de regrouper les constantes représentant la taille d'une voiture
 */
public enum Taille {
    // Enumérations
    P(4.2), G(19.0);

    // Attributs
    private double production;

    // Constructeur
    private Taille(double production) {
        this.production = production;
    }

    // getter
    /**
     * La méthode getProduction permet de récupérer les émissions nécessaires à la fabrication de la voiture
     * 
     * @return les émissions nécessaires à la fabrication de la voiture
     */
    public double getProduction() {
        return production;
    }
}
