package consoCarbone;

import java.lang.Comparable;

/**
 * consoCarbone représente un poste de consommation carbone générique
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
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

    /**
     * La méthode compareTo permet de comparer l'impact en termes d'émissions de GES
     * de deux objets du package consoCarbone
     * 
     * @return 1) un entier négatif si l'objet est plus petit que l'objet passé en
     *         paramètre
     *         2) zéro s'ils sont égaux
     *         3) un entier positif si l'objet est plus grand que l'objet passé en
     *         paramètre
     */
    @Override
    public int compareTo(ConsoCarbone o) {
        if (this.impact > o.impact){
            return 1;
        }
        else if (this.impact < o.impact){
            return -1;
        }
        return 0;
    }

    // Méthodes abstraites
    public abstract double getImpact();

    public abstract int getID();
}
