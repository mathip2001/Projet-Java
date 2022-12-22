package consoCarbone;

import consoCarbone.Exceptions.ExceptionTauxAlimentation;

/**
 * Un objet issu de la classe Alimentation permet de calculer l'impact carbone
 * lié à l'alimentation d'une personne
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
 */

public class Alimentation extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private double txBoeuf; // le taux de repas (une valeur entre 0 et 1) à base de boeuf (le type de viande
                            // le plus émissif)
    private double txVege; // txVege, le taux de repas végétariens

    private final double c1 = 8.0;
    private final double c2 = 1.6;
    private final double c3 = 0.9;

    // Constructeur
    /**
     * Permet de construire un objet issu de la classe Alimentation
     * @param txBoeuf représente le taux de repas à base de boeuf
     * @param txVege représente le taux de repas végétarien
     * @throws ExceptionTauxAlimentation est une exception qui s'enclenche lorsque le taux n'est pas entre 0 et 1
     */
    public Alimentation(double txBoeuf, double txVege) throws ExceptionTauxAlimentation {
        super();
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.impact = impactFormula();
        if ((txBoeuf < 0) || (txBoeuf > 1) || (txVege < 0) || (txVege > 1)) {
            throw new ExceptionTauxAlimentation();
        }
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * lié à l'alimentation
     * 
     * @return l'impact d'après la formule : c1 * txBoeuf + c2 * (1 - txVege -
     *         txBoeuf) + c3 * txVege
     */
    public double impactFormula() {
        return c1 * txBoeuf + c2 * (1 - txVege - txBoeuf) + c3 * txVege;
    }

    // getter et setter
    /**
     * La méthode getTxBoeuf permet de récupérer le taux de repas à base de boeuf
     * d'une instance Alimentation
     * 
     * @return une valeur entre 0 et 1 qui est le taux de repas à base de boeuf
     *         d'une instance Alimentation
     */
    public double getTxBoeuf() {
        return txBoeuf;
    }

    /**
     * La méthode setTxBoeuf permet de modifier le taux de repas à base de boeuf
     * d'une instance Alimentation
     * 
     * @param txBoeuf représente le nouveau taux de repas à base de boeuf
     */
    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
        this.impact = impactFormula();
    }

    /**
     * La méthode getTxVege permet de récupérer le taux de repas végétarien
     * d'une instance Alimentation
     * 
     * @return une valeur entre 0 et 1 qui est le taux de repas végétarien
     *         d'une instance Alimentation
     */
    public double getTxVege() {
        return txVege;
    }

    /**
     * La méthode setTxVege permet de modifier le taux de repas végétarien
     * d'une instance Alimentation
     * 
     * @param txVege représente le nouveau taux de repas végétarien
     */
    public void setTxVege(double txVege) {
        this.txVege = txVege;
        this.impact = impactFormula();
    }

    /**
     * La méthode getImpact permet de récupérer l'impact de l'alimentation de
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
     * Alimentation
     * 
     * @return les attributs d'une instance Alimentation
     */
    @Override
    public String toString() {
        return "Alimentation : " + super.toString() + ", txBoeuf=" + txBoeuf + ", txVege=" + txVege;
    }

    /**
     * La méthode empreinteMoyAlimentation permet d'afficher l'empreinte carbone
     * moyenne d'un.e français.e lié à son alimentation
     */
    public static void empreinteMoyAlimentation() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport a l'alimentation :");
        System.out.println("Boissons : 263 Kg eq CO2/an");
        System.out.println("Produits laitiers et oeufs : 408 Kg eq CO2/an");
        System.out.println("Viandes et Poissons : 1144 Kg eq CO2/an");
        System.out.println("Autres : 538 Kg eq CO2/an");
    }

}