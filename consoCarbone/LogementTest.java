package consoCarbone;

import static org.junit.Assert.*;

import org.junit.Test;

import consoCarbone.Exceptions.ExceptionClasseEnergetiqueLogement;
import consoCarbone.Exceptions.ExceptionSuperficieLogement;

public class LogementTest {
    @Test
    public void testImpactFormula() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        assertEquals(0.50, l1.ImpactFormula(), 1e-3);
        assertEquals(10.00, l2.ImpactFormula(), 1e-3);
        assertEquals(1.50, l3.ImpactFormula(), 1e-3);
    }

    @Test
    public void testGetClasseEnergetique() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        assertEquals(CE.A, l1.getClasseEnergetique());
        assertEquals(CE.B, l2.getClasseEnergetique());
        assertEquals(CE.G, l3.getClasseEnergetique());
    }

    @Test
    public void testGetID() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        assertEquals(0, l1.getID());
        assertEquals(1, l2.getID());
        assertEquals(2, l3.getID());
    }

    @Test
    public void testGetImpact() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        assertEquals(0.50, l1.getImpact(), 1e-3);
        assertEquals(10.00, l2.getImpact(), 1e-3);
        assertEquals(1.50, l3.getImpact(), 1e-3);
    }

    @Test
    public void testGetSuperficie() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        assertEquals(100, l1.getSuperficie());
        assertEquals(1000, l2.getSuperficie());
        assertEquals(15, l3.getSuperficie());
    }

    @Test
    public void testGetNumero() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        assertEquals(1, l1.getNumero());
        assertEquals(2, l2.getNumero());
        assertEquals(3, l3.getNumero());
    }

    @Test
    public void testSetClasseEnergetique() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        l1.setClasseEnergetique(CE.B);
        l2.setClasseEnergetique(CE.C);
        l3.setClasseEnergetique(CE.A);
        assertEquals(CE.B, l1.getClasseEnergetique());
        assertEquals(CE.C, l2.getClasseEnergetique());
        assertEquals(CE.A, l3.getClasseEnergetique());
    }

    @Test
    public void testSetSuperficie() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        Logement l2 = new Logement(1000, CE.B, 2);
        Logement l3 = new Logement(15, CE.G, 3);
        l1.setSuperficie(20);
        l2.setSuperficie(40);
        l3.setSuperficie(60);
        assertEquals(20, l1.getSuperficie());
        assertEquals(40, l2.getSuperficie());
        assertEquals(60, l3.getSuperficie());
    }

    @Test
    public void testToString() throws ExceptionSuperficieLogement, ExceptionClasseEnergetiqueLogement {
        Logement l1 = new Logement(100, CE.A, 1);
        assertEquals("Logement : ID=0, impact=0,50, superficie=100, classeEnergetique=A", l1.toString());
    }
}
