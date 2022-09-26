package consoCarbone;

public class Logement extends ConsoCarbone {
    private int superficie; // la superficie du logement en m2
    private CE classeEnergetique; // la classe énergétique du logement

    public static int cptIndividu = 0; // compteur statique du nb d'individu
    public static double totalImpact = 0.0; // total de la somme des impacts

    public Logement(int superficie, CE classeEnergetique) {
        super();
        this.superficie = superficie;
        this.classeEnergetique = classeEnergetique;
        this.impact = impactFormula();
        totalImpact = totalImpact + this.impact;
        cptIndividu++;
    }

    public double impactFormula() {
        switch (classeEnergetique) {
            case A:
                return superficie * 0.005;
            case B:
                return superficie * 0.01;
            case C:
                return superficie * 0.02;
            case D:
                return superficie * 0.035;
            case E:
                return superficie * 0.055;
            case F:
                return superficie * 0.08;
            case G:
                return superficie * 0.1;
        }
        return -1;
    }

    public int getSuperficie() {
        return superficie;
    }

    public CE getClasseEnergetique() {
        return classeEnergetique;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setClasseEnergetique(CE classeEnergetique) {
        this.classeEnergetique = classeEnergetique;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public double getImpact() {
        return impact;
    }

    @Override
    public String toString() {
        return "Logement [superficie=" + superficie + ", classeEnergetique=" + classeEnergetique + ", impact=" + impact
                + "]";
    }

    public static String empreinteMoyLogement() {
        return "Empreinte moyenne du logement par individu : " + (totalImpact / cptIndividu);
    }

}