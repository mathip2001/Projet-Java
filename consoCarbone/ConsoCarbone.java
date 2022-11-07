package consoCarbone;

import java.lang.Comparable;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
    // Attributs
    protected double impact;
    private int ID; // identifiant unique attribué à l’instance
    private static int cmptID = 0;

    // Constructeur
    public ConsoCarbone() {
        this.ID = cmptID;
        cmptID++;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ConsoCarbone [" +
                "ID=" + ID +
                ", impact=" + impact +
                ']';
    }

    // Méthodes abstraites
    public abstract double getImpact();

    public abstract void setImpact(double impact);

    public abstract int compareTo(ConsoCarbone o);
}
