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
 * @version du 22/12/2022
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
    /**
     * Permet de construire un objet issu de la classe Utilisateur à partir des
     * données entrées dans la console
     * 
     * @param alimentation représente le poste de consommation carbone lié à
     *                     alimentation
     * @param bienConso    représente le poste de consommation carbone lié aux
     *                     dépenses en biens de consommation
     * @param logement     représente le poste de consommation carbone lié au
     *                     logement
     * @param services     représente le poste de consommation carbone lié aux
     *                     services publics
     * @param cmpt         représente le numéro de l'utilisateur
     * @throws ExceptionSuperficieLogement        est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une superficie positive
     * @throws ExceptionAmmortissementVoiture     est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une durée d'amortissement
     *                                            positive
     * @throws ExceptionNbKilometresTransport     est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un nombre de kilomètre
     *                                            positif
     * @throws ExceptionClasseEnergetiqueLogement est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une classe énergétique
     *                                            entre A et G
     * @throws ExceptionTailleVoiture             est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une taille correspondant à
     *                                            'P' ou 'G'
     */
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement,
            ServicesPublics services, int cmpt)
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
        ajouterLogement(cmpt);
        ajouterTransport(cmpt);
    }

    /**
     * Permet de construire un objet issu de la classe Utilisateur à partir des
     * données dans un fichier '.txt'
     * 
     * @param fichier représente le fichier qui contient les informations sur
     *                l'utilisateur
     * @throws FileNotFoundException              représente l'exception qui informe
     *                                            qu'un fichier n'existe pas
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
     * @throws ExceptionNbKilometresTransport     est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un nombre de kilomètre
     *                                            positif
     * @throws ExceptionTailleVoiture             est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une taille correspondant à
     *                                            'P' ou 'G'
     * @throws ExceptionAmmortissementVoiture     est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une durée d'amortissement
     *                                            positive
     * @throws ExceptionMontantBienConso          est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un montant positif
     * @throws ExceptionObjetInconnu              représente l'exception qui informe
     *                                            que l'objet n'existe pas
     */
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
     * @throws ExceptionAmmortissementVoiture     est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie
     *                                            une durée d'amortissement positive
     * @throws ExceptionNbKilometresTransport     est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie
     *                                            un nombre de kilomètre positif
     * @throws ExceptionTailleVoiture             est une exception qui s'enclenche
     *                                            lorsque
     *                                            l'utilisateur n'a pas saisie une
     *                                            taille
     *                                            correspondant à 'P' ou 'G'
     * @throws ExceptionMontantBienConso          est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un montant positif
     * @throws ExceptionObjetInconnu              représente l'exception qui informe
     *                                            que l'objet
     *                                            n'existe pas
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
                        Population.verifyClasseEnergetiqueLogement(ce);
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
                        verifyTailleVoiture(taille);
                        km = Integer.parseInt(mot[2]);
                        int ammortissement = Integer.parseInt(mot[3]);
                        verifyAmortissementVoiture(ammortissement);
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
     * @throws ExceptionObjetInconnu représente l'exception qui informe que l'objet
     *                               n'existe pas
     */
    public static void erreurObjetInconnu() throws ExceptionObjetInconnu {
        throw new ExceptionObjetInconnu();
    }

    /**
     * La méthode detaillerEmpreinte permet de détailler les empreintes carbones
     * d'une instance Utilisateur
     * 
     * @param c représente le poste de consommation carbone
     */
    public void detaillerEmpreinte(ConsoCarbone c) {
        if (c instanceof Alimentation) {
            System.out.println("Impact de l'alimentation : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof BienConso) {
            System.out.println(
                    "Impact des dépenses en biens de consommation : " + String.format("%.2f", c.getImpact())
                            + " TCO2eq");
        } else if (c instanceof Logement) {
            Logement log = (Logement) c;
            System.out.println(
                    "Impact du logement " + log.getNumero() + " : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof ServicesPublics) {
            System.out.println("Impact des services publics : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Avion) {
            System.out.println(
                    "Impact de l'utilisation de l'avion : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
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
            System.out
                    .println("Impact de l'utilisation du métro : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
        } else if (c instanceof Tramway) {
            System.out.println(
                    "Impact de l'utilisation du Tramway : " + String.format("%.2f", c.getImpact()) + " TCO2eq");
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
     * La méthode verifyKilometreAnneeTransport permet de vérifier si l'utilisateur
     * a bien indiqué une valeur positive pour le nombre de kilomètre parcouru. Si
     * l'utilisateur n'a pas saisi correctement le nombre de kilomètre, l'erreur
     * ExceptionNbKilometresTransport apparaîtra à l'écran. Cette méthode est
     * appelée par la méthode createKilometreAnneeTranport
     * 
     * @param km représente le nombre de kilomètre saisie par l'utilisateur par le
     *           biais de la méthode createKilometreAnneeTransport
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public static void verifyKilometreAnneeTransport(int km) throws ExceptionNbKilometresTransport {
        if (km <= 0) {
            throw new ExceptionNbKilometresTransport();
        }
    }

    /**
     * La méthode createKilometreAnneeTransport permet de vérifier le nombre de
     * kilometre d'un véhicule de transport saisie à partir du terminal. Le nombre
     * de kilomètre par année est nécessaire pour la création d'une instance
     * Transport dans les méthodes
     * ajouterAvion/ajouterBus/ajouterVoiture/ajouterMetro/ajouterTGV/ajouterTramway/ajouterRER
     * 
     * 
     * @return le nombre de kilomètres qui sera nécessaire pour instancier un
     *         objet Transport
     */
    public static int createKilometreAnneeTransport() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                verifyKilometreAnneeTransport(s);
                tmp = false;
            } catch (ExceptionNbKilometresTransport k) {
                System.out.println("Erreur : Veuillez inserer un nombre de kilometre positive");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    // Pour Voiture :

    /**
     * La méthode verifyTailleVoiture permet de vérifier si l'utilisateur a bien
     * saisie la lettre 'P' ou 'G' dans le terminal. Si l'utilisateur n'a pas saisi
     * correctement la lettre, l'erreur ExceptionTailleVoiture apparaître à l'écran.
     * Cette méthode est appelée par la méthode createTailleVoiture
     * 
     * @param taille représente la taille de la voiture saisie par l'utilisateur
     *               dans le
     *               terminal par le biais de la méthode createTailleVoiture
     * @throws ExceptionTailleVoiture est une exception qui s'enclenche lorsque
     *                                l'utilisateur n'a pas saisie une taille
     *                                correspondant à 'P' ou 'G'
     */
    public static void verifyTailleVoiture(String taille) throws ExceptionTailleVoiture {
        if (!(taille.equals("P") || taille.equals("G"))) {
            throw new ExceptionTailleVoiture("Erreur : Veuillez répondre par 'P' ou 'G'");
        }
    }

    /**
     * La méthode verifyAmortissementVoiture permet de vérifier si l'utilisateur
     * a bien indiqué une valeur positive pour la durée de l'amortissement. Si
     * l'utilisateur n'a pas saisi correctement la durée de l'amortissement,
     * l'erreur ExceptionAmmortissementVoiture apparaîtra à l'écran. Cette méthode
     * est appelée par la méthode ajouterVoiture
     * 
     * @param amortissement représente la durée de l'amortissement de la voiture
     *                      saisie par
     *                      l'utilisateur par le biais de la méthode
     *                      createAmortissementVoiture
     * @throws ExceptionAmmortissementVoiture est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        une durée d'amortissement positive
     */
    public static void verifyAmortissementVoiture(int amortissement) throws ExceptionAmmortissementVoiture {
        if (amortissement <= 0) {
            throw new ExceptionAmmortissementVoiture();
        }
    }

    /**
     * La méthode createTailleVoiture permet de recueillir et de vérifier la taille
     * de la voiture saisie à partir du terminal. La taille de la voiture est
     * nécessaire pour la création d'une instance Voiture dans la méthode
     * ajouterVoiture
     * 
     * @return la taille d'une voiture qui sera nécessaire pour instancier un objet
     *         Voiture
     */
    public static String createTailleVoiture() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                verifyTailleVoiture(s);
                tmp = false;
            } catch (ExceptionTailleVoiture t) {
                System.out.println("Erreur : Veuillez répondre par 'P' ou 'G'");
            }
        }
        return s;
    }

    /**
     * La méthode createKilometreAnneeTransport permet de vérifier le nombre de
     * kilometre d'un véhicule de transport saisie à partir du terminal. Le nombre
     * de kilomètre par année est nécessaire pour la création d'une instance
     * Transport dans les méthodes
     * 
     * @return la durée d'amortissement qui sera nécessaire pour instancier un objet
     *         Voiture
     */
    public static int createAmortissementVoiture() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                verifyAmortissementVoiture(s);
                tmp = false;
            } catch (ExceptionAmmortissementVoiture a) {
                System.out.println("Erreur : Veuillez inserer un nombre d'années positif");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    // Méthodes qui permettent d'ajouter des objets Logement OU Transport à la liste
    // contenue dans Utilisateur
    /**
     * La méthode ajouterLogement permet d'ajouter des Logements supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * logements
     * 
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionSuperficieLogement        est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une superficie positive
     * @throws ExceptionClasseEnergetiqueLogement est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une classe énergétique
     *                                            entre A et G
     */
    public void ajouterLogement(int cmpt)
            throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        System.out.println("Utilisateur " + cmpt + " : Avez-vous un autre logement ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        Logement log;
        int numero = 2;
        while (reponse.equals("Oui")) {
            log = Population.creerLogement(cmpt, numero);
            liste.add(log);
            System.out.println("Utilisateur " + cmpt + " : Avez-vous un autre logement ? (Oui/Non)");
            reponse = Population.createOuiNon();
            numero++;
        }
    }

    /**
     * La méthode ajouterTransport permet d'ajouter une instance d'une classe fille
     * de Transport à l'ArrayList d'Utilisateur
     * 
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionAmmortissementVoiture est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        une durée d'amortissement positive
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     * @throws ExceptionTailleVoiture         est une exception qui s'enclenche
     *                                        lorsque
     *                                        l'utilisateur n'a pas saisie une
     *                                        taille
     *                                        correspondant à 'P' ou 'G'
     */
    public void ajouterTransport(int cmpt)
            throws ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport, ExceptionTailleVoiture {
        ajouterVoiture(cmpt);
        ajouterAvion(cmpt);
        ajouterBus(cmpt);
        ajouterRER(cmpt);
        ajouterTGV(cmpt);
        ajouterMetro(cmpt);
        ajouterTramway(cmpt);
    }

    // Pour l'ajout des classes filles de Transport à l'ArrayList de l'Utilisateur

    /**
     * La méthode ajouterVoiture permet d'ajouter des voitures supplémentaires
     * dans la liste de l'utilisateur au cas où l'utilisateur possède plusieurs
     * voitures
     * 
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionTailleVoiture         est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        une taille correspondant à 'P' ou 'G'
     * @throws ExceptionAmmortissementVoiture est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        une durée d'amortissement positive
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterVoiture(int cmpt)
            throws ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport, ExceptionTailleVoiture {
        System.out.println("Utilisateur " + cmpt + " : Avez-vous une voiture ? (Oui/Non)");
        String reponse = Population.createOuiNon();

        Voiture voiture;
        int numero = 1;
        while (reponse.equals("Oui")) {
            System.out.println(
                    "Utilisateur " + cmpt
                            + " : Quelle est la taille de votre véhicule ? ('G' pour grande voiture ou 'P' pour petite voiture)");
            String taille = createTailleVoiture();

            System.out.println(
                    "Utilisateur " + cmpt + " : Quel est le nombre de kilomètres (un entier) parcourus par an ?");
            int km = createKilometreAnneeTransport();

            System.out.println("Utilisateur " + cmpt + " : Depuis combien d'années avez-vous votre voiture ?");
            int annee = createAmortissementVoiture();

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
            System.out.println("Utilisateur " + cmpt + " : Avez-vous une autre voiture ? (Oui/Non)");
            reponse = Population.createOuiNon();
            numero++;
        }
    }

    /**
     * 
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterAvion(int cmpt) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisateur " + cmpt + " : Utilisez-vous l'avion ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        if (reponse.equals("Oui")) {
            System.out.println("Utilisateur " + cmpt
                    + " : Quel est le nombre (un entier) de kilomètres parcourus en avion par an ?");
            int km = createKilometreAnneeTransport();
            Avion avion = new Avion(true, km);
            liste.add(avion);
        }
    }

    /**
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterBus(int cmpt) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisateur " + cmpt + " : Utilisez-vous le bus ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        if (reponse.equals("Oui")) {
            System.out.println("Utilisateur " + cmpt
                    + " : Quel est le nombre (un entier) de kilomètres parcourus en bus par an ?");
            int km = createKilometreAnneeTransport();
            Bus bus = new Bus(true, km);
            liste.add(bus);
        }
    }

    /**
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterRER(int cmpt) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisateur " + cmpt + " : Utilisez-vous le RER ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        if (reponse.equals("Oui")) {
            System.out.println("Utilisateur " + cmpt
                    + " : Quel est le nombre (un entier) de kilomètres parcourus en RER par an ?");
            int km = createKilometreAnneeTransport();
            RER rer = new RER(true, km);
            liste.add(rer);
        }
    }

    /**
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterTGV(int cmpt) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisateur " + cmpt + " : Utilisez-vous le TGV ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        if (reponse.equals("Oui")) {
            System.out.println("Utilisateur " + cmpt
                    + " : Quel est le nombre (un entier) de kilomètres parcourus en TGV par an ?");
            int km = createKilometreAnneeTransport();
            TGV tgv = new TGV(true, km);
            liste.add(tgv);
        }
    }

    /**
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterMetro(int cmpt) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisateur " + cmpt + " : Utilisez-vous le métro ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        if (reponse.equals("Oui")) {
            System.out.println("Utilisateur " + cmpt
                    + " : Quel est le nombre (un entier) de kilomètres parcourus en métro par an ?");
            int km = createKilometreAnneeTransport();
            Metro metro = new Metro(true, km);
            liste.add(metro);
        }
    }

    /**
     * @param cmpt représente le numéro de l'utilisateur
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche
     *                                        lorsque l'utilisateur n'a pas saisie
     *                                        un nombre de kilomètre positif
     */
    public void ajouterTramway(int cmpt) throws ExceptionNbKilometresTransport {
        System.out.println("Utilisateur " + cmpt + " : Utilisez-vous le tramway ? (Oui/Non)");
        String reponse = Population.createOuiNon();
        if (reponse.equals("Oui")) {
            System.out.println("Utilisateur " + cmpt
                    + " : Quel est le nombre (un entier) de kilomètres parcourus en tramway par an ?");
            int km = createKilometreAnneeTransport();
            Tramway tramway = new Tramway(true, km);
            liste.add(tramway);
        }
    }

    // Getter et autres fonctions
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

}