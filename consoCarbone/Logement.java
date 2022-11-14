package consoCarbone;

/*
 * La classe Logement 
 */

public class Logement extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private int superficie; // la superficie du logement en m2
    private CE classeEnergetique; // la classe énergétique du logement

    // Constructeur
    public Logement(int superficie, CE classeEnergetique) {
        super();
        this.superficie = superficie;
        this.classeEnergetique = classeEnergetique;
        impact = superficie * this.classeEnergetique.getCoefficient();
    }

    // getter et setter
    /**
     * La fonction getSuperficie() permet de récupérer la superficie du Logement
     * 
     * @return int
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * La fonction getClasseEnergetique() permet de récupérer la classe énergétique
     * du Logement
     * 
     * @return CE
     */
    public CE getClasseEnergetique() {
        return classeEnergetique;
    }

    /**
     * La fonction setSuperficie() permet de modifier la superficie du Logement
     * 
     * @param superficie
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    /**
     * La fonction setClasse
     * 
     * @param classeEnergetique
     */
    public void setClasseEnergetique(CE classeEnergetique) {
        this.classeEnergetique = classeEnergetique;
    }

    /**
     * @param impact
     */
    public void setImpact(double impact) {
        this.impact = impact;
    }

    /**
     * @return double
     */
    public double getImpact() {
        return impact;
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
        return "Logement [" + super.toString() + ", superficie=" + superficie + ", classeEnergetique="
                + classeEnergetique
                + "]";
    }

    // Méthode de classe empreinteMoyLogement
    public static void empreinteMoyLogement() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport au logement :");
        System.out.println("Equipements des logements : 335 Kg eq CO2/an");
        System.out.println("Construction & gros entretien : 675 Kg eq CO2/an");
        System.out.println("Energie et utilites : 1696 Kg eq CO2/an");
    }

    /**
     * @param o
     * @return int
     */
    // Méthode compareTo
    public int compareTo(ConsoCarbone o) {
        int res = -1;
        Logement l = (Logement) o;

        if (this.getImpact() > l.getImpact()) {
            res = 1;
        }

        if ((this.getImpact() == l.getImpact())) {
            res = 0;
        }

        return res;
    }

}