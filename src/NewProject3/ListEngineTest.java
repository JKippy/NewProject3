package NewProject3;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;


public class ListEngineTest {
    @Test
    public void testColumnNameBought() {
        ListEngine test = new ListEngine();
        test.setDisplay(0);
        assertTrue(test.getColumnName(3).equals("Trim Package"));
    }

    @Test
    public void testColumnNameSold() {
        ListEngine test = new ListEngine();
        test.setDisplay(1);
        assertTrue(test.getColumnName(4).equals("Sold For"));
    }

    @Test
    public void testColumnNameOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertTrue(test.getColumnName(3).equals("Days overDue"));
    }

    @Test
    public void testGetDisplayBought() {
        ListEngine test = new ListEngine();
        test.setDisplay(0);
        assertEquals(test.getDisplay(), 0);

    }

    @Test
    public void testGetDisplaySold() {
        ListEngine test = new ListEngine();
        test.setDisplay(1);
        assertEquals(test.getDisplay(), 1);

    }

    @Test
    public void testGetDisplayOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertEquals(test.getDisplay(), 2);

    }

    @Test
    public void testGet() {
        ListEngine test = new ListEngine();
        assertEquals("Outback", test.get(0).getAutoName());


    }

    @Test
    public void testGetOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertEquals("F250", test.get(0).getAutoName());
    }

}