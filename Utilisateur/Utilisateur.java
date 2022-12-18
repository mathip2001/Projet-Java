package Utilisateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

import consoCarbone.*;
import consoCarbone.Exceptions.*;

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

    // 2 Constructeurs
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement,
            ServicesPublics services, int cmpt, Scanner entree)
            throws ExceptionSuperficieLogement, ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport,
            ExceptionClasseEnergetiqueLogement, ExceptionTailleVoiture {
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

    public Utilisateur(File fichier)
            throws FileNotFoundException, ExceptionTauxAlimentation, ExceptionSuperficieLogement,
            ExceptionClasseEnergetiqueLogement, ExceptionNbKilometresTransport, ExceptionTailleVoiture,
            ExceptionAmmortissementVoiture, ExceptionMontantBienConso, ExceptionObjetInconnu {
        liste = new ArrayList<>();
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        creerUtilisateur(br);
    }

    /**
     * La méthode creerUtilisateur permet à partir d'un fichier.txt de créer les
     * instances nécessaires à la création de l'objet Utilisateur
     * 
     * @param br représente le flux de caractère contenant dans un fichier.txt
     * @throws ExceptionTauxAlimentation          est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un taux entre 0 et 1
     * @throws ExceptionSuperficieLogement        est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une superficie positive
     * @throws ExceptionClasseEnergetiqueLogement est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une classe énergétique
     *                                            entre A et G
     * @throws ExceptionNbKilometresTransport
     * @throws ExceptionTailleVoiture
     * @throws ExceptionAmmortissementVoiture
     * @throws ExceptionMontantBienConso          est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un montant positif
     * @throws ExceptionObjetInconnu
     */
    public void creerUtilisateur(BufferedReader br)
            throws ExceptionTauxAlimentation, ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement,
            ExceptionNbKilometresTransport, ExceptionTailleVoiture, ExceptionAmmortissementVoiture,
            ExceptionMontantBienConso, ExceptionObjetInconnu {
        String ligne;
        String[] mot;
        String objet;
        int numLog = 1;
        int numVoit = 1;
        int km;
        ServicesPublics servicesPublics = ServicesPublics.getInstance();
        liste.add(servicesPublics);
        try {
            while ((ligne = br.readLine()) != null) {
                mot = ligne.split(" ");
                objet = mot[0];
                switch (objet) {
                    case "Alimentation":
                        double txBoeuf = Double.parseDouble(mot[1]);
                        double txVege = Double.parseDouble(mot[2]);
                        Alimentation alimentation = new Alimentation(txBoeuf, txVege);
                        liste.add(alimentation);
                        break;
                    case "BienConso":
                        double montant = Double.parseDouble(mot[1]);
                        BienConso bienConso = new BienConso(montant);
                        liste.add(bienConso);
                        break;
                    case "Logement":
                        int superficie = Integer.parseInt(mot[1]);
                        String ce = mot[2];
                        Population.VerifyClasseEnergetiqueLogement(ce);
                        Logement logement;
                        switch (ce) {
                            case "A":
                                logement = new Logement(superficie, CE.A, numLog);
                                liste.add(logement);
                                break;
                            case "B":
                                logement = new Logement(superficie, CE.B, numLog);
                                liste.add(logement);
                                break;
                            case "C":
                                logement = new Logement(superficie, CE.C, numLog);
                                liste.add(logement);
                                break;
                            case "D":
                                logement = new Logement(superficie, CE.D, numLog);
                                liste.add(logement);
                                break;
                            case "E":
                                logement = new Logement(superficie, CE.E, numLog);
                                liste.add(logement);
                                break;
                            case "F":
                                logement = new Logement(superficie, CE.F, numLog);
                                liste.add(logement);
                                break;
                            case "G":
                                logement = new Logement(superficie, CE.G, numLog);
                                liste.add(logement);
                                break;
                        }
                        numLog++;
                        break;
                    case "Avion":
                        km = Integer.parseInt(mot[1]);
                        Avion avion = new Avion(true, km);
                        liste.add(avion);
                        break;
                    case "Voiture":
                        String taille = mot[1];
                        TestReponseTailleVoiture(taille);
                        km = Integer.parseInt(mot[2]);
                        int ammortissement = Integer.parseInt(mot[3]);
                        VerifyAmortissementVoiture(ammortissement);
                        switch (taille) {
                            case "P":
                                Voiture voiture = new Voiture(true, Taille.P, km, ammortissement, numVoit);
                                liste.add(voiture);
                                break;
                            case "G":
                                voiture = new Voiture(true, Taille.G, km, ammortissement, numVoit);
                                liste.add(voiture);
                                break;
                        }
                        numVoit++;
                        break;
                    case "Bus":
                        km = Integer.parseInt(mot[1]);
                        Bus bus = new Bus(true, km);
                        liste.add(bus);
                        break;
                    case "RER":
                        km = Integer.parseInt(mot[1]);
                        RER rer = new RER(true, km);
                        liste.add(rer);
                        break;
                    case "TGV":
                        km = Integer.parseInt(mot[1]);
                        TGV tgv = new TGV(true, km);
                        liste.add(tgv);
                        break;
                    case "Metro":
                        km = Integer.parseInt(mot[1]);
                        Metro metro = new Metro(true, km);
                        liste.add(metro);
                        break;
                    case "Tramway":
                        km = Integer.parseInt(mot[1]);
                        Tramway tramway = new Tramway(true, km);
                        liste.add(tramway);
                        break;
                    default:
                        erreurObjetInconnu();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pour arrêter l'exécution du programme si l'objet n'est pas reconnu. L'appel
     * de cette méthode renvoie automatiquement une exception car on l'appelle dans
     * le default d'un switch qui représente le cas d'erreur
     * 
     * @throws ExceptionObjetInconnu
     */
    public static void erreurObjetInconnu() throws ExceptionObjetInconnu {
        throw new ExceptionObjetInconnu();
    }

    /**
     * La méthode detaillerEmpreinte permet de détailler les empreintes carbones
     * d'une instance Utilisateur
     */
    public void detaillerEmpreinte(ConsoCarbone c) {
        if (c instanceof Alimentation) {
            System.out.println("Impact de l'alimentation : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof BienConso) {
            System.out.println(
                    "Impact des dépenses en biens de consommation : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Logement) {
            Logement log = (Logement) c;
            System.out.println(
                    "Impact du logement " + log.getNumero() + " : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof ServicesPublics) {
            System.out.println("Impact des services publics : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Avion) {
            System.out.println("Impact de l'utilisation de l'avion : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Voiture) {
            Voiture voiture = (Voiture) c;
            System.out.println("Impact de l'utilisation de la voiture " + voiture.getNumero() + " : "
                    + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Bus) {
            System.out.println("Impact de l'utilisation du bus : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof RER) {
            System.out.println("Impact de l'utilisation du RER : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof TGV) {
            System.out.println("Impact de l'utilisation du TGV : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Metro) {
            System.out.println("Impact de l'utilisation du métro : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Tramway) {
            System.out.println("Impact de l'utilisation du Tramway : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        }
    }

    /**
     * La méthode trier permet d'ordonner les consommations carbone d'un
     * utilisateur.rice dans une liste puis présente les informations obtenues à
     * ce.tte dernier.e, puis fait des recommandations pour obtenir un mode de vie
     * plus durable
     */
    public void trier() {
        Collections.sort(liste);
        String recommendations = "Pour obtenir un mode de vie plus durable :\n";
        // Affichage des consommations carbones triées
        for (ConsoCarbone c : liste) {
            detaillerEmpreinte(c);
            if (c instanceof Alimentation) {
                Alimentation alim1 = (Alimentation) c;
                if (alim1.getTxBoeuf() > 0.2) { // On considère qu'un taux de repas à base de boeuf inférieur ou égale à
                                                // 0.2 est bien et sa baisse n'est pas nécessaire
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

    // Pour Transport :
    /**
     * La méthode VerifyKilometreAnneeTransport permet de vérifier si l'utilisateur
     * a bien indiqué une valeur positive pour le nombre de kilomètre parcouru. Si
     * l'utilisateur n'a pas saisi correctement le taux, l'erreur
     * ExceptionNbKilometresTransport apparaîtra à l'écran. Cette méthode est
     * appelée par la méthode CreateMontantBienConso
     * 
     * @param i représente le nombre de kilomètre saisie par l'utilisateur
     * @throws ExceptionNbKilometresTransport
     */
    public static void VerifyKilometreAnneeTransport(int i) throws ExceptionNbKilometresTransport {
        if (i <= 0) {
            throw new ExceptionNbKilometresTransport();
        }
    }

    /**
     * @return int
     */
    public static int CreateKilometreAnneeTransport() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                VerifyKilometreAnneeTransport(s);
                tmp = false;
            } catch (ExceptionNbKilometresTransport k) {
                System.out.println("Erreur : Veuillez inserer un nombre de kilometre positive");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    /**
     * @param s
     * @throws ExceptionTailleVoiture
     */
    public static void TestReponseTailleVoiture(String s) throws ExceptionTailleVoiture {
        if (!(s.equals("P") || s.equals("G"))) {
            throw new ExceptionTailleVoiture("Erreur : Veuillez répondre par 'P' ou 'G'");
        }
    }

    /**
     * @return String
     */
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
            } catch (ExceptionTailleVoiture t) {
                System.out.println("Erreur : Veuillez répondre par 'P' ou 'G'");
            }
        }
        return s;
    }

    /**
     * @param i
     * @throws ExceptionAmmortissementVoiture
     */
    public static void VerifyAmortissementVoiture(int i) throws ExceptionAmmortissementVoiture {
        if (i <= 0) {
            throw new ExceptionAmmortissementVoiture();
        }
    }

    /**
     * @return int
     */
    public static int CreateIntAmortissementVoiture() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                VerifyAmortissementVoiture(s);
                tmp = false;
            } catch (ExceptionAmmortissementVoiture a) {
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
     * 
     * @throws SuperficieException
     * @throws ClasseEnergetiqueException
     */
    public void AjouterLogement(int cmpt, Scanner entree)
            throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        System.out.println("Avez-vous un autre logement ? (Oui/Non)");
        String reponse = entree.next();
        Logement log;
        int numero = 2;
        while (reponse.equals("Oui")) {
            log = Population.CreerLogement(cmpt, entree, numero);
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
     * @throws TailleVoitureException
     */
    public void AjouterTransport(int cmpt, Scanner entree)
            throws ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport, ExceptionTailleVoiture {
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
     * 
     * @throws ExceptionTailleVoiture
     */
    public void AjouterVoiture(int cmpt, Scanner entree)
            throws ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport, ExceptionTailleVoiture {
        System.out.println("Avez-vous une voiture ? (Oui/Non)");
        String reponse = Population.CreateOuiNon();

        Voiture voiture;
        int numero = 1;
        while (reponse.equals("Oui")) {
            System.out.println(
                    "Quelle est la taille de votre véhicule ? ('G' pour grande voiture ou 'P' pour petite voiture)");
            String taille = CreateTailleVoiture();

            System.out.println("Quel est le nombre de kilomètres (un entier) parcourus par an ?");
            int km = CreateKilometreAnneeTransport();

            System.out.println("Depuis combien d'années avez-vous votre voiture ?");
            int annee = CreateIntAmortissementVoiture();

            switch (taille) {
                case "P":
                    voiture = new Voiture(true, Taille.P, km, annee, numero);
                    liste.add(voiture);
                    break;
                case "G":
                    voiture = new Voiture(true, Taille.G, km, annee, numero);
                    liste.add(voiture);
                    break;
                default:
                    System.out.println("Vous n'avez pas rentré correctement la taille de votre véhicule");
            }
            System.out.println("Avez-vous une autre voiture ? (Oui/Non)");
            reponse = Population.CreateOuiNon();
            numero++;
        }
    }

    // Pour l'ajout des classes filles de Train à l'array de l'Utilisateur
    /**
     * 
     * @param cmpt
     * @param entree
     * @throws ExceptionNbKilometresTransport
     */
    public void AjouterAvion(int cmpt, Scanner entree) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisez-vous l'avion ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Avion avion = new Avion(true, km);
            liste.add(avion);
        }
    }

    /**
     * @param cmpt
     * @param entree
     * @throws ExceptionNbKilometresTransport
     */
    public void AjouterBus(int cmpt, Scanner entree) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisez-vous le bus ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Bus bus = new Bus(true, km);
            liste.add(bus);
        }
    }

    /**
     * @param cmpt
     * @param entree
     * @throws ExceptionNbKilometresTransport
     */
    public void AjouterRER(int cmpt, Scanner entree) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisez-vous le RER ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            RER rer = new RER(true, km);
            liste.add(rer);
        }
    }

    /**
     * @param cmpt
     * @param entree
     * @throws ExceptionNbKilometresTransport
     */
    public void AjouterTGV(int cmpt, Scanner entree) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisez-vous le TGV ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            TGV tgv = new TGV(true, km);
            liste.add(tgv);
        }
    }

    /**
     * @param cmpt
     * @param entree
     * @throws ExceptionNbKilometresTransport
     */
    public void AjouterMetro(int cmpt, Scanner entree) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisez-vous le métro ? (Oui/Non)");
        String reponse = entree.next();
        if (reponse.equals("Oui")) {
            System.out.println("Quel est le nombre (un entier) de kilomètres parcourus par an ?");
            int km = entree.nextInt();
            Metro metro = new Metro(true, km);
            liste.add(metro);
        }
    }

    /**
     * @param cmpt
     * @param entree
     * @throws ExceptionNbKilometresTransport
     */
    public void AjouterTramway(int cmpt, Scanner entree) throws ExceptionNbKilometresTransport {
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

    // Getter
    /**
     * La méthode getAlimentation permet de récupérer une instance Alimentation d'un
     * utilisateur
     * 
     * @return une instance Alimentation d'un utilisateur
     */
    public Alimentation getAlimentation() {
        return alimentation;
    }

    /**
     * La méthode getBienConso permet de récupérer une instance BienConso d'un
     * utilisateur
     * 
     * @return une instance BienConso d'un utilisateur
     */
    public BienConso getBienConso() {
        return bienConso;
    }

    /**
     * La méthode getLogement permet de récupérer une instance Logement d'un
     * utilisateur
     * 
     * @return une instance Logement d'un utilisateur
     */
    public Logement getLogement() {
        return logement;
    }

    /**
     * La méthode getTransport permet de récupérer une instance Transport d'un
     * utilisateur
     * 
     * @return une instance Transport d'un utilisateur
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * La méthode getServices permet de récupérer l'unique instance Services d'un
     * utilisateur
     * 
     * @return une instance ServicesPublics d'un utilisateur
     */
    public ServicesPublics getServices() {
        return services;
    }

    /**
     * La méthode getListe permet de récupérer la liste de ConsoCarbone d'un
     * utilisateur
     * 
     * @return une liste de ConsoCarbone
     */
    public ArrayList<ConsoCarbone> getListe() {
        return liste;
    }
}