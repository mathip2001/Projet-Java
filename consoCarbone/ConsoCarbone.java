package consoCarbone;

public abstract class ConsoCarbone {
    protected double impact;
    private int ID; // identifiant unique attribué à l’instance
    private static int cmptID = 0;

    public ConsoCarbone() {
        this.ID = cmptID++;
    }

    @Override
    public String toString() {
        return "ConsoCarbone [" +
                "ID=" + ID +
                ", impact=" + impact +
                ']';
    }
}
