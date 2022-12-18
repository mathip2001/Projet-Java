package consoCarbone;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlimentationTest {
    @Test
    public void testImpactFormula() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        assertEquals(4.45, a1.ImpactFormula(), 1e-3);
        assertEquals(5.16, a2.ImpactFormula(), 1e-3);
        assertEquals(3.95, a3.ImpactFormula(), 1e-3);
    }

    @Test
    public void testGetID() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        assertEquals(0, a1.getID());
        assertEquals(1, a2.getID());
        assertEquals(2, a3.getID());
    }

    @Test
    public void testGetImpact() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        assertEquals(4.45, a1.getImpact(), 1e-3);
        assertEquals(5.16, a2.getImpact(), 1e-3);
        assertEquals(3.95, a3.getImpact(), 1e-3);
    }

    @Test
    public void testGetTxBoeuf() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        assertEquals(0.5, a1.getTxBoeuf(), 1e-3);
        assertEquals(0.6, a2.getTxBoeuf(), 1e-3);
        assertEquals(0.4, a3.getTxBoeuf(), 1e-3);
    }

    @Test
    public void testGetTxVege() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        assertEquals(0.5, a1.getTxVege(), 1e-3);
        assertEquals(0.4, a2.getTxVege(), 1e-3);
        assertEquals(0.3, a3.getTxVege(), 1e-3);
    }

    @Test
    public void testSetTxBoeuf() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        a1.setTxBoeuf(0.1);
        a2.setTxBoeuf(0.2);
        a3.setTxBoeuf(0.3);
        assertEquals(0.1, a1.getTxBoeuf(), 1e-3);
        assertEquals(0.2, a2.getTxBoeuf(), 1e-3);
        assertEquals(0.3, a3.getTxBoeuf(), 1e-3);
    }

    @Test
    public void testSetTxVege() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        Alimentation a2 = new Alimentation(0.6, 0.4);
        Alimentation a3 = new Alimentation(0.4, 0.3);
        a1.setTxVege(0.9);
        a2.setTxVege(0.8);
        a3.setTxVege(0.7);
        assertEquals(0.9, a1.getTxVege(), 1e-3);
        assertEquals(0.8, a2.getTxVege(), 1e-3);
        assertEquals(0.7, a3.getTxVege(), 1e-3);
    }

    @Test
    public void testToString() throws ExceptionTauxAlimentation {
        Alimentation a1 = new Alimentation(0.5, 0.5);
        assertEquals("Alimentation : ID=0, impact=4,45, txBoeuf=0.5, txVege=0.5", a1.toString());
    }
}
