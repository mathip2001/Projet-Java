import Utilisateur.Population;
import consoCarbone.*;

public class Test {
    public static void main(String[] args)
            throws SuperficieException, TauxException, AmmortissementException, NbKilometresException {
        // Logement l1 = new Logement(100, CE.A);
        // System.out.println(l1);

        // Alimentation a1 = new Alimentation(0.1, 0.5);
        // System.out.println(a1);

        // Voiture v1 = new Voiture(true, Taille.P, 30040, 10);
        // System.out.println(v1);
        Population p = Population.getInstance();
        p.creerPopulation();

        // Alimentation a1 = creerAlimentation()

    }

}
