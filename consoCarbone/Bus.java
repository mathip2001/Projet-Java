package consoCarbone;

import consoCarbone.Exceptions.ExceptionNbKilometresTransport;

/**
 * Un objet issu de la classe Bus permet de calculer l'impact carbone lié à
 * l'utilisation du bus par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
 */
public class Bus extends Transport {
    // Attributs
    private boolean utilise; // un boolean indiquant si l'utilisateur.rice utilise le bus

    // Constructeur
    public Bus(boolean utilise, int kilomAnnee) throws ExceptionNbKilometresTransport {
        super(kilomAnnee);
        this.utilise = utilise;
        impact = impactFormula();
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant le bus
     * 
     * @return 0 si l'utilisateur.trice n'utilise pas le bus
     *         ou l'impact d'après la formule : "1.04 * 10^-4 * kilomAnnee" sinon
     */
    public double impactFormula() {
        if (!utilise) {
            return 0;
        } else {
            return 1.04 * Math.pow(10, -4) * kilomAnnee;
        }
    }

    /**
     * La méthode getUtilise permet de savoir si l'utilisateur.rice utilise
     * le bus en tant que moyen de transport
     * 
     * @return true si l'utilisateur utilise le bus, false sinon
     */
    public boolean getUtilise() {
        return utilise;
    }

    /**
     * La méthode setUtilise permet de modifier le statut de l'utilisation du
     * bus de l'utilisateur.rice
     * 
     * @param utilise représente la nouvelle situation d'utilisation ou non du
     *                bus par l'utilisateur.rice
     */
    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
        this.impact = impactFormula();
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus en bus par an par l'utilisateur.rice
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus en bus
     *                   par an
     *                   par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * bus
     * 
     * @return les attributs d'une instance bus
     */
    @Override
    public String toString() {
        return super.toString() + ", utilise=" + utilise + "\noù le mode de transport est le bus";
    }
}
