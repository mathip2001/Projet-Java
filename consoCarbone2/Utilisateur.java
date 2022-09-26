package consoCarbone2;

import javax.swing.event.SwingPropertyChangeSupport;

import consoCarbone.*;

public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;

    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport,
            ServicesPublics services) {
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logement = logement;
        this.transport = transport;
    }

    public double calculerEmpreinte() {
        return alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + transport.getImpact();
    }

    // public void detaillerEmpreinte() {

    // }

}