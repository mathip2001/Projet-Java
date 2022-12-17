package consoCarbone;

/**
 * Un objet issu de la classe Avion permet de calculer l'impact carbone lié à
 * l'utilisation de l'avion par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public class Avion extends Transport {
    // Attributs
    private boolean utilise; // un boolean indiquant si l'utilisateur.rice utilise un avion

    // Constructeur
    public Avion(boolean utilise, int kilomAnnee) throws NbKilometresException {
        super(kilomAnnee);
        this.utilise = utilise;
        impact = impactFormula();
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant l'avion
     * 
     * @return 0 si l'utilisateur.trice n'utilis pas l'avion
     *         ou l'impact d'après la formule : "((3 * kilomAnnee) / 100) * 3.1 *
     *         10^-3" sinon
     */
    public double impactFormula() {
        if (!utilise) {
            return 0;
        } else {
            return ((3 * kilomAnnee) / 100) * 3.1 * Math.pow(10, -3);
        }
    }

    /**
     * La méthode getUtilise permet de savoir si l'utilisateur.rice utilise
     * l'avion en tant que moyen de transport
     * 
     * @return true si l'utilisateur utilise l'avion, false sinon
     */
    public boolean getUtilise() {
        return utilise;
    }

    /**
     * La méthode setUtilise permet de modifier le statut de l'utilisation de
     * l'avion de l'utilisateur.rice dans une instance Transport
     * 
     * @param utilise représente la nouvelle situation d'utilisation ou non de
     *                l'avion par l'utilisateur.rice
     */
    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
        this.impact = impactFormula();
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus en avion par an par l'utilisateur.rice d'une instance Transport
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus en
     *                   avion par an
     *                   par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * Avion
     * 
     * @return les attributs d'une instance Avion
     */
    @Override
    public String toString() {
        return super.toString() + ", utilise=" + utilise + "\noù le mode de transport est l'avion";
    }
}