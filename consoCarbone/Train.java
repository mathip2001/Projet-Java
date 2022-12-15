package consoCarbone;

/**
 * Un objet issu de la classe Train permet de calculer l'impact carbone lié à
 * l'utilisation d'un train par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version 1
 */
public abstract class Train extends Transport{
    // Attributs
    protected boolean utilise; // un boolean indiquant si l'utilisateur.rice utilise un objet qui hérite de la classe Train

    // Constructeur
    public Train(int kilomAnnee){
        super(kilomAnnee);
    }

    /**
     * La méthode getUtilise permet de savoir si l'utilisateur.rice utilise 
     * un objet qui hérite de Train en tant que moyen de transport
     * 
     * @return true si l'utilisateur utilise un objet qui hérite de Train, false sinon
     */
    public boolean getUtilise() {
        return utilise;
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * Train
     * 
     * @return les attributs d'une instance Train
     */
    @Override
    public String toString() {
        return super.toString() + ", utilise=" + utilise;
    }
}
