package Utilisateur;

import java.util.ArrayList;
import java.util.Collections;

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
    private Alimentation alimentation; // le poste de consommation carbone de l'utilisateur.rice concernant son
                                       // alimentation
    private BienConso bienConso; // le poste de consommation carbone de l'utilisateur.rice concernant ses
                                 // dépenses en biens de consommation
    private Logement logement; // le poste de consommation carbone de l'utilisateur.rice concernant son
                               // logement
    private Transport transport; // le poste de consommation carbone de l'utilisateur.rice concernant ses
                                 // déplacements
    private ServicesPublics services; // le poste de consommation carbone de l'utilisateur.rice concernant son
                                      // utilisation des services publics
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
        String recommendations = "Pour obtenir un mode de vie plus durable :\n";
        // Affichage de la liste triée
        for (ConsoCarbone c : liste) {
            System.out.println(c.toString());
            if (c instanceof Alimentation) {
                Alimentation alim1 = (Alimentation) c;
                if (alim1.getTxBoeuf() > 0.2) {
                    recommendations += " - réduisez votre consommation de viande et de produits d'origine animale\n";
                }
            }
        }
        // Recommandations
        System.out.println(recommendations
                + " - isolez bien votre logement, éteignez vos appareils lorsque vous ne vous en servez plus et utilisez des ampoules LED pour réduire votre consommation énergétique\n"
                + " - résduisez vos dépenses en biens de consommation\n"
                + " - favorisez les transports en communs et déplacez vous à pied ou en vélo pour les trajets courts\n");

    }
}