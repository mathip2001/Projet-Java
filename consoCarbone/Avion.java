package consoCarbone;

public class Avion extends Transport {
    private boolean utilise;
    private int kilomAnnee;

    public Avion(boolean utilise, int kilomAnnee) {
        super();
        this.utilise = utilise;
        this.kilomAnnee = kilomAnnee;
        impact = impactFormula();
    }

    public double impactFormula() {
        if (!utilise) {
            return 0;
        } else {
            return kilomAnnee * 1.93 * Math.pow(10, -4);
        }
    }

}