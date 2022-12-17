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

    public static void verifyTransportKilometreAnnee(int i) throws NbKilometresException {
        if (i <= 0) {
            throw new NbKilometresException();
        }
    }

    public static int CreateIntTransport() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                verifyTransportKilometreAnnee(s);
                tmp = false;
            } catch (NbKilometresException k) {
                System.out.println("Erreur : Veuillez inserer un nombre de kilometre positive");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    public static void TestReponseTailleVoiture(String s) throws TailleVoitureException {
        if (!(s.equals("P") || s.equals("G"))) {
            throw new TailleVoitureException("Erreur : Veuillez répondre par 'P' ou 'G'");
        }
    }

    public static String CreateTailleVoiture() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                TestReponseTailleVoiture(s);
                tmp = false;
            } catch (TailleVoitureException t) {
                System.out.println("Erreur : Veuillez répondre par 'P' ou 'G'");
            }
        }
        return s;
    }

    public static void verifyAmortissementVoiture(int i) throws AmmortissementException {
        if (i <= 0) {
            throw new AmmortissementException();
        }
    }

    public static int CreateIntAmortissementVoiture() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                verifyAmortissementVoiture(s);
                tmp = false;
            } catch (AmmortissementException a) {
                System.out.println("Erreur : Veuillez inserer un nombre d'années positif");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    /**
     * La méthode AjouterLogement permet d'ajouter des Logements supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * logements
     */
    public void AjouterLogement(int cmpt, Scanner entree) throws SuperficieException {
        System.out.println("Avez-vous un autre logement ? (Oui/Non)");
        String reponse = entree.next();
        Logement log;
        int numero = 2;
        while (reponse.equals("Oui")) {
            log = Population.creerLogement(cmpt, entree, numero);
            liste.add(log);
            System.out.println("Avez-vous un autre logement ? (Oui/Non)");
            reponse = entree.next();
            numero++;
        }
    }

    /**
     * @param cmpt
     * @param entree
     * @throws AmmortissementException
     * @throws NbKilometresException
     */
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
    public static void AjouterVoiture(int cmpt, Scanner entree) throws AmmortissementException, NbKilometresException {
        System.out.println("Avez-vous une voiture ? (Oui/Non)");
        String reponse = Population.CreateOuiNon();

        Voiture voiture;
        int numero = 1;
        while (reponse.equals("Oui")) {
            System.out.println(
                    "Quelle est la taille de votre véhicule ? ('G' pour grande voiture ou 'P' pour petite voiture)");
            String taille = CreateTailleVoiture();

            System.out.println("Quel est le nombre de kilomètres (un entier) parcourus par an ?");
            int km = CreateIntTransport();

            System.out.println("Depuis combien d'années avez-vous votre voiture ?");
            int annee = CreateIntAmortissementVoiture();

            // switch (taille) {
            // case "P":
            // voiture = new Voiture(true, Taille.P, km, annee, numero);
            // liste.add(voiture);
            // break;
            // case "G":
            // voiture = new Voiture(true, Taille.G, km, annee, numero);
            // liste.add(voiture);
            // break;
            // default:
            // System.out.println("Vous n'avez pas rentré correctement la taille de votre
            // véhicule");
            // }
            System.out.println("Avez-vous une autre voiture ? (Oui/Non)");
            reponse = entree.next();
            numero++;
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
            if (c instanceof Alimentation) {
                System.out.println("Impact de l'alimentation : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof BienConso) {
                System.out.println(
                        "Impact des dépenses en biens de consommation : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof Logement) {
                Logement log = (Logement) c;
                System.out.println(
                        "Impact du logement " + log.getNumero() + " : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof ServicesPublics) {
                System.out.println("Impact des services publics : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof Avion) {
                System.out.println("Impact de l'utilisation de l'avion : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof Voiture) {
                Voiture voiture = (Voiture) c;
                System.out.println("Impact de l'utilisation de la voiture " + voiture.getNumero() + " : "
                        + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof Bus) {
                System.out.println("Impact de l'utilisation du bus : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof RER) {
                System.out.println("Impact de l'utilisation du RER : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof TGV) {
                System.out.println("Impact de l'utilisation du TGV : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof Metro) {
                System.out.println("Impact de l'utilisation du métro : " + String.format("%.2f\n", c.getImpact()));
            } else if (c instanceof Tramway) {
                System.out.println("Impact de l'utilisation du Tramway : " + String.format("%.2f\n", c.getImpact()));
            }
        }
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

    public Alimentation getAlimentation() {
        return alimentation;
    }

    public BienConso getBienConso() {
        return bienConso;
    }

    public Logement getLogement() {
        return logement;
    }

    public Transport getTransport() {
        return transport;
    }

    public ServicesPublics getServices() {
        return services;
    }

    public ArrayList<ConsoCarbone> getListe() {
        return liste;
    }
}