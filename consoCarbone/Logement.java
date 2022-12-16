package consoCarbone;

/**
 * Un objet issu de la classe Logement permet de calculer l'impact carbone
 * lié au logement d'une personne
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
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
        impact = ImpactFormula();
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * lié à ses logements
     * 
     * @return l'impact d'après la formule : this.superficie *
     *         this.classeEnergetique.getCoefficient();
     */
    public double ImpactFormula() {
        return this.superficie * this.classeEnergetique.getCoefficient();
    }

    // getter et setter
    /**
     * La méthode getSuperficie permet de récupérer la superficie d'une instance
     * Logement
     * 
     * @return la superficie d'une instance Logement
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * La méthode setSuperficie permet de modifier la superficie d'une instance
     * Logement
     * 
     * @param représente la nouvelle superficie d'une instance Logement
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
        this.impact = ImpactFormula();
    }

    /**
     * La méthode getClasseEnergetique permet de récupérer la classe énergétique
     * d'une instance Logement
     * 
     * @return la classe énergétique d'une instance Logement
     */
    public CE getClasseEnergetique() {
        return classeEnergetique;
    }

    /**
     * La méthode setClasseEnergétique permet de modifier la classe énergétique
     * d'une instance Logement
     * 
     * @param représente la nouvelle classe énergétique d'une instance Logement
     */
    public void setClasseEnergetique(CE classeEnergetique) {
        this.classeEnergetique = classeEnergetique;
        this.impact = ImpactFormula();
    }

    /**
     * La méthode getImpact permet de récupérer l'impact du logement de
     * l'utilisateur en termes d'émissions de GES en TCO2eq
     * 
     * @return l'impact de l'alimentation de l'utilisateur en termes d'émissions de
     *         GES en TCO2eq
     */
    public double getImpact() {
        return impact;
    }

    /**
     * La méthode getID permet de récupérer l'identifiant (unique) attribué à
     * l'instance
     * 
     * @return l'identifiant attribué à l'instance
     */
    public int getID() {
        return ID;
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * Logement
     * 
     * @return les attributs d'une instance Logements
     */
    @Override
    public String toString() {
        return "Logement : " + super.toString() + ", superficie=" + superficie + ", classeEnergetique="
                + classeEnergetique;
    }

    /**
     * La méthode empreinteMoyLogement permet de donner l'empreinte carbone
     * moyenne d'un.e français.e lié à son logement
     */
    public static void empreinteMoyLogement() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport au logement :");
        System.out.println("Equipements des logements : 335 Kg eq CO2/an");
        System.out.println("Construction & gros entretien : 675 Kg eq CO2/an");
        System.out.println("Energie et utilites : 1696 Kg eq CO2/an");
    }

}