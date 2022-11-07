import consoCarbone.*;
import consoCarbone2.*;

public class Main {

    public static void main(String[] args) {
        // Création de 3 objets logements
        System.out.println("Création de 3 objets logements :");
        Logement l1 = new Logement(100, CE.A);
        System.out.println(l1);
        Logement l2 = new Logement(1000, CE.B);
        System.out.println(l2);
        Logement l3 = new Logement(15, CE.G);
        System.out.println(l3);

        // Utilisation de la méthode statique pour calculer l'empreinte moyenne des
        // logements par individu
        System.out.println(Logement.empreinteMoyLogement());
        System.out.println();

        // Création de 3 objets alimentation
        System.out.println("Création de 3 objets alimentation :");
        Alimentation a1 = new Alimentation(0.5, 0.5);
        System.out.println(a1);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        System.out.println(a2);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        System.out.println(a3);

        // Utilisation de la méthode statique pour calculer l'empreinte moyenne de
        // l'alimentation par individu
        System.out.println(Alimentation.empreinteMoyAlimentation());
        System.out.println();

        // Création d'1 objet BienConso
        System.out.println("Création d'1 objet BienConso :");
        BienConso b1 = new BienConso(50000);
        System.out.println(b1);
        System.out.println();

        // Création d'1 objet Transport
        System.out.println("Création d'1 objet Transport :");
        Transport t1 = new Transport(true, Taille.P, 30040, 2);
        System.out.println(t1);
        System.out.println();

        // Création d'1 objet ServicesPublics
        System.out.println("Création d'1 objet ServicesPublics");
        ServicesPublics s1 = ServicesPublics.getInstance();
        System.out.println(s1);
        System.out.println();

        // Création d'1 objet Utilisateur
        System.out.println("Création d'1 objet Utilisateur :");
        Utilisateur u1 = new Utilisateur(a1, b1, l1, t1, s1);
        u1.detaillerEmpreinte();
        System.out.println();

    }
}