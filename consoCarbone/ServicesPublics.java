package consoCarbone;

/**
 * Un objet issu de la classe ServicesPublics représentent le poste de
 * consommation induit par les services publics (justice, police, éducation,
 * santé, ...). L'objet ServicesPublics est unique. Le design patter que l'on a
 * utilisé est le singleton
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */

public class ServicesPublics extends ConsoCarbone {
    // Attribut
    private static ServicesPublics instance = null;

    // Constructeur
    private ServicesPublics() {
        super();
        impact = 1.5;
    }

    private static void createInstance() {
        if (instance == null) {
            instance = new ServicesPublics();
        }
    }

    // getter
    /**
     * La méthode getInstance permet de récupérer l'unique instance ServicesPublics
     * si elle a été créée. Dans le cas échéant, une instance ServicesPublics sera
     * créée.
     * 
     * @return l'unique instance ServicesPublics
     */
    public static ServicesPublics getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    /**
     * La méthode getImpact permet de récupérer l'impact des services publics en
     * termes d'émissions de GES en TCO2eq
     * 
     * @return l'impact des services publics en termes d'émissions de
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
     * La méthode toString permet de donner un aperçu des attributs de l'instance
     * ServicesPublics
     * 
     * @return les attributs d'une instance ServicesPublics
     */
    @Override
    public String toString() {
        return "ServicesPublics : " + super.toString();
    }

    /**
     * La méthode empreinteMoyServicesPublics permet de donner l'empreinte carbone
     * moyenne des services publics
     */
    public static void empreinteMoyServicesPublics() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport aux services publics :");
        System.out.println("Services Publics, Sante : 1489 Kg eq CO2/an");
    }

}