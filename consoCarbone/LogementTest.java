package consoCarbone;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogementTest {
    @Test
    public void testImpactFormula() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        assertEquals(0.50, l1.ImpactFormula(), 1e-3);
        assertEquals(10.00, l2.ImpactFormula(), 1e-3);
        assertEquals(1.50, l3.ImpactFormula(), 1e-3);
    }

    @Test
    public void testGetClasseEnergetique() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        assertEquals(CE.A, l1.getClasseEnergetique());
        assertEquals(CE.B, l2.getClasseEnergetique());
        assertEquals(CE.G, l3.getClasseEnergetique());
    }

    @Test
    public void testGetID() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        assertEquals(0, l1.getID());
        assertEquals(1, l2.getID());
        assertEquals(2, l3.getID());
    }

    @Test
    public void testGetImpact() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        assertEquals(0.50, l1.getImpact(), 1e-3);
        assertEquals(10.00, l2.getImpact(), 1e-3);
        assertEquals(1.50, l3.getImpact(), 1e-3);
    }

    @Test
    public void testGetSuperficie() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        assertEquals(100, l1.getSuperficie());
        assertEquals(1000, l2.getSuperficie());
        assertEquals(15, l3.getSuperficie());
    }

    @Test
    public void testSetClasseEnergetique() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        l1.setClasseEnergetique(CE.B);
        l2.setClasseEnergetique(CE.C);
        l3.setClasseEnergetique(CE.A);
        assertEquals(CE.B, l1.getClasseEnergetique());
        assertEquals(CE.C, l2.getClasseEnergetique());
        assertEquals(CE.A, l3.getClasseEnergetique());
    }

    @Test
    public void testSetSuperficie() {
        Logement l1 = new Logement(100, CE.A);
        Logement l2 = new Logement(1000, CE.B);
        Logement l3 = new Logement(15, CE.G);
        l1.setSuperficie(20);
        l2.setSuperficie(40);
        l3.setSuperficie(60);
        assertEquals(20, l1.getSuperficie());
        assertEquals(40, l2.getSuperficie());
        assertEquals(60, l3.getSuperficie());
    }

    @Test
    public void testToString() {
        Logement l1 = new Logement(100, CE.A);
        assertEquals("Logement : ID=0, impact=0,50, superficie=100, classeEnergetique=A", l1.toString());
    }
}
