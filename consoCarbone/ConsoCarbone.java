package consoCarbone;

import java.lang.Comparable;

/**
 * consoCarbone représente un poste de consommation carbone générique
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */

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
     * La méthode toString permet de donner un aperçu des attributs génériques d'un
     * poste de consommation carbone
     * 
     * @return les attributs génériques d'un poste de consommation carbone
     */
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
