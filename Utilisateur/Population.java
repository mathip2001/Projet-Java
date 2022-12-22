package Utilisateur;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import consoCarbone.*;
import consoCarbone.Exceptions.*;

/**
 * Un objet issu de la classe Population permet de regrouper l'ensemble des
 * Utilisateurs
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
 */
public class Population {
    // Attributs
    private static Population instance = null;
    private static ArrayList<Utilisateur> listePopulation;

    // Constructeur
    private Population() {
        listePopulation = new ArrayList<>();
    }

    /**
     * La méthode createInstance permet de créer une instance Population
     */
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
     * La méthode add permet d'ajouter un utilisateur au sein de la population
     * 
     * @param utilisateur l'objet Utilisateur à ajouter au sein de la population
     */
    public static void add(Utilisateur utilisateur) {
        listePopulation.add(utilisateur);
    }

    /**
     * La méthode creerPopulation permet de créer une unique instance population qui
     * sera défini à partir de l'interaction dans la console avec l'utilisateur
     * 
     * @throws ExceptionTauxAlimentation          est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un taux entre 0 et 1
     * @throws ExceptionMontantBienConso          est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie un montant positif
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
     * @throws FileNotFoundException              représente l'exception qui informe
     *                                            qu'un fichier n'existe pas
     * @throws ExceptionObjetInconnu              représente l'exception qui informe
     *                                            que l'objet n'existe pas
     */
    public static void creerPopulation()
            throws ExceptionTauxAlimentation, ExceptionMontantBienConso, ExceptionSuperficieLogement,
            ExceptionClasseEnergetiqueLogement, ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport,
            ExceptionTailleVoiture, FileNotFoundException, ExceptionObjetInconnu {

        Scanner entree = new Scanner(System.in);
        int cmpt = 1;
        String reponse;
        createInstance();

        System.out.println("Création de la population :");
        System.out.println("Avez-vous les informations des utilisateurs stockées dans un fichier '.txt' ? (Oui/Non)");
        reponse = Population.createOuiNon();
        if (reponse.equals("Non")) {
            // On demande à l'utilisateur de saisir les informations nécessaires à la
            // création de l'objet Population
            do {
                Alimentation alimentation = creerAlimentation(cmpt);
                BienConso bienConso = creerBienConso(cmpt);
                Logement logement = creerLogement(cmpt, 1);
                ServicesPublics servicesPublics = ServicesPublics.getInstance();
                Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logement,
                        servicesPublics, cmpt);
                add(utilisateur);
                System.out.println("Y a-t-il un autre utilisateur ? (Oui/Non)");
                reponse = createOuiNon();
                cmpt++;

            } while (reponse.equals("Oui"));
        } else {
            // On récupère les informations stockées dans les fichiers textes
            int NumUtil = 1;
            while (reponse.equals("Oui")) {
                System.out.println(
                        "Veuillez entrer le nom du fichier où sont stockées les informations de l'utilisateur "
                                + NumUtil + " :");
                reponse = entree.next();
                File file = new File(reponse);
                Utilisateur utilisateur = new Utilisateur(file);
                add(utilisateur);
                NumUtil++;
                System.out.println("Y a-t-il un autre utilisateur stocké dans un fichier ? (Oui/Non)");
                reponse = createOuiNon();
            }
        }
        entree.close();
    }

    // Pour Alimentation :

    /**
     * La méthode verifyTauxAlimentation permet de vérifier si l'utilisateur a bien
     * indiqué une valeur entre 0 et 1 pour le taux de boeuf et le taux de
     * vegetarien. Si l'utilisateur n'a pas saisi correctement le taux, l'erreur
     * ExceptionTauxAlimentation apparaîtra à l'écran. Cette méthode est appelée par
     * la méthode createTauxAlimentation
     * 
     * @param taux représente le taux d'alimentation saisie par l'utilisateur dans
     *             le
     *             terminal par le biais de la méthode createTauxAlimentation
     * @throws ExceptionTauxAlimentation est une exception qui s'enclenche
     *                                   lorsque l'utilisateur n'a pas
     *                                   saisie un taux entre 0 et 1
     */
    public static void verifyTauxAlimentation(double taux) throws ExceptionTauxAlimentation {
        if ((taux < 0) || (taux > 1)) {
            throw new ExceptionTauxAlimentation("Erreur : Veuillez inserer un taux doit être entre 0 et 1");
        }
    }

    /**
     * La méthode createTauxAlimentation permet de recueillir et de vérifier le taux
     * de repas à base de boeuf ou le taux de repas végétarien saisie à partir du
     * terminal. Le taux est nécessaire pour la création d'une instance Alimentation
     * dans la méthode creerAlimentation
     * 
     * @return le taux de repas à base de boeuf ou le taux de repas végétarien qui
     *         sera nécessaire pour instancier un objet Alimentation
     */
    public static double createTauxAlimentation() {
        Scanner doub;
        boolean tmp = true;
        double s = 0;
        while (tmp) {
            try {
                doub = new Scanner(System.in);
                s = doub.nextDouble();
                verifyTauxAlimentation(s);
                tmp = false;
            } catch (ExceptionTauxAlimentation t) {
                System.out.println("Erreur : Veuillez inserer un taux doit être en 0 et 1");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    /**
     * La méthode creerAlimentation permet de créer une instance Alimentation qui
     * sera définie à partir des informations saisies dans le terminal
     * 
     * @param cmpt représente le numéro de l'utilisateur
     * @return une instance Alimentation
     * @throws ExceptionTauxAlimentation est une exception qui s'enclenche lorsque
     *                                   l'utilisateur n'a pas saisie un taux entre
     *                                   0 et 1
     */
    public static Alimentation creerAlimentation(int cmpt) throws ExceptionTauxAlimentation {
        double txBoeuf, txVege;

        System.out.println(
                "Utilisateur " + cmpt + " : Quel est votre taux de repas à base de boeuf ? (une valeur entre 0 et 1)");
        txBoeuf = createTauxAlimentation();

        System.out.println(
                "Utilisateur " + cmpt + " : Quel est votre taux de repas végétariens ? (une valeur entre 0 et 1)");
        txVege = createTauxAlimentation();
        return new Alimentation(txBoeuf, txVege);
    }

    // Pour BienConso :

    /**
     * La méthode verifyMontantBienConso permet de vérifier si l'utilisateur a bien
     * indiqué une valeur positive pour le montant des BienConso. Si l'utilisateur
     * n'a pas saisi correctement le taux, l'erreur ExceptionMontantBienConso
     * apparaîtra à l'écran. Cette méthode est appelée par la méthode
     * createMontantBienConso
     * 
     * @param montant représente le montant saisie par l'utilisateur dans le
     *                terminal par
     *                le biais de la méthode createMontantBienConso
     * @throws ExceptionMontantBienConso est une exception qui s'enclenche lorsque
     *                                   l'utilisateur n'a pas saisie un montant
     *                                   positif
     */
    public static void verifyMontantBienConso(double montant) throws ExceptionMontantBienConso {
        if (montant < 0) {
            throw new ExceptionMontantBienConso();
        }
    }

    /**
     * La méthode createMontantBienConso permet de recueillir et de vérifier le
     * montant du BienConso saisie à partir du terminal. Le montant est nécessaire
     * pour la création d'une instance BienConso dans la méthode creerBienConso
     * 
     * @return le montant du BienConso qui sera nécessaire pour instancier un objet
     *         BienConso
     */
    public static double createMontantBienConso() {
        Scanner doub;
        boolean tmp = true;
        double s = 0;
        while (tmp) {
            try {
                doub = new Scanner(System.in);
                s = doub.nextDouble();
                verifyMontantBienConso(s);
                tmp = false;
            } catch (ExceptionMontantBienConso m) {
                System.out.println("Erreur : Veuillez inserer un montant positif");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    /**
     * La méthode creerBienConso permet de créer une instance BienConso qui
     * sera définie à partir des informations saisies dans le terminal
     * 
     * @param cmpt représente le numéro de l'utilisateur
     * @return une instance BienConso
     * @throws ExceptionMontantBienConso est une exception qui s'enclenche lorsque
     *                                   l'utilisateur n'a pas saisie un montant
     *                                   positif
     */
    public static BienConso creerBienConso(int cmpt) throws ExceptionMontantBienConso {
        double montant;
        System.out.println(
                "Utilisateur " + cmpt
                        + " : Quel est le montant de vos dépenses annuelles en biens de consommation ?");
        montant = createMontantBienConso();
        return new BienConso(montant);
    }

    // Pour Logement :

    /**
     * La méthode verifySuperficieLogement permet de vérifier si l'utilisateur a
     * bien indiqué une valeur positive pour le montant des BienConso. Si
     * l'utilisateur n'a pas saisi correctement le taux, l'erreur
     * ExceptionSuperficieLogement apparaîtra à l'écran. Cette méthode est appelée
     * par la méthode createSuperficieLogement
     * 
     * @param superficie représente la superficie du logement saisie par
     *                   l'utilisateur dans
     *                   le terminal par le biais de la méthode
     *                   createSuperficieLogement
     * @throws ExceptionSuperficieLogement est une exception qui s'enclenche lorsque
     *                                     l'utilisateur n'a pas saisie une
     *                                     superficie positive
     */
    public static void verifySuperficieLogement(int superficie) throws ExceptionSuperficieLogement {
        if (superficie <= 0) {
            throw new ExceptionSuperficieLogement();
        }
    }

    /**
     * La méthode verifyClasseEnergetiqueLogement permet de vérifier si
     * l'utilisateur a bien saisi une lettre de 'A' à 'G' dans le terminal. Si
     * l'utilisateur n'a pas saisi correctement la lettre, l'erreur
     * ExceptionClasseEnergetiqueLogement apparaîtra à l'écran. Cette méthode est
     * appelée par la méthode createClasseEnergetiqueLogement
     * 
     * @param ce représente la classe énergétique saisie par l'utilisateur dans le
     *           terminal par le biais de la méthode createClasseEnergetiqueLogement
     * @throws ExceptionClasseEnergetiqueLogement est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une classe énergétique
     *                                            entre A et G
     */
    public static void verifyClasseEnergetiqueLogement(String ce) throws ExceptionClasseEnergetiqueLogement {
        if (!(ce.equals("A")
                || ce.equals("B")
                || ce.equals("C")
                || ce.equals("D")
                || ce.equals("E")
                || ce.equals("F")
                || ce.equals("G"))) {
            throw new ExceptionClasseEnergetiqueLogement("Erreur : Veuillez répondre par les lettres de A à G");
        }
    }

    /**
     * La méthode createSuperficieLogement permet de recueillir et de vérifier la
     * superficie du logement saisie à partir du terminal. La superficie est
     * nécessaire pour la création d'une instance Logement dans la méthode
     * creerLogement
     * 
     * @return la superficie du logement qui sera nécessaire pour instancier un
     *         objet Logement
     */
    public static int createSuperficieLogement() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                verifySuperficieLogement(s);
                tmp = false;
            } catch (ExceptionSuperficieLogement sup) {
                System.out.println("Erreur : Veuillez inserer une superficie positive");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    /**
     * La méthode createClasseEnergetiqueLogement permet de recueillir et de
     * vérifier la classe énergétique du logement saisie à partir du terminal. La
     * classe énergétique du logement est nécessaire pour la création d'une instance
     * Logement dans la méthode creerLogement
     *
     * @return la classe énergétique du logement qui sera nécessaire pour instancier
     *         un objet Logement
     */
    public static String createClasseEnergetiqueLogement() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                verifyClasseEnergetiqueLogement(s);
                tmp = false;
            } catch (ExceptionClasseEnergetiqueLogement e) {
                System.out.println("Erreur : Veuillez répondre par les lettres de A à G");
            }
        }
        return s;
    }

    /**
     * La méthode creerLogement permet de créer une instance Logement qui
     * sera définie à partir des informations saisies dans le terminal
     *
     * @param cmpt   représente le numéro de l'utilisateur
     * @param numero représente le numéro du logement
     * @return une instance Logement
     * @throws ExceptionSuperficieLogement        est une exception qui s'enclenche
     *                                            lorsque
     *                                            l'utilisateur n'a pas saisie une
     *                                            superficie positive
     * @throws ExceptionClasseEnergetiqueLogement est une exception qui s'enclenche
     *                                            lorsque l'utilisateur n'a pas
     *                                            saisie une classe énergétique
     *                                            entre A et G
     */
    public static Logement creerLogement(int cmpt, int numero)
            throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        System.out.println("Utilisateur " + cmpt + " : Quelle est la superficie du logement ? (en m^2)");
        int superficie = createSuperficieLogement();

        System.out.println(
                "Utilisateur " + cmpt + " : Quelle est la classe énergétique du logement ? (une lettre de A à G)");
        String classeEnergetique = createClasseEnergetiqueLogement();

        switch (classeEnergetique) {
            case "A":
                return new Logement(superficie, CE.A, numero);
            case "B":
                return new Logement(superficie, CE.B, numero);
            case "C":
                return new Logement(superficie, CE.C, numero);
            case "D":
                return new Logement(superficie, CE.D, numero);
            case "E":
                return new Logement(superficie, CE.E, numero);
            case "F":
                return new Logement(superficie, CE.F, numero);
            case "G":
                return new Logement(superficie, CE.G, numero);
            default:
                System.out.println("Vous n'avez pas rentré correctement la classe énergétique de votre logement");
                return creerLogement(cmpt, numero);
        }
    }

    // Les 2 méthodes suivantes sont utiles pour la plupart des autres classes :

    /**
     * La méthode verifyOuiNon permet de vérifier si l'utilisateur a bien répondu
     * par Oui ou par Non dans le terminal. Si l'utilisateur n'a pas saisi
     * correctement le taux, l'erreur ErreurOuiNon apparaîtra à l'écran. Cette
     * méthode est appelée par la méthode createOuiNon
     * 
     * @param reponse représente la réponse saisie par l'utilisateur dans le
     *                terminal par
     *                le biais de la méthode createOuiNon
     * @throws ExceptionErreurOuiNon est une exception qui s'enclenche lorsque
     *                               l'utilisateur ne répond pas par Oui ou par Non
     */
    public static void verifyOuiNon(String reponse) throws ExceptionErreurOuiNon {
        if ((!(reponse.equals("Oui"))) && (!(reponse.equals("Non")))) {
            throw new ExceptionErreurOuiNon("Erreur : Veuillez répondre par 'Oui' ou 'Non'");
        }
    }

    /**
     * La méthode createOuiNon permet de recueillir et vérifier la réponse saisie
     * par l'utilisateur à partir du terminal
     * 
     * @return la chaîne de caractère Oui ou Non
     */
    public static String createOuiNon() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                verifyOuiNon(s);
                tmp = false;
            } catch (ExceptionErreurOuiNon e) {
                System.out.println("Erreur : Veuillez répondre par 'Oui' ou 'Non'");
            }
        }
        return s;
    }

    /**
     * La méthode empreintePopulation permet de connaître l'impact total de toute la
     * population
     * 
     * @return l'impact total de toute la population
     */
    public static double empreintePopulation() {
        double impact = 0;
        for (Utilisateur u : listePopulation) {
            impact += u.calculerEmpreinte();
        }
        return impact;
    }

    /**
     * La méthode politiquePubliqueViande permet de réaliser une simulation afin de
     * tester une mise en place d'une politique publique visant à diviser par deux
     * la consommation de repas à base de boeuf de chaque utilisateur de la
     * population
     * 
     */
    public static void politiquePubliqueViande() {
        System.out.println(
                "\nMise en place d'une politique publique visant à diviser par deux la consommation de repas à base de boeuf de chaque utilisateur de la population");
        double impact1 = empreintePopulation();
        for (Utilisateur u : listePopulation) {
            for (ConsoCarbone c : u.getListe()) {
                if (c instanceof Alimentation) {
                    Alimentation alim = (Alimentation) c;
                    double txB = alim.getTxBoeuf();
                    alim.setTxBoeuf(txB / 2);
                }
            }
        }
        double impact2 = empreintePopulation();
        System.out.println(
                "Impact carbone de la population avant la mise en place de cette politique : "
                        + String.format("%.2f", impact1) + " TCO2eq");
        System.out.println(
                "Impact carbone de la population après la mise en place de cette politique : "
                        + String.format("%.2f", impact2) + " TCO2eq");
        System.out.println(
                "La mise en place de cette politique a donc permis de réduire l'impact carbone de la population de "
                        + String.format("%.2f", (impact1 - impact2)) + " TCO2eq");
    }

    /**
     * La méthode politiquePubliqueEnergie permet de réaliser une simulation afin de
     * tester une mise en place d'une politique publique incitant la rénovation
     * énergétique de chaque utilisateur de la population afin que la classe
     * énergétique de chaque logement soit A
     * 
     */
    public static void politiquePubliqueEnergie() {
        System.out.println(
                "\nMise en place d'une politique publique incitant la rénovation énergétique de chaque utilisateur de la population afin que la classe énergétique de chaque logement soit de classe énergétique A");
        double impact1 = empreintePopulation();
        for (Utilisateur u : listePopulation) {
            for (ConsoCarbone c : u.getListe()) {
                if (c instanceof Logement) {
                    Logement log = (Logement) c;
                    log.setClasseEnergetique(CE.A);
                }
            }
        }
        double impact2 = empreintePopulation();
        System.out.println(
                "Impact carbone de la population avant la mise en place de cette politique : "
                        + String.format("%.2f", impact1) + " TCO2eq");
        System.out.println(
                "Impact carbone de la population après la mise en place de cette politique : "
                        + String.format("%.2f", impact2) + " TCO2eq");
        System.out.println(
                "La mise en place de cette politique a donc permis de réduire l'impact carbone de la population de "
                        + String.format("%.2f", (impact1 - impact2)) + " TCO2eq");
    }

    /**
     * La méthode affichageConsoOrdre permet d'afficher les consommations carbones
     * ordonnées des utilisateurs avec les recommandations
     */
    public static void affichageConsoOrdre() {
        System.out
                .println("\nAffichage des consommations carbone ordonnées des utilisateurs avec les recommandations :");
        for (Utilisateur u : listePopulation) {
            System.out.println("Utilisateur " + (listePopulation.indexOf(u) + 1) + " :");
            u.trier();
        }
    }
}