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
        impact = impactFormula();
    }

    /**
     * @return double
     */
    public double impactFormula() {
        if (!possede) {
            return 0;
        } else {
            return kilomAnnee * 1.93 * Math.pow(10, -4) + this.taille.getProduction() / amortissement;
        }
    }

    /**
     * @return String
     */
    // Méthode toString
    @Override
    public String toString() {
        return "Transport [" + super.toString() +
                ", possede=" + possede +
                ", taille=" + taille +
                ", kilomAnnee=" + kilomAnnee +
                ", amortissement=" + amortissement +
                ']';
    }

    /**
     * @return boolean
     */
    // getter et setter
    public boolean isPossede() {
        return possede;
    }

    /**
     * @param possede
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
    }

    /**
     * @return Taille
     */
    public Taille getTaille() {
        return taille;
    }

    /**
     * @param taille
     */
    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    /**
     * @return int
     */
    public int getKilomAnnee() {
        return kilomAnnee;
    }

    /**
     * @param kilomAnnee
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
    }

    /**
     * @return int
     */
    public int getAmortissement() {
        return amortissement;
    }

    /**
     * @param amortissement
     */
    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
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

    // Méthode de classe empreinteMoyTransport
    public static void empreinteMoyTransport() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport au transport :");
        System.out.println("Voiture : 1972 Kg eq CO2/an");
        System.out.println("Avion : 480 Kg eq CO2/an");
        System.out.println("Fret et messagerie : 383 Kg eq CO2/an");
        System.out.println("Train et bus : 85 Kg eq CO2/an");
    }

    /**
     * @param o
     * @return int
     */
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
