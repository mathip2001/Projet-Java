package consoCarbone2;

import consoCarbone.*;

public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;
    private ServicesPublics services;

    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport,
            ServicesPublics services) {
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logement = logement;
        this.transport = transport;
        this.services = services;
    }

    /**
     * @return double
     */
    public double calculerEmpreinte() {
        return alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + transport.getImpact()
                + services.getImpact();
    }

    public void detaillerEmpreinte() {
        String res = "";
        res = res + "impact de l'alimentation : " + String.format("%.2f\n", alimentation.getImpact())
                + "impact de bienConso : "
                + String.format("%.2f\n", bienConso.getImpact()) + "impact du logement : "
                + String.format("%.2f\n", logement.getImpact()) + "impact du transport : "
                + String.format("%.2f\n", transport.getImpact()) + "impact du service public : "
                + String.format("%.2f\n", services.getImpact());
        System.out.println(res);

    }

}