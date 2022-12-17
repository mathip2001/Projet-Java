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
     * @param utilisateur l'objet à ajouter au sein de la population
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

    public static void TestReponse(String s) throws ErreurOuiNon {
        if ((!(s.equals("Oui"))) && (!(s.equals("Non")))) {
            throw new ErreurOuiNon("Veuillez répondre par 'Oui' ou 'Non'");
        }
    }

    public static void verifyAlimentation(double d) throws TauxException {
        if ((d < 0) || (d > 1)) {
            throw new TauxException();
        }
    }

    public static void verifyBienConso(double d) throws MontantException {
        if (d < 0) {
            throw new MontantException();
        }
    }

    public static double CreateDoubleAlimentation() {
        Scanner doub;
        boolean tmp = true;
        double s = 0;
        while (tmp) {
            try {
                doub = new Scanner(System.in);
                s = doub.nextDouble();
                verifyAlimentation(s);
                tmp = false;
            } catch (TauxException t) {
                System.out.println("Erreur : le taux doit être en 0 et 1");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    public static double CreateDoubleBienConso() {
        Scanner doub;
        boolean tmp = true;
        double s = 0;
        while (tmp) {
            try {
                doub = new Scanner(System.in);
                s = doub.nextDouble();
                verifyBienConso(s);
                tmp = false;
            } catch (MontantException m) {
                System.out.println("Erreur : Le montant doit être positif");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    public static double CreateIntLogement() {
        Scanner inte;
        boolean tmp = true;
        int s = 0;
        while (tmp) {
            try {
                inte = new Scanner(System.in);
                s = inte.nextInt();
                verifyBienConso(s);
                tmp = false;
            } catch (MontantException m) {
                System.out.println("Erreur : La superficie doit être positive");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez inserer un réel");
            }
        }
        return s;
    }

    public static String CreateOuiNon() {
        Scanner str;
        boolean tmp = true;
        String s = "";
        while (tmp) {
            try {
                str = new Scanner(System.in);
                s = str.next();
                TestReponse(s);
                tmp = false;
            } catch (ErreurOuiNon e) {
                System.out.println("Veuillez répondre par 'Oui' ou 'Non'");
            }
        }
        return s;
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
            throws TauxException, SuperficieException, AmmortissementException, NbKilometresException {

        System.out.println("Création de la population :");
        Scanner entree = new Scanner(System.in);
        int cmpt = 1;
        String reponse;

        do {
            Alimentation alimentation = creerAlimentation(cmpt, entree);
            BienConso bienConso = creerBienConso(cmpt, entree);
            // Logement logement = creerLogement(cmpt, entree, 1);
            // ServicesPublics servicesPublics = ServicesPublics.getInstance();
            // Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logement,
            // servicesPublics, cmpt, entree);
            // add(utilisateur);
            System.out.println("Y a-t-il un autre utilisateur ? (Oui/Non)");
            reponse = CreateOuiNon();
            cmpt++;

        } while (reponse.equals("Oui"));
        entree.close();
    }

    /**
     * La méthode creerAlimentation permet de créer une instance Alimentation qui
     * sera définie à partir des informations saisies dans le terminal
     * 
     * @param cmpt
     * @param entree
     * @return une instance Alimentation
     * @throws TauxException
     */
    public Alimentation creerAlimentation(int cmpt, Scanner entree) throws TauxException {
        double txBoeuf, txVege;

        System.out.println(
                "Utilisateur " + cmpt + " : Quel est votre taux de repas à base de boeuf ? (une valeur entre 0 et 1)");
        txBoeuf = CreateDoubleAlimentation();

        System.out.println(
                "Utilisateur " + cmpt + " : Quel est votre taux de repas végétariens ? (une valeur entre 0 et 1)");
        txVege = CreateDoubleAlimentation();
        return new Alimentation(txBoeuf, txVege);
    }

    /**
     * La méthode creerBienConso permet de créer une instance BienConso qui
     * sera définie à partir des informations saisies dans le terminal
     * 
     * @param cmpt
     * @param entree
     * @return une instance BienConso
     */
    public BienConso creerBienConso(int cmpt, Scanner entree) {
        double montant;
        System.out.println(
                "Utilisateur " + cmpt
                        + " : Quel est le montant de vos dépenses annuelles en biens de consommation ?");
        montant = CreateDoubleBienConso();
        return new BienConso(montant);
    }

    /**
     * La méthode creerLogement permet de créer une instance Logement qui
     * sera définie à partir des informations saisies dans le terminal
     *
     * @param cmpt
     * @param entree
     * @return une instance Logement
     * @throws SuperficieException
     */
    public static Logement creerLogement(int cmpt, Scanner entree, int numero) throws SuperficieException {
        System.out.println("Utilisateur " + cmpt + " : Quelle est la superficie du logement ? (en m^2)");
        int superficie = CreateIntLogement();

        System.out.println(
                "Utilisateur " + cmpt + " : Quelle est la classe énergétique du logement ? (une lettre de A à G)");
        String classeEnergetique = entree.next();
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
                return creerLogement(cmpt, entree, numero);
        }
    }

    public double empreintePopulation() {
        double impact = 0;
        for (Utilisateur u : listePopulation) {
            impact += u.calculerEmpreinte();
        }
        return impact;
    }

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