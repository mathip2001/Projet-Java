package consoCarbone;

/**
 * Un objet issu de la classe Metro permet de calculer l'impact carbone lié à
 * l'utilisation du métro par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public class Metro extends Train {
    // Constructeur
    public Metro(boolean utilise, int kilomAnnee) throws NbKilometresException {
        super(kilomAnnee);
        this.utilise = utilise;
        impact = impactFormula();
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant le métro
     * 
     * @return 0 si l'utilisateur.trice n'utilise pas le métro
     *         ou l'impact d'après la formule : "3.8 * 10^-6 * kilomAnnee" sinon
     */
    public double impactFormula() {
        if (!utilise) {
            return 0;
        } else {
            return 3.8 * Math.pow(10, -6) * kilomAnnee;
        }
    }

    /**
     * La méthode setUtilise permet de modifier le statut de l'utilisation du
     * métro de l'utilisateur.rice
     * 
     * @param utilise représente la nouvelle situation d'utilisation ou non du
     *                métro par l'utilisateur.rice
     */
    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
        this.impact = impactFormula();
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus en métro par an par l'utilisateur.rice
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus en
     *                   métro par an
     *                   par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * Métro
     * 
     * @return les attributs d'une instance Métro
     */
    @Override
    public String toString() {
        return super.toString() + "\noù le mode de transport est le métro";
    }
}
