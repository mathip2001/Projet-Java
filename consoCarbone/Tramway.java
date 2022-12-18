package consoCarbone;

import consoCarbone.Exceptions.ExceptionNbKilometresTransport;

/**
 * Un objet issu de la classe Tramway permet de calculer l'impact carbone lié à
 * l'utilisation du tramway par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public class Tramway extends Train {
    // Constructeur
    public Tramway(boolean utilise, int kilomAnnee) throws ExceptionNbKilometresTransport {
        super(kilomAnnee);
        this.utilise = utilise;
        impact = impactFormula();
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant le tramway
     * 
     * @return 0 si l'utilisateur.trice n'utilise pas le tramway
     *         ou l'impact d'après la formule : "3.4 * 10^-6 * kilomAnnee" sinon
     */
    public double impactFormula() {
        if (!utilise) {
            return 0;
        } else {
            return 3.4 * Math.pow(10, -6) * kilomAnnee;
        }
    }

    /**
     * La méthode setUtilise permet de modifier le statut de l'utilisation du
     * tramway de l'utilisateur.rice
     * 
     * @param utilise représente la nouvelle situation d'utilisation ou non du
     *                tramway par l'utilisateur.rice
     */
    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
        this.impact = impactFormula();
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus en tramway par an par l'utilisateur.rice
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus en
     *                   tramway par an par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * tramway
     * 
     * @return les attributs d'une instance tramway
     */
    @Override
    public String toString() {
        return super.toString() + "\noù le mode de transport est le tramway";
    }
}
