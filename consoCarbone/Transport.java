package consoCarbone;

import consoCarbone.Exceptions.ExceptionNbKilometresTransport;

/**
 * Un objet issu de la classe Transport permet de calculer l'impact carbone
 * lié au transport d'une personne
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
 */
public class Transport extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    protected int kilomAnnee;// nombre de kilomètres parcourus par an.

    // Constructeur
    public Transport(int kilomAnnee) throws ExceptionNbKilometresTransport {
        super();
        this.kilomAnnee = kilomAnnee;
        if (kilomAnnee <= 0) {
            throw new ExceptionNbKilometresTransport();
        }
    }

    // getter et setter
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
        return "Transport : " + super.toString() +
                ", kilomAnnee=" + kilomAnnee;
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
