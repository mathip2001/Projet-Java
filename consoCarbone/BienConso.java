package consoCarbone;

public class BienConso extends ConsoCarbone {
    private double montant; // le montant des dépenses annuelles de l’utilisateur.rice.

    public BienConso(double montant) {
        super(); // une tonne de CO2eq est équivalente à 1750€ de dépenses.
        this.montant = montant;
        this.impact = impactFormula();
    }

    public double impactFormula() {
        return montant / 1750;
    }

    @Override
    public String toString() {
        return "BienConso [" +
                "montant=" + montant +
                ", impact=" + impact +
                ']';
    }

    public double getMontant() {
        return montant;
    }

    public double getImpact() {
        return impact;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
