package consoCarbone;

public class ServicesPublics extends ConsoCarbone {
    // Attribut
    private double empreinte;

    // Constructeur
    public ServicesPublics() {
        this.empreinte = 1.5;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ServicesPublics [empreinte=" + empreinte + "]";
    }

    // getter et setter
    public double getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(double empreinte) {
        this.empreinte = empreinte;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

}