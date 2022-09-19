package consoCarbone;

public class Alimentation extends ConsoCarbone {
    private double txBoeuf; // le taux de repas (une valeur entre 0 et 1) à base de boeuf (le type de viande
                            // le plus émissif)
    private double txVege; // txVege, le taux de repas végétariens

    public final double c1 = 8.0;
    public final double c2 = 1.6;
    public final double c3 = 0.9;

    public static int cptIndividu = 0; // compteur statique du nb d'individu
    public static double totalImpact = 0.0; // total de la somme des impacts

    public Alimentation(double txBoeuf, double txVege) {
        super();
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.impact = impactFormula();
        totalImpact = totalImpact + this.impact;
        cptIndividu++;
    }

    public double impactFormula() {
        return c1 * txBoeuf + c2 * (1 - txVege - txBoeuf) + c3 * txVege;
    }

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

    @Override
    public String toString() {
        return "Alimentation [txBoeuf=" + txBoeuf + ", txVege=" + txVege + ", impact=" + impact + "]";
    }

    public static String empreinteMoyAlimentation() {
        return "Empreinte moyenne de l'alimentation par individu : " + (totalImpact / cptIndividu);
    }

}