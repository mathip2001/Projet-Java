import consoCarbone.*;
import Utilisateur.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws TauxException, MontantException, SuperficieException, ClasseEnergetiqueException,
            AmmortissementException, NbKilometresException, TailleVoitureException {
        
        Scanner scan = new Scanner(System.in);
        String rep;
        
        System.out.println("Avez-vous les informations d'un utilisateur stockées dans un fichier '.txt' ? (Oui/Non)");
        rep = Population.CreateOuiNon();
        while (rep.equals("Oui")){
            System.out.println("Veuillez entrer le nom du fichier avec l'extension '.txt' :");
            rep = scan.next();
            
        }
    }
}
