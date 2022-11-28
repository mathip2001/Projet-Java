package consoCarbone2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

import consoCarbone.*;

/**
 * Un objet issu de la classe Utilisateur permet de regrouper l'impact carbone
 * d'un utilisateur.rice dans tous les secteurs de consommation (ceux traités
 * dans le package consoCarbone)
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;
    private ServicesPublics services;
    private ArrayList<ConsoCarbone> liste = new ArrayList<>();

    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport,
            ServicesPublics services) {
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logement = logement;
        this.transport = transport;
        this.services = services;
        liste.add(alimentation);
        liste.add(bienConso);
        liste.add(logement);
        liste.add(transport);
        liste.add(services);
    }

    /**
     * La méthode calculerEmpreinte permet de calculer les empreintes carbones d'une
     * instance Utilisateur
     * 
     * @return les empreintes carbones d'une instance Utilisateur
     */
    public double calculerEmpreinte() {
        return alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + transport.getImpact()
                + services.getImpact();
    }

    /**
     * La méthode detaillerEmpreinte permet de détailler les empreintes carbones
     * d'une instance Utilisateur
     */
    public void detaillerEmpreinte() {
        String res = "";
        res = res + "impact de l'alimentation : " + String.format("%.2f\n", alimentation.getImpact())
                + "impact de bienConso : "
                + String.format("%.2f\n", bienConso.getImpact()) + "impact du logement : "
                + String.format("%.2f\n", logement.getImpact()) + "impact du transport : "
                + String.format("%.2f\n", transport.getImpact()) + "impact du service public : "
                + String.format("%.2f\n", services.getImpact());
        System.out.println(res);

    }

    public void trier() {
        System.out.println("Affichage de la liste triee :");
        Collections.sort(liste);
        for (ConsoCarbone c : liste) {
            System.out.println(c.toString());
        }
    }
}