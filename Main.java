import consoCarbone.Exceptions.*;
import Utilisateur.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args)
            throws ExceptionTauxAlimentation, ExceptionMontantBienConso, ExceptionSuperficieLogement,
            ExceptionClasseEnergetiqueLogement, ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport,
            ExceptionTailleVoiture, FileNotFoundException, ExceptionObjetInconnu {

        // Création de la population
        Population.creerPopulation();

        // Affichage des consommations carbone ordonnées des utilisateurs avec les
        // recommendations
        Population.AffichageConsoOrdre();

        // Simulation de la mise en place de politiques publiques
        Population.politiquePubliqueViande();
        Population.politiquePubliqueEnergie();
    }
}
