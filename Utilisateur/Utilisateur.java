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
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement,
            ServicesPublics services, int cmpt, Scanner entree)
            throws SuperficieException, AmmortissementException, NbKilometresException {
        liste = new ArrayList<>();
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logement = logement;
        this.services = services;
        liste.add(alimentation);
        liste.add(bienConso);
        liste.add(logement);
        liste.add(services);
        AjouterLogement(cmpt, entree);
        AjouterTransport(cmpt, entree);
    }

    /**
     * La méthode AjouterLogement permet d'ajouter des Logements supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * logements
     */
    public void AjouterLogement(int cmpt, Scanner entree) throws SuperficieException {

        // Fermer ce scanner uniquement lorsqu'on n'en n'aura plus jms besoin => Tout à
        // la fin du Main. Et mettre le scanner uniqument au début et ne pas le recréer
        // à chaque fois

        System.out.println("Avez-vous un autre logement ? (Oui/Non)");
        String reponse = entree.next();
        Logement log;
        int numero = 2;
        while (reponse.equals("Oui")) {
            log = Population.creerLogement(cmpt, entree, numero);
            liste.add(log);
            System.out.println("Avez-vous un autre logement ? (Oui/Non)");
            reponse = entree.next();
        }
        // entree.close();
    }

    public void AjouterTransport(int cmpt, Scanner entree) throws AmmortissementException, NbKilometresException {
        AjouterVoiture(cmpt, entree);
        AjouterAvion(cmpt, entree);
        AjouterBus(cmpt, entree);
        AjouterRER(cmpt, entree);
        AjouterTGV(cmpt, entree);
        AjouterMetro(cmpt, entree);
        AjouterTramway(cmpt, entree);
    }

    /**
     * La méthode AjouterVoiture permet d'ajouter des voitures supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * voitures
     */
    public void AjouterVoiture(int cmpt, Scanner entree) throws AmmortissementException, NbKilometresException {
        System.out.println("Avez-vous une voiture ? (Oui/Non)");
        String reponse = entree.next();
        Voiture voiture;
        while (reponse.equals("Oui")) {
            System.out.println(
                    "Quelle est la taille de votre véhicule ? ('G' pour grande voiture ou 'P' pour petite voiture)");
            String taille = entree.next();
            System.out.println("Quel est le nombre de kilomètres (un entier) parcourus par an ?");
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

    public void AjouterAvion(int cmpt, Scanner entree) throws NbKilometresException {
        System.out.println("Utilisez-vous l'avion ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Avion avion = new Avion(true, km);
            liste.add(avion);
        }
    }

    public void AjouterBus(int cmpt, Scanner entree) throws NbKilometresException {
        System.out.println("Utilisez-vous le bus ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Bus bus = new Bus(true, km);
            liste.add(bus);
        }
    }

    public void AjouterRER(int cmpt, Scanner entree) throws NbKilometresException {
        System.out.println("Utilisez-vous le RER ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            RER rer = new RER(true, km);
            liste.add(rer);
        }
    }

    public void AjouterTGV(int cmpt, Scanner entree) throws NbKilometresException {
        System.out.println("Utilisez-vous le TGV ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            TGV tgv = new TGV(true, km);
            liste.add(tgv);
        }
    }

    public void AjouterMetro(int cmpt, Scanner entree) throws NbKilometresException {
        System.out.println("Utilisez-vous le métro ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Metro metro = new Metro(true, km);
            liste.add(metro);
        }
    }

    public void AjouterTramway(int cmpt, Scanner entree) throws NbKilometresException {
        System.out.println("Utilisez-vous le tramway ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Tramway tramway = new Tramway(true, km);
            liste.add(tramway);
        }
    }

    /**
     * La méthode calculerEmpreinte permet de calculer les empreintes carbones d'une
     * instance Utilisateur
     * 
     * @return les empreintes carbones d'une instance Utilisateur
     */
    public double calculerEmpreinte() {
        double impact = 0;
        for (ConsoCarbone c : liste) {
            impact += c.getImpact();
        }
        return impact;
    }

    /**
     * La méthode detaillerEmpreinte permet de détailler les empreintes carbones
     * d'une instance Utilisateur
     */
    public void detaillerEmpreinte() {
        System.out.println("Description détaillée de l'empreinte carbone :");
        for (ConsoCarbone c : liste) {

        }

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