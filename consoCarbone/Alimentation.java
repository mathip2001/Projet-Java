package consoCarbone;

public class Alimentation extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private double txBoeuf; // le taux de repas (une valeur entre 0 et 1) à base de boeuf (le type de viande
                            // le plus émissif)
    private double txVege; // txVege, le taux de repas végétariens

    public final double c1 = 8.0;
    public final double c2 = 1.6;
    public final double c3 = 0.9;

    public static int cptIndividu = 0; // compteur statique du nb d'individu
    public static double totalImpact = 0.0; // total de la somme des impacts

    // Constructeur
    public Alimentation(double txBoeuf, double txVege) {
        super();
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        impact = impactFormula();
        totalImpact = totalImpact + this.impact;
        cptIndividu++;
    }

    public double impactFormula() {
        return c1 * txBoeuf + c2 * (1 - txVege - txBoeuf) + c3 * txVege;
    }

    // getter et setter
    public double getTxBoeuf() {
        return txBoeuf;
    }

    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    public double getTxVege() {
        return txVege;
    }

    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public int getID() {
        return ID;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Alimentation [" + super.toString() + ", txBoeuf=" + txBoeuf + ", txVege=" + txVege + "]";
    }

    // Méthode de classe empreinteMoyAlimentation
    public static void empreinteMoyAlimentation() {
        System.out.println("Empreinte carbone moyenne d'un français par rapport à l'alimentation");
        System.out.println("Boissons : 263 Kg eq CO2/an");
        System.out.println("Produits laitiers et oeufs : 408 Kg eq CO2/an");
        System.out.println("Viandes et Poissons : 1144 Kg eq CO2/an");
        System.out.println("Autres : 538 Kg eq CO2/an");
        // return "Empreinte moyenne de l'alimentation par individu : " + (totalImpact /
        // cptIndividu);
    }

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