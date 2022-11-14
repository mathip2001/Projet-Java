package consoCarbone;

/**
 * Classe Alimentation
 * 
 */

public class Alimentation extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private double txBoeuf; // le taux de repas (une valeur entre 0 et 1) à base de boeuf (le type de viande
                            // le plus émissif)
    private double txVege; // txVege, le taux de repas végétariens

    public final double c1 = 8.0;
    public final double c2 = 1.6;
    public final double c3 = 0.9;

    // Constructeur
    public Alimentation(double txBoeuf, double txVege) {
        super();
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        impact = c1 * txBoeuf + c2 * (1 - txVege - txBoeuf) + c3 * txVege;
    }

    /**
     * @return double
     */
    // getter et setter
    public double getTxBoeuf() {
        return txBoeuf;
    }

    /**
     * @param txBoeuf
     */
    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    /**
     * @return double
     */
    public double getTxVege() {
        return txVege;
    }

    /**
     * @param txVege
     */
    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }

    /**
     * @return double
     */
    public double getImpact() {
        return impact;
    }

    /**
     * @param impact
     */
    public void setImpact(double impact) {
        this.impact = impact;
    }

    /**
     * @return int
     */
    public int getID() {
        return ID;
    }

    /**
     * @return String
     */
    // Méthode toString
    @Override
    public String toString() {
        return "Alimentation [" + super.toString() + ", txBoeuf=" + txBoeuf + ", txVege=" + txVege + "]";
    }

    // Méthode de classe empreinteMoyAlimentation
    public static void empreinteMoyAlimentation() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport a l'alimentation :");
        System.out.println("Boissons : 263 Kg eq CO2/an");
        System.out.println("Produits laitiers et oeufs : 408 Kg eq CO2/an");
        System.out.println("Viandes et Poissons : 1144 Kg eq CO2/an");
        System.out.println("Autres : 538 Kg eq CO2/an");
    }

    /**
     * @param o
     * @return int
     */
    // Méthode compareTo
    public int compareTo(ConsoCarbone o) {
        int res = -1;
        Alimentation a = (Alimentation) o;

        if (this.getImpact() > a.getImpact()) {
            res = 1;
        }

        if ((this.getImpact() == a.getImpact())) {
            res = 0;
        }

        return res;
    }
}