/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pawel
 */
public class NGramTest {

    public NGramTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPrefiks method, of class NGram.
     */
    @Test
    public void testGetPrefiks() {
        System.out.println("getPrefiks");
        NGram instance = new NGram("prefiks", "sufiks");
        String expResult = "prefiks";
        String result = instance.getPrefiks();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSufiks method, of class NGram.
     */
    @Test
    public void testGetSufiks() {
        System.out.println("getSufiks");
        NGram instance = new NGram("prefiks", "sufiks");
        String expResult = "sufiks";
        String result = instance.getSufiks();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrefiksWyst method, of class NGram.
     */
    @Test
    public void testGetPrefiksWyst() {
        System.out.println("getPrefiksWyst");
        NGram instance = new NGram("prefiks", "sufiks");
        int expResult = 1;
        int result = instance.getPrefiksWyst();
        assertEquals(expResult, result);
        }

    /**
     * Test of getSufiksWyst method, of class NGram.
     */
    @Test
    public void testGetSufiksWyst() {
        System.out.println("getSufiksWyst");
        NGram instance = new NGram("prefiks", "sufiks");
        int expResult = 1;
        int result = instance.getSufiksWyst();
        assertEquals(expResult, result);
        }

    /**
     * Test of getNGram method, of class NGram.
     */
    @Test
    public void testGetNGram() {
        System.out.println("getNGram");
        NGram instance = new NGram("prefiks", "sufiks");
        String expResult = "prefiks"+"sufiks";
        String result = instance.getNGram();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class NGram.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NGram instance = new NGram("prefiks", "sufiks");
        String expResult = "prefiks" + "sufiks ( 1 , 1 )";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class NGram.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        NGram instance = new NGram("prefiks", "sufiks");
        NGram n = new NGram("prefiks", "sufiks");
        int expResult = 0;
        int result = instance.compareTo(n);
        assertEquals(expResult, result);
        }
}
