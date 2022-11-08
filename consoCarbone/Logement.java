package consoCarbone;

public class Logement extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private int superficie; // la superficie du logement en m2
    private CE classeEnergetique; // la classe énergétique du logement

    // Constructeur
    public Logement(int superficie, CE classeEnergetique) {
        super();
        this.superficie = superficie;
        this.classeEnergetique = classeEnergetique;
        impact = superficie * this.classeEnergetique.getCoefficient();
    }

    // getter et setter
    public int getSuperficie() {
        return superficie;
    }

    public CE getClasseEnergetique() {
        return classeEnergetique;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setClasseEnergetique(CE classeEnergetique) {
        this.classeEnergetique = classeEnergetique;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public double getImpact() {
        return impact;
    }

    public int getID() {
        return ID;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Logement [" + super.toString() + ", superficie=" + superficie + ", classeEnergetique="
                + classeEnergetique
                + "]";
    }

    // Méthode de classe empreinteMoyLogement
    public static void empreinteMoyLogement() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport au logement :");
        System.out.println("Equipements des logements : 335 Kg eq CO2/an");
        System.out.println("Construction & gros entretien : 675 Kg eq CO2/an");
        System.out.println("Energie et utilites : 1696 Kg eq CO2/an");
    }

    // Méthode compareTo
    public int compareTo(ConsoCarbone o) {
        int res = -1;
        Logement l = (Logement) o;

        if (this.getImpact() > l.getImpact()) {
            res = 1;
        }

        if ((this.getImpact() == l.getImpact())) {
            res = 0;
        }

        return res;
    }

}