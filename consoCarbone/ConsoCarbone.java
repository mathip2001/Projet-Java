package consoCarbone;

import java.lang.Comparable;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
    // Attributs
    protected double impact;
    protected int ID; // identifiant unique attribué à l’instance
    private static int cmptID = 0;

    // Constructeur
    public ConsoCarbone() {
        this.ID = cmptID;
        cmptID++;
    }

    /**
     * @return String
     */
    // Méthode toString
    @Override
    public String toString() {
        return "ID=" + ID +
                ", impact=" + String.format("%.2f", impact);
    }

    // Méthodes abstraites
    public abstract double getImpact();

    public abstract void setImpact(double impact);

    public abstract int getID();

    public abstract int compareTo(ConsoCarbone o);
}
