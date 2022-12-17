package Utilisateur;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;
import javax.xml.catalog.CatalogException;

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
     * La méthode add permet d'ajouter des utilisateurs au sein d'une population
     * 
     * @param utilisateur
     */
    public void add(Utilisateur utilisateur) {
        listePopulation.add(utilisateur);
    }

    /**
     * La méthode listing permet de lister les consommations carbones triées
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

    /**
     * La méthode creerPopulation permet de créer une unique instance population qui
     * sera défini à partir du terminal
     * 
     * @throws TauxException
     * @throws SuperficieException
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
            Logement logement = creerLogement(cmpt, entree, 1);
            ServicesPublics servicesPublics = ServicesPublics.getInstance();
            Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logement,
                    servicesPublics, cmpt, entree);
            add(utilisateur);
            System.out.println("Y a-t-il un autre utilisateur ? (Oui/Non)");

            try {
                reponse = entree.next();
                cmpt++;
                TestReponse(reponse);
            } catch (ErreurOuiNon e) {
                System.out.println("Veuillez répondre par 'Oui' ou 'Non'");
                reponse = entree.next();
            }
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
        try {
            System.out.println(
                    "Utilisateur " + cmpt
                            + " : Quel est votre taux de repas à base de boeuf ? (une valeur entre 0 et 1)");
            txBoeuf = entree.nextDouble();
        } catch (Exception e) {
            System.out.println("Veuillez insérer un réel.");
            txBoeuf = entree.nextDouble();
        }

        try {
            System.out.println(
                    "Utilisateur " + cmpt + " : Quel est votre taux de repas végétariens ? (une valeur entre 0 et 1)");
            txVege = entree.nextDouble();
        } catch (Exception e) {
            System.out.println("Veuillez insérer un réel.");
            txVege = entree.nextDouble();
        }
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
        System.out.println(
                "Utilisateur " + cmpt
                        + " : Quel est le montant de vos dépenses annuelles en biens de consommation ?");
        double montant = entree.nextDouble();
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
        int superficie = entree.nextInt();
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
}