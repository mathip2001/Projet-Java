package Utilisateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
    // Attributs
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
    private ArrayList<ConsoCarbone> liste;

    // Constructeur
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport,
            ServicesPublics services) {
        liste = new ArrayList<>();
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
        AjouterLogement();
        AjouterVoiture();
    }

    /**
     * La méthode AjouterLogement permet d'ajouter des Logements supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * logements
     */
    public void AjouterLogement() {
        Scanner entree = new Scanner(System.in);
        // Fermer ce scanner uniquement lorsqu'on n'en n'aura plus jms besoin => Tout à
        // la fin du Main. Et mettre le scanner uniqument au début et ne pas le recréer
        // à chaque fois

        System.out.println("Avez-vous un autre logement ? (Oui/Non)");
        String reponse = entree.next();
        Logement log;
        while (reponse.equals("Oui")) {
            System.out.println("Quelle est la superficie du logement ? (en m^2)");
            int superficie = entree.nextInt();
            System.out.println("Quelle est la classe énergétique du logement ? (une lettre de A à G)");
            String classeEnergetique = entree.next();
            switch (classeEnergetique) {
                case "A":
                    log = new Logement(superficie, CE.A);
                    liste.add(log);
                    break;
                case "B":
                    log = new Logement(superficie, CE.B);
                    liste.add(log);
                    break;
                case "C":
                    log = new Logement(superficie, CE.C);
                    liste.add(log);
                    break;
                case "D":
                    log = new Logement(superficie, CE.D);
                    liste.add(log);
                    break;
                case "E":
                    log = new Logement(superficie, CE.E);
                    liste.add(log);
                    break;
                case "F":
                    log = new Logement(superficie, CE.F);
                    liste.add(log);
                    break;
                case "G":
                    log = new Logement(superficie, CE.G);
                    liste.add(log);
                    break;
                default:
                    System.out.println("Vous n'avez pas rentré correctement la classe énergétique de votre logement");
            }
            System.out.println("Avez-vous un autre logement ? (Oui/Non)");
            reponse = entree.next();
        }
        // entree.close();
    }

    /**
     * La méthode AjouterVoiture permet d'ajouter des voitures supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * voitures
     */
    public void AjouterVoiture() {
        java.util.Scanner entree = new java.util.Scanner(System.in);

        System.out.println("Avez-vous une autre voiture ? (Oui/Non)");
        String reponse = entree.next();
        Voiture voiture;
        while (reponse.equals("Oui")) {
            System.out.println(
                    "Quelle est la taille de votre véhicule ? ('G' pour grande voiture ou 'P' pour petite voiture)");
            String taille = entree.next();
            System.out.println("Quel est le nombre de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            System.out.println("Depuis combien d'années avez-vous votre voiture ?");
            int annee = entree.nextInt();
            switch (taille) {
                case "P":
                    voiture = new Voiture(true, Taille.P, km, annee);
                    liste.add(voiture);
                    break;
                case "G":
                    voiture = new Voiture(true, Taille.G, km, annee);
                    liste.add(voiture);
                    break;
                default:
                    System.out.println("Vous n'avez pas rentré correctement la taille de votre véhicule");
            }
            System.out.println("Avez-vous une autre voiture ? (Oui/Non)");
            reponse = entree.next();
        }
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

    /**
     * La méthode trier permet d'ordonner les consommations carbone d'un
     * utilisateur.rice dans une liste
     * puis présente les informations obtenues à ce.tte dernier.e,
     * puis fait des recommandations pour obtenir un mode de vie plus durable
     */
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
                + " - réduisez vos dépenses en biens de consommation\n"
                + " - favorisez les transports en communs et déplacez vous à pied ou en vélo pour les trajets courts\n");

    }
}