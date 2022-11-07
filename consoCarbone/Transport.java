package consoCarbone;

public class Transport extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private boolean possede; // un boolean indiquant si l’utilisateur.rice possède une voiture.
    private Taille taille; // la taille du véhicule.
    private int kilomAnnee;// nombre de kilomètres parcourus par an.
    private int amortissement;// durée de conservation du véhicule.

    // Constructeur
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
        super();
        this.possede = possede;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;
        this.impact = impactFormula();
    }

    public double impactFormula() {
        if (!possede)
            return 0;
        switch (taille) {
            case G:
                return kilomAnnee * 1.93 * Math.pow(10, -4) + 19 / amortissement;
            case P:
                return kilomAnnee * 1.93 * Math.pow(10, -4) + 4.2 / amortissement;
            default:
                return -1;
        }

    }

    // Méthode toString
    @Override
    public String toString() {
        // super.toString() ?
        return "Transport [" +
                "possede=" + possede +
                ", taille=" + taille +
                ", kilomAnnee=" + kilomAnnee +
                ", amortissement=" + amortissement +
                ", impact=" + String.format("%.2f", impact) + ']';
    }

    // getter et setter
    public boolean isPossede() {
        return possede;
    }

    public void setPossede(boolean possede) {
        this.possede = possede;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public int getKilomAnnee() {
        return kilomAnnee;
    }

    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
    }

    public int getAmortissement() {
        return amortissement;
    }

    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    // Méthode compareTo
    public int compareTo(ConsoCarbone o) {
        int res = -1;
        Transport t = (Transport) o;

        if (this.getImpact() > t.getImpact()) {
            res = 1;
        }

        if ((this.getImpact() == t.getImpact())) {
            res = 0;
        }

        return res;
    }

}
