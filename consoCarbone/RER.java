package consoCarbone;

/**
 * Un objet issu de la classe RER permet de calculer l'impact carbone lié à
 * l'utilisation du RER par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public class RER extends Train {
    // Constructeur
    public RER(boolean utilise, int kilomAnnee) {
        super(kilomAnnee);
        this.utilise = utilise;
        impact = impactFormula();
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant le RER
     * 
     * @return 0 si l'utilisateur.trice n'utilise pas le RER
     *         ou l'impact d'après la formule : "6.2 * 10^-6 * kilomAnnee" sinon
     */
    public double impactFormula() {
        if (!utilise) {
            return 0;
        } else {
            return 6.2 * Math.pow(10, -6) * kilomAnnee;
        }
    }

    /**
     * La méthode setUtilise permet de modifier le statut de l'utilisation du
     * RER de l'utilisateur.rice 
     * 
     * @param utilise représente la nouvelle situation d'utilisation ou non du
     *                RER par l'utilisateur.rice
     */
    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
        this.impact = impactFormula();
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus en RER par an par l'utilisateur.rice
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus en RER par an
     *                   par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * RER
     * 
     * @return les attributs d'une instance RER
     */
    @Override
    public String toString() {
        return super.toString() + "\n où le mode de transport est le RER";
    }
}
