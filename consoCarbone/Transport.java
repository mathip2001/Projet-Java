package consoCarbone;

/**
 * Un objet issu de la classe Transport permet de calculer l'impact carbone
 * lié au transport d'une personne
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */

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
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant les transports
     * 
     * @return 0 si l'utilisateur.trice ne possède pas de voiture
     *         ou retourne l'impact d'après la formule : kilomAnnee x 1.92 x 10^-4 +
     *         fabrication/amortissement
     */
    public double impactFormula() {
        if (!possede) {
            return 0;
        } else {
            return kilomAnnee * 1.93 * Math.pow(10, -4) + this.taille.getProduction() / amortissement;
        }
    }

    // getter et setter
    /**
     * La méthode isPossede permet de savoir si l'utilisateur.rice possède une
     * voiture dans une instance Transport
     * 
     * @return true si l'utilisateur possède une voiture, sinon retourne false si
     *         l'utilisateur ne possède pas de voiture dans une instance Transport
     */
    public boolean isPossede() {
        return possede;
    }

    /**
     * La méthode setPossede permet de modifier le statut de la possession d'une
     * voiture de l'utilisateur dans une instance Transport
     * 
     * @param possede représente la nouvelle situation de possession ou non d'une
     *                voiture par l'utilisateur.rice
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
        this.impact = impactFormula();
    }

    /**
     * La méthode getTaille permet de récupérer la taille du véhicule de
     * l'utilisateur.rice d'une instance Logement
     * 
     * @return la taille du véhicule de l'utilisateur.rice d'une instance Logement
     */
    public Taille getTaille() {
        return taille;
    }

    /**
     * La méthode setTaille permet de la taille du véhicule de l'utilisateur.rice
     * d'une instance Logement
     * 
     * @param taille représente la taille du nouveau véhicule de l'utilisateur.rice
     */
    public void setTaille(Taille taille) {
        this.taille = taille;
        this.impact = impactFormula();
    }

    /**
     * La méthode getKilomAnnee permet de récupérer le nombre de kilomètres
     * parcourus par an par l'utilisateur.rice d'une instance Transport
     * 
     * @return le nombre de kilomètres parcourus par an par l'utilisateur.rice d'une
     *         instance Transport
     */
    public int getKilomAnnee() {
        return kilomAnnee;
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus par an par l'utilisateur.rice d'une instance Transport
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus par an
     *                   par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();

    }

    /**
     * La méthode getAmortissement permet de récupérer la durée de conservation du
     * véhicule d'une instance Transport
     * 
     * @return la durée de conservation du véhicule d'une instance Transport
     */
    public int getAmortissement() {
        return amortissement;
    }

    /**
     * La méthode setAmortissement permet de modifier la durée de conservation du
     * véhicule d'une instance Transport
     * 
     * @param amortissement représente la nouvelle durée de conservation du véhicule
     */
    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
        this.impact = impactFormula();

    }

    /**
     * La méthode getImpact permet de récupérer l'impact du transport de
     * l'utilisateur en termes d'émissions de GES en TCO2eq
     * 
     * @return l'impact du transport de l'utilisateur en termes d'émissions de GES
     *         en TCO2eq
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
     * Transport
     * 
     * @return les attributs d'une instance Transport
     */
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
     * La méthode empreinteMoyTransport permet de donner l'empreinte carbone
     * moyenne d'un.e français.e lié au transport
     */
    public static void empreinteMoyTransport() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport au transport :");
        System.out.println("Voiture : 1972 Kg eq CO2/an");
        System.out.println("Avion : 480 Kg eq CO2/an");
        System.out.println("Fret et messagerie : 383 Kg eq CO2/an");
        System.out.println("Train et bus : 85 Kg eq CO2/an");
    }

}
