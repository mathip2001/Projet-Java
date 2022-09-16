package consoCarbone

public enum CE {
    A, B, C, D, E, F, G
}

public class Logement {
    private int superficie;
    private CE classeEnergetique;
    private double impact;

    public Logement(int superficie, CE classeEnergetique, double impact) {
        this.superficie = superficie;
        this.classeEnergetique = classeEnergetique;
        // a revoir
        // if (classeEnergetique == 'A') {
        //     this.impact = impact*0.005;
        // } else if (classeEnergetique == 'B'){
        //     this.impact = impact*0.01;
        // } else if (classeEnergetique == 'C'){
        //     this.impact = impact*0.02;
        // } else if (classeEnergetique == 'D'){
        //     this.impact = impact*0.035;
        // } else if (classeEnergetique == 'E'){
        //     this.impact = impact*0.055;
        // } else if (classeEnergetique == 'F'){
        //     this.impact = impact*0.08;
        // } else {
        //     this.impact = impact*0.1;
        // } 
    }

    public int getSuperficie() {
        return superficie;
    }

    public CE getClasseEnergetique() {
        return classeEnergetique;
    }

    public double getImpact() {
        return impact;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setClasseEnergetique(CE classeEnergetique) {
        this.classeEnergetique = classeEnergetique;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    pu
}