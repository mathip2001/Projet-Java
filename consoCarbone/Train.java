package consoCarbone;

/**
 * Un objet issu de la classe Train permet de calculer l'impact carbone lié à
 * l'utilisation d'un train par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public abstract class Train extends Transport{
    // Constructeur
    public Train(int kilomAnnee){
        super(kilomAnnee);
    }
}
