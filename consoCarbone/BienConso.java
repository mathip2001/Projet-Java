package consoCarbone;

import consoCarbone.Exceptions.ExceptionMontantBienConso;

/**
 * Un objet issu de la classe BienConso permet de calculer l'impact carbone
 * lié aux dépenses en biens de consommation d'une personne
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
 */

public class BienConso extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private double montant; // le montant des dépenses annuelles de l’utilisateur.rice.

    private final int c1 = 1750; // On fait l’hypothèse simplificatrice qu’une tonne de CO2eq est équivalente à
                                 // 1750€ de dépenses.

    // Constructeur
    public BienConso(double montant) throws ExceptionMontantBienConso {
        super();
        // une tonne de CO2eq est équivalente à 1750€ de dépenses.
        this.montant = montant;
        impact = impactFormula();
        if (montant < 0) {
            throw new ExceptionMontantBienConso();
        }
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * lié à ses dépenses
     * 
     * @return l'impact d'après la formule : montant / c1
     */
    public double impactFormula() {
        return montant / c1;
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
     * @param représente le nouveau montant des dépenses annuelles des bienConso de
     *                   l'utilisateur.rice
     */
    public void setMontant(double montant) {
        this.montant = montant;
        this.impact = impactFormula();
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
        return "BienConso : " + super.toString() + ", montant=" + montant;
    }

    /**
     * La méthode empreinteMoyBienConso permet de donner l'empreinte carbone
     * moyenne d'un.e français.e lié à son logement
     */
    public static void empreinteMoyBienConso() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport aux biens consommes :");
        System.out.println("Habillement : 763 Kg eq CO2/an");
        System.out.println("Achats et usages Internet et technologies : 1180 Kg eq CO2/an");
        System.out.println("Autres Biens et Services : 682 Kg eq CO2/an");
    }

}
