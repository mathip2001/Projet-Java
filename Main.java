import consoCarbone.*;
import Utilisateur.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws SuperficieException, TauxException, AmmortissementException, NbKilometresException {
        // Création de 3 objets Logements
        System.out.println("Creation de 3 objets Logements :");
        Logement l1 = new Logement(100, CE.A);
        System.out.println(l1);
        Logement l2 = new Logement(1000, CE.B);
        System.out.println(l2);
        Logement l3 = new Logement(15, CE.G);
        System.out.println(l3);

        // Utilisation de la méthode empreinteMoyLogement
        Logement.empreinteMoyLogement();
        System.out.println();

        // Création de 3 objets Alimentation
        System.out.println("Creation de 3 objets Alimentation :");
        Alimentation a1 = new Alimentation(0.1, 0.5);
        System.out.println(a1);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        System.out.println(a2);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        System.out.println(a3);

        // Utilisation de la méthode empreinteMoyAlimentation
        Alimentation.empreinteMoyAlimentation();
        System.out.println();

        // Création d'2 objets BienConso
        System.out.println("Creation de 2 objets BienConso :");
        BienConso b1 = new BienConso(50000);
        System.out.println(b1);
        BienConso b2 = new BienConso(10000);
        System.out.println(b2);
        System.out.println();

        // Utilisation de la méthode empreinteMoyBienConso
        BienConso.empreinteMoyBienConso();
        System.out.println();

        // Création de 2 objets Transport
        System.out.println("Creation de 2 objets Transport :");
        Transport t1 = new Transport(30040);
        System.out.println(t1);
        Transport t2 = new Transport(50000);
        System.out.println(t2);
        // Cas où l'utilisateur ne possede pas de voiture
        // System.out.println("Cas où l'utilisateur ne possede pas de voiture :");
        // Transport t2 = new Transport(false, null, 0, 0);
        // System.out.println(t2);
        // System.out.println();

        // Utilisation de la méthode empreinteMoyTransport
        Transport.empreinteMoyTransport();
        System.out.println();

        // Création d'1 objet ServicesPublics
        System.out.println("Creation d'1 objet ServicesPublics");
        ServicesPublics s1 = ServicesPublics.getInstance();
        System.out.println(s1);
        System.out.println();

        // Utilisation de la méthode empreinteMoyServicesPublics
        ServicesPublics.empreinteMoyServicesPublics();
        System.out.println();

        // Création de 2 objets Utilisateur
        System.out.println("Creation d'1 objet Utilisateur :");
        Scanner entree = new Scanner(System.in);
        int cmpt = 1;
        Utilisateur u1 = new Utilisateur(a1, b1, l1, s1, cmpt, entree);
        u1.detaillerEmpreinte();
        System.out.println();
        Utilisateur u2 = new Utilisateur(a2, b2, l2, s1, cmpt, entree);
        u2.detaillerEmpreinte();
        System.out.println();

        u1.trier();
        System.out.println();

        // Création d'1 objet Voiture
        System.out.println("Creation d'1 objet Voiture :");
        Voiture v1 = new Voiture(true, Taille.P, 30040, 10);
        System.out.println(v1);
        System.out.println();

        // Création d'1 objet Avion
        System.out.println("Creation d'1 objet Avion :");
        Avion av1 = new Avion(true, 30040);
        System.out.println(av1);
        System.out.println();

        // Création d'1 objet Metro
        System.out.println("Creation d'1 objet Metro :");
        Metro m1 = new Metro(true, 10000);
        System.out.println(m1);
        System.out.println();

        // Création d'1 objet RER
        System.out.println("Creation d'1 objet RER :");
        RER r1 = new RER(true, 20000);
        System.out.println(r1);
        System.out.println();

        // Création d'1 objet Tramway
        System.out.println("Creation d'1 objet Tramway :");
        Tramway tr1 = new Tramway(true, 20000);
        System.out.println(tr1);
        System.out.println();

        // Création d'1 objet TGV
        System.out.println("Creation d'1 objet TGV :");
        TGV tg1 = new TGV(true, 5000);
        System.out.println(tg1);
        System.out.println();

        // Création d'1 objet Bus
        System.out.println("Création d'1 objet Bus");
        Bus bu1 = new Bus(true, 2000);
        System.out.println(bu1);
        System.out.println();

        // Création d'1 objet Population
        System.out.println("Création d'1 objet Population");
        Population pop = Population.getInstance();
        pop.add(u1);
        pop.add(u2);
        pop.listing();

    }
}
