package Utilisateur;

import java.util.ArrayList;
import java.util.Scanner;

import consoCarbone.*;

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
     * La méthode add permet d'ajouter un utilisateur au sein de la population
     * 
     * @param utilisateur l'objet Utilisateur à ajouter au sein de la population
     */
    public void add(Utilisateur utilisateur) {
        listePopulation.add(utilisateur);
    }

    /**
     * La méthode listing permet de lister les consommations carbones triées,
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

    /**
     * La méthode creerPopulation permet de créer une unique instance population qui
     * sera défini à partir de l'interaction dans la console avec l'utilisateur
     * 
     * @throws TauxException
     * @throws SuperficieException
     * @throws AmmortissementException
     * @throws NbKilometresException
     */
    public void creerPopulation()
            throws TauxException, MontantException, SuperficieException, ClasseEnergetiqueException,
            AmmortissementException, NbKilometresException, TailleVoitureException {

        System.out.println("Création de la population :");
        Scanner entree = new Scanner(System.in);
        int cmpt = 1;
        String reponse;

        do {
            Alimentation alimentation = CreerAlimentation(cmpt, entree);
            BienConso bienConso = CreerBienConso(cmpt, entree);
            Logement logement = CreerLogement(cmpt, entree, 1);
            ServicesPublics servicesPublics = ServicesPublics.getInstance();
            Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logement,
                    servicesPublics, cmpt, entree);
            add(utilisateur);
            System.out.println("Y a-t-il un autre utilisateur ? (Oui/Non)");
            reponse = CreateOuiNon();
            cmpt++;

        } while (reponse.equals("Oui"));
        entree.close();
    }

    // Pour Alimentation :

    /**
     * La méthode VerifyTauxAlimentation permet de vérifier si l'utilisateur a bien
     * indiqué une valeur entre 0 et 1 pour le taux de boeuf et le taux de
     * vegetarien. Si l'utilisateur n'a pas saisi correctement le taux, l'erreur
     * TauxException apparaîtra à l'écran. Cette méthode est appelée par la méthode
     * CreateTauxAlimentation
     * 
     * @param d représente le taux d'alimentation saisie par l'utilisateur dans le
     *          terminal par le biais de la méthode CreateTauxAlimentation
     * @throws TauxException est une exception qui s'enclenche lorsque l'utilisateur
     *                       n'a pas saisie un taux entre 0 et 1
     */
    public static void VerifyTauxAlimentation(double d) throws TauxException {
        if ((d < 0) || (d > 1)) {
            throw new TauxException("Erreur : Veuillez inserer un taux doit être entre 0 et 1");
        }
    }

    /**
     * La méthode CreateTauxAlimentation permet de recueillir et de vérifier le taux
     * de repas à base de boeuf ou le taux de repas végétarien saisie à partir du
     * terminal. Le taux est nécessaire pour la création d'une instance Alimentation
     * dans la méthode CreerAlimentation
     * 
     * @return le taux de repas à base de boeuf ou le taux de repas végétarien
     */
    public static double CreateTauxAlimentation() {
        Scanner doub;
        boolean tmp = true;
        double s = 0;
        while (tmp) {
            try {
                doub = new Scanner(System.in);
                s = doub.nextDouble();
                VerifyTauxAlimentation(s);
                tmp = false;
            } catch (TauxException t) {
                System.out.println("Erreur : Veuillez inserer un taux doit être en 0 et 1");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    /**
     * La méthode CreerAlimentation permet de créer une instance Alimentation qui
     * sera définie à partir des informations saisies dans le terminal
     * 
     * @param cmpt   représente le numéro de l'utilisateur
     * @param entree représente un Scanner permettant de récupérer une entrée
     * @return une instance Alimentation
     * @throws TauxException est une exception qui s'enclenche lorsque l'utilisateur
     *                       n'a pas saisie un taux entre 0 et 1
     */
    public Alimentation CreerAlimentation(int cmpt, Scanner entree) throws TauxException {
        double txBoeuf, txVege;

        System.out.println(
                "Utilisateur " + cmpt + " : Quel est votre taux de repas à base de boeuf ? (une valeur entre 0 et 1)");
        txBoeuf = CreateTauxAlimentation();

        System.out.println(
                "Utilisateur " + cmpt + " : Quel est votre taux de repas végétariens ? (une valeur entre 0 et 1)");
        txVege = CreateTauxAlimentation();
        return new Alimentation(txBoeuf, txVege);
    }

    // Pour BienConso :

    /**
     * La méthode VerifyMontantBienConso permet de vérifier si l'utilisateur a bien
     * indiqué une valeur positive pour le montant des BienConso. Si l'utilisateur
     * n'a pas saisi correctement le taux, l'erreur MontantException apparaîtra à
     * l'écran. Cette méthode est appelée par la méthode CreateMontantBienConso
     * 
     * @param d représente le montant saisie par l'utilisateur dans le terminal par
     *          le biais de la méthode CreateMontantBienConso
     * @throws MontantException est une exception qui s'enclenche lorsque
     *                          l'utilisateur n'a pas saisie un montant positif
     */
    public static void VerifyMontantBienConso(double d) throws MontantException {
        if (d < 0) {
            throw new MontantException();
        }
    }

    /**
     * La méthode CreateMontantBienConso permet de recueillir et de vérifier le
     * montant du BienConso saisie à partir du terminal. Le montant est nécessaire
     * pour la création d'une instance BienConso dans la méthode CreerBienConso
     * 
     * @return le montant du BienConso
     */
    public static double CreateMontantBienConso() {
        Scanner doub;
        boolean tmp = true;
        double s = 0;
        while (tmp) {
            try {
                doub = new Scanner(System.in);
                s = doub.nextDouble();
                VerifyMontantBienConso(s);
                tmp = false;
            } catch (MontantException m) {
                System.out.println("Erreur : Veuillez inserer un montant positif");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    /**
     * La méthode CreerBienConso permet de créer une instance BienConso qui
     * sera définie à partir des informations saisies dans le terminal
     * 
     * @param cmpt   représente le numéro de l'utilisateur
     * @param entree représente un Scanner permettant de récupérer une entrée
     * @return une instance BienConso
     * @throws MontantException est une exception qui s'enclenche lorsque
     *                          l'utilisateur n'a pas saisie un montant positif
     */
    public BienConso CreerBienConso(int cmpt, Scanner entree) throws MontantException {
        double montant;
        System.out.println(
                "Utilisateur " + cmpt
                        + " : Quel est le montant de vos dépenses annuelles en biens de consommation ?");
        montant = CreateMontantBienConso();
        return new BienConso(montant);
    }

    // Pour Logement :

    /**
     * La méthode VerifySuperficieLogement permet de vérifier si l'utilisateur a
     * bien indiqué une valeur positive pour le montant des BienConso. Si
     * l'utilisateur n'a pas saisi correctement le taux, l'erreur
     * SuperficieException apparaîtra à l'écran. Cette méthode est appelée par la
     * méthode CreateSuperficieLogement
     * 
     * @param i représente la superficie du logement saisie par l'utilisateur dans
     *          le terminal par le biais de la méthode CreateSuperficieLogement
     * @throws SuperficieException est une exception qui s'enclenche lorsque
     *                             l'utilisateur n'a pas saisie une superficie
     *                             positive
     */
    public static void VerifySuperficieLogement(int i) throws SuperficieException {
        if (i <= 0) {
            throw new SuperficieException();
        }
    }

    /**
     * La méthode VerifyClasseEnergetiqueLogement permet de vérifier si
     * l'utilisateur a bien saisi une lettre de 'A' à 'G' dans le terminal. Si
     * l'utilisateur n'a pas saisi correctement la lettre, l'erreur
     * ClasseEnergetiqueException apparaîtra à l'écran. Cette méthode est appelée
     * par la méthode CreateClasseEnergetiqueLogement
     * 
     * @param s représente la classe énergétique saisie par l'utilisateur dans le
     *          terminal par le biais de la méthode CreateClasseEnergetiqueLogement
     * @throws ClasseEnergetiqueException est une exception qui s'enclenche lorsque
     *                                    l'utilisateur n'a pas saisie une classe
     *                                    énergétique entre A et G
     */
    public static void VerifyClasseEnergetiqueLogement(String s) throws ClasseEnergetiqueException {
        if (!(s.equals("A")
                || s.equals("B")
                || s.equals("C")
                || s.equals("D")
                || s.equals("E")
                || s.equals("F")
                || s.equals("G"))) {
            throw new ClasseEnergetiqueException("Erreur : Veuillez répondre par les lettres de A à G");
        }
    }

    /**
     * La méthode CreateSuperficieLogement permet de recueillir et de vérifier la
     * superficie du logement saisie à partir du terminal. La superficie est
     * nécessaire pour la création d'une instance Logement dans la méthode
     * CreerLogement
     * 
     * @return la superficie du logement
     */
    public static int CreateSuperficieLogement() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                VerifySuperficieLogement(s);
                tmp = false;
            } catch (SuperficieException sup) {
                System.out.println("Erreur : Veuillez inserer une superficie positive");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un entier");
            }
        }
        return s;
    }

    /**
     * La méthode CreateClasseEnergetiqueLogement permet de recueillir et de
     * vérifier la classe énergétique du logement saisie à partir du terminal. La
     * classe énergétique du logement est nécessaire pour la création d'une instance
     * Logement dans la méthode CreerLogement
     *
     * @return la classe énergétique du logement
     */
    public static String CreateClasseEnergetiqueLogement() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                VerifyClasseEnergetiqueLogement(s);
                tmp = false;
            } catch (ClasseEnergetiqueException e) {
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
     * @param entree représente un Scanner permettant de récupérer une entrée
     * @return une instance Logement
     * @throws SuperficieException est une exception qui s'enclenche lorsque
     *                             l'utilisateur n'a pas saisie une superficie
     *                             positive
     */
    public static Logement CreerLogement(int cmpt, Scanner entree, int numero)
            throws SuperficieException, ClasseEnergetiqueException {
        System.out.println("Utilisateur " + cmpt + " : Quelle est la superficie du logement ? (en m^2)");
        int superficie = CreateSuperficieLogement();

        System.out.println(
                "Utilisateur " + cmpt + " : Quelle est la classe énergétique du logement ? (une lettre de A à G)");
        String classeEnergetique = CreateClasseEnergetiqueLogement();

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
                return CreerLogement(cmpt, entree, numero);
        }
    }

    // Les 2 méthodes sont utiles pour la plupart des autres classes :

    /**
     * La méthode VerifyOuiNon permet de vérifier si l'utilisateur a bien répondu
     * par Oui ou par Non dans le terminal. Si l'utilisateur n'a pas saisi
     * correctement le taux, l'erreur ErreurOuiNon apparaîtra à l'écran. Cette
     * méthode est appelée par la méthode CreateOuiNon
     * 
     * @param s représente la réponse saisie par l'utilisateur dans le terminal par
     *          le biais de la méthode CreateOuiNon
     * @throws ErreurOuiNon est une exception qui s'enclenche lorsque l'utilisateur
     *                      ne répond pas par Oui ou par Non
     */
    public static void VerifyOuiNon(String s) throws ErreurOuiNon {
        if ((!(s.equals("Oui"))) && (!(s.equals("Non")))) {
            throw new ErreurOuiNon("Erreur : Veuillez répondre par 'Oui' ou 'Non'");
        }
    }

    /**
     * La méthode CreateOuiNon permet de recueillir et vérifier la réponse saisie
     * par l'utilisateur à partir du terminal
     * 
     * @return la chaîne de caractère Oui ou Non
     */
    public static String CreateOuiNon() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                VerifyOuiNon(s);
                tmp = false;
            } catch (ErreurOuiNon e) {
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
    public double empreintePopulation() {
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
    public void politiquePubliqueViande() {
        System.out.println(
                "Mise en place d'une politique publique visant à diviser par deux la consommation de repas à base de boeuf de chaque utilisateur de la population");
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
                "Impact carbone de la population avant la mise en place de cette politique : " + impact1 + " TCO2eq");
        System.out.println(
                "Impact carbone de la population après la mise en place de cette politique : " + impact2 + " TCO2eq");
        System.out.println(
                "La mise en place de cette politique a donc permis de réduire l'impact carbone de la population de "
                        + (impact1 - impact2) + " TCO2eq");
    }

    /**
     * La méthode politiquePubliqueEnergie permet de réaliser une simulation afin de
     * tester une mise en place d'une politique publique incitant la rénovation
     * énergétique de chaque utilisateur de la population afin que la classe
     * énergétique de chaque logement soit A
     * 
     */
    public void politiquePubliqueEnergie() {
        System.out.println(
                "Mise en place d'une politique publique incitant la rénovation énergétique de chaque utilisateur de la population afin que la classe énergétique de chaque logement soit A");
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
                "Impact carbone de la population avant la mise en place de cette politique : " + impact1 + " TCO2eq");
        System.out.println(
                "Impact carbone de la population après la mise en place de cette politique : " + impact2 + " TCO2eq");
        System.out.println(
                "La mise en place de cette politique a donc permis de réduire l'impact carbone de la population de "
                        + (impact1 - impact2) + " TCO2eq");
    }

}