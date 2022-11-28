package consoCarbone;

/**
 * Un objet issu de la classe BienConso permet de calculer l'impact carbone
 * lié aux dépenses d'une personne
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */

public class BienConso extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private double montant; // le montant des dépenses annuelles de l’utilisateur.rice.

    // Constructeur
    public BienConso(double montant) {
        super();
        // une tonne de CO2eq est équivalente à 1750€ de dépenses.
        this.montant = montant;
        impact = montant / 1750;
    }

    // getter et setter
    /**
     * La méthode getMontant permet de récupérer le montant des dépenses annuelles
     * des bienConso de l'utilisateur.rice d'une instance BienConso
     * 
     * @return le montant des dépenses annuelles des bienConso de l'utilisateur.rice
     *         d'une instance BienConso
     */
    public double getMontant() {
        return montant;
    }

    /**
     * La méthode setMontant permet de modifier le montant des dépenses annuelles
     * des bienConso de l'utilisateur.rice d'une instance BienConso
     * 
     * @param représente le montant des dépenses annuelles des bienConso de
     *                   l'utilisateur.rice
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * La méthode getImpact permet de récupérer l'impact des dépenses annuelles des
     * bienConso de l'utilisateur en termes d'émissions de GES en TCO2eq
     * 
     * @return l'impact des dépenses annuelles des bienConso de l'utilisateur en
     *         termes d'émissions de GES en TCO2eq
     */
    public double getImpact() {
        return impact;
    }

    /**
     * La méthode setImpact permet de modifier l'impact des dépenses annuelles des
     * bienConso de l'utilisateur.rice en termes d'émissions de GES en TCO2eq
     * 
     * @param impact représente l'impact des dépenses annuelles de bienConso de
     *               l'utilisateur.rice en termes d'émissions de GES en TCO2eq
     */
    public void setImpact(double impact) {
        this.impact = impact;
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
     * BienConso
     * 
     * @return les attributs d'une instance BienConso
     */
    @Override
    public String toString() {
        return "BienConso [" + super.toString() +
                ", montant=" + montant +
                ']';
    }

    /**
     * La méthode empreinteMoyAlimentation permet de donner l'empreinte carbone
     * moyenne d'un.e français.e lié à son logement
     */
    public static void empreinteMoyBienConso() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport aux biens consommes :");
        System.out.println("Habillement : 763 Kg eq CO2/an");
        System.out.println("Achats et usages Internet et technologies : 1180 Kg eq CO2/an");
        System.out.println("Autres Biens et Services : 682 Kg eq CO2/an");
    }

    /**
     * @param o
     * @return int
     */
    // Méthode compareTo
    public int compareTo(ConsoCarbone o) {
        int res = -1;
        BienConso b = (BienConso) o;

        if (this.getImpact() > b.getImpact()) {
            res = 1;
        }

        if ((this.getImpact() == b.getImpact())) {
            res = 0;
        }

        return res;
    }
}
