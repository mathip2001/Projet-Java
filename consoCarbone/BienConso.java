package consoCarbone;

public class BienConso extends ConsoCarbone {
    // Attributs
    // Pour information l'attribut impact est dans la classe mere : ConsoCarbone
    private double montant; // le montant des dépenses annuelles de l’utilisateur.rice.

    // Constructeur
    public BienConso(double montant) {
        super();
        // une tonne de CO2eq est équivalente à 1750€ de dépenses.
        this.montant = montant;
        impact = impactFormula();
    }

    public double impactFormula() {
        return montant / 1750;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "BienConso [" + super.toString() +
                ", montant=" + montant +
                ']';
    }

    // getter et setter
    public double getMontant() {
        return montant;
    }

    public double getImpact() {
        return impact;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public int getID() {
        return ID;
    }

    // Méthode de classe empreinteMoyBienConso
    public static void empreinteMoyBienConso() {
        System.out.println("Empreinte carbone moyenne d'un francais par rapport aux biens consommes :");
        System.out.println("Habillement : 763 Kg eq CO2/an");
        System.out.println("Achats et usages Internet et technologies : 1180 Kg eq CO2/an");
        System.out.println("Autres Biens et Services : 682 Kg eq CO2/an");
    }

    // Méthode compareTo
    public int compareTo(ConsoCarbone o) {
        int res = -1;
        BienConso b = (BienConso) o;

        if (this.getImpact() > b.getImpact()) {
            res = 1;
        }

        if ((this.getImpact() == b.getImpact())) {
            res = 0;
        }

        return res;
    }
}
