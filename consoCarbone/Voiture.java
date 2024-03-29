package consoCarbone;

import consoCarbone.Exceptions.ExceptionAmmortissementVoiture;
import consoCarbone.Exceptions.ExceptionNbKilometresTransport;
import consoCarbone.Exceptions.ExceptionTailleVoiture;

/**
 * Un objet issu de la classe Voiture permet de calculer l'impact carbone lié à
 * l'utilisation d'une voiture par une personne par an
 * 
 * @author Julien RAMEAUX et Mathias YIP
 * @version du 22/12/2022
 */
public class Voiture extends Transport {
    // Attributs
    private Taille taille; // la taille de la voiture.
    private boolean possede; // un boolean indiquant si l’utilisateur.rice possède une voiture.
    private int amortissement;// durée de conservation de la voiture.
    private int numero; // numéro de la voiture (pour l'identifier lorsque l'utilisateur en a plusieurs)

    // Constructeur
    /**
     * Permet de construire un objet issu de la classe Voiture
     * @param possede représente la situation de possession ou non d'une voiture par l'utilisateur.rice
     * @param taille représente la taille de la voiture
     * @param kilomAnnee représente le nombre de kilomètres parcourus en voiture par an par l'utilisateur.rice 
     * @param amortissement représente la durée de conservation de la voiture
     * @param numero représente le numéro de la voiture (pour l'identifier lorsque l'utilisateur en a plusieurs)
     * @throws ExceptionAmmortissementVoiture est une exception qui s'enclenche lorsque l'utilisateur n'a pas saisie une durée d'amortissement positive
     * @throws ExceptionNbKilometresTransport est une exception qui s'enclenche lorsque l'utilisateur n'a pas saisie un nombre de kilomètre positif
     * @throws ExceptionTailleVoiture est une exception qui s'enclenche orsque l'utilisateur n'a pas saisie une taille correspondant à 'P' ou 'G'
     */
    public Voiture(boolean possede, Taille taille, int kilomAnnee, int amortissement, int numero)
            throws ExceptionAmmortissementVoiture, ExceptionNbKilometresTransport, ExceptionTailleVoiture {
        super(kilomAnnee);
        this.taille = taille;
        this.possede = possede;
        this.amortissement = amortissement;
        this.numero = numero;
        impact = impactFormula();
        if (amortissement <= 0) {
            throw new ExceptionAmmortissementVoiture();
        }
        if (!(taille.equals(Taille.P) || taille.equals(Taille.G))) {
            throw new ExceptionTailleVoiture();
        }
    }

    /**
     * La méthode impactFormula permet de calculer l'impact de l'utilisateur.rice
     * en utilisant la voiture
     * 
     * @return 0 si l'utilisateur.trice ne possède pas de voiture
     *         ou l'impact d'après la formule : "kilomAnnee x 1.93 x 10^-4 +
     *         fabrication/amortissement" sinon
     */
    public double impactFormula() {
        if (!possede) {
            return 0;
        } else {
            return kilomAnnee * 1.93 * Math.pow(10, -4) + this.taille.getProduction() / amortissement;
        }
    }

    /**
     * La méthode getPossede permet de savoir si l'utilisateur.rice possède une
     * voiture
     * 
     * @return true si l'utilisateur possède une voiture, false sinon
     */
    public boolean getPossede() {
        return possede;
    }

    /**
     * La méthode setPossede permet de modifier le statut de la possession d'une
     * voiture de l'utilisateur.rice
     * 
     * @param possede représente la nouvelle situation de possession ou non d'une
     *                voiture par l'utilisateur.rice
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
        this.impact = impactFormula();
    }

    /**
     * La méthode getTaille permet de récupérer la taille du véhicule de
     * l'utilisateur.rice
     * 
     * @return la taille du véhicule de l'utilisateur.rice
     */
    public Taille getTaille() {
        return taille;
    }

    /**
     * La méthode setTaille permet de modifier la taille du véhicule de
     * l'utilisateur.rice
     * 
     * @param taille représente la taille du nouveau véhicule de l'utilisateur.rice
     */
    public void setTaille(Taille taille) {
        this.taille = taille;
        this.impact = impactFormula();
    }

    /**
     * La méthode setKilomAnnee permet de modifier le nombre de kilomètres
     * parcourus en voiture par an par l'utilisateur.rice
     * 
     * @param kilomAnnee représente le nouveau nombre de kilomètres parcourus en
     *                   voiture par an
     *                   par l'utilisateur.rice
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
        this.impact = impactFormula();
    }

    /**
     * La méthode getAmortissement permet de récupérer la durée de conservation du
     * véhicule par l'utilisateur.rice
     * 
     * @return la durée de conservation du véhicule par l'utilisateur.rice
     */
    public int getAmortissement() {
        return amortissement;
    }

    /**
     * La méthode setAmortissement permet de modifier la durée de conservation du
     * véhicule par l'utilisateur.rice
     * 
     * @param amortissement représente la nouvelle durée de conservation du véhicule
     *                      par l'utilisateur.rice
     */
    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
        this.impact = impactFormula();

    }

    /**
     * La méthode getNumero permet de récupérer le numéro de la voiture
     * 
     * @return le numéro de la voiture
     */
    public int getNumero() {
        return numero;
    }

    /**
     * La méthode toString permet de donner un aperçu des attributs d'une instance
     * Voiture
     * 
     * @return les attributs d'une instance Voiture
     */
    @Override
    public String toString() {
        return super.toString() + ", taille=" + taille + ", possede="
                + possede + ", amortissement="
                + amortissement + "\noù le mode de transport est la voiture";
    }

}