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
        return "ServicesPublics [impact=" + impact + "]";
    }

    // getter et setter
    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    // Méthode getInstance
    public static ServicesPublics getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    // Méthode compareTo
    @Override
    public int compareTo(ConsoCarbone o) {
        return 0;
    }
}