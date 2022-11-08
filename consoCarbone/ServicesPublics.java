package consoCarbone;

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

    // Méthode toString
    @Override
    public String toString() {
        return "ServicesPublics [" + super.toString() + "]";
    }

    // getter et setter
    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public int getID() {
        return ID;
    }

    // Méthode getInstance
    public static ServicesPublics getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    // Méthode de classe empreinteMoyServicesPublics
    public static void empreinteMoyServicesPublics() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport aux services publics :");
        System.out.println("Services Publics, Sante : 1489 Kg eq CO2/an");
    }

    // Méthode compareTo
    @Override
    public int compareTo(ConsoCarbone o) {
        return 0;
    }
}