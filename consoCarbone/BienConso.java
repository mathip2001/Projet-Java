package consoCarbone;

public class BienConso extends ConsoCarbone {
    // Attributs
    private double montant; // le montant des dépenses annuelles de l’utilisateur.rice.

    // Constructeur
    public BienConso(double montant) {
        super(); // une tonne de CO2eq est équivalente à 1750€ de dépenses.
        this.montant = montant;
        this.impact = impactFormula();
    }

    public double impactFormula() {
        return montant / 1750;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "BienConso [" +
                "montant=" + montant +
                ", impact=" + String.format("%.2f", impact) +
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

}
