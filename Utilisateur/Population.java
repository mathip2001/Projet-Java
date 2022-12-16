package Utilisateur;

import java.util.ArrayList;

/**
 * Un objet issu de la classe Population permet de regrouper l'ensemble des
 * Utilisateurs
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public class Population {
    // Attributs
    private static Population instance = null;
    private ArrayList<Utilisateur> listePopulation;

    // Constructeur
    private Population() {
        listePopulation = new ArrayList<>();
    }

    public static void createInstance() {
        if (instance == null) {
            instance = new Population();
        }
    }

    // getter
    /**
     * La méthode getInstance permet de récupérer l'unique instance Population
     * si elle a été créée. Dans le cas échéant, une instance Population sera
     * créée.
     * 
     * @return l'unique instance Population
     */
    public static Population getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    /**
     * La méthode add permet d'ajouter des utilisateurs au sein d'une population
     * 
     * @param utilisateur
     */
    public void add(Utilisateur utilisateur) {
        listePopulation.add(utilisateur);
    }

    /**
     * La méthode listing permet de lister les consommations carbones triées
     * utilisateur par utilisateur
     */
    public void listing() {
        System.out.println("Population :");
        int tmp = 0;
        for (Utilisateur u : listePopulation) {
            System.out.println("Utilisateur : " + tmp);
            u.trier();
            tmp++;
        }
    }
}