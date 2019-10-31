package NewProject3;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListEngineTest {

    @Test
    public void testColumnNameBought() {
        ListEngine test = new ListEngine();
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
    public void testRemove() {
        ListEngine test = new ListEngine();
        assertEquals(test.get(1), test.remove(1));
    }

    @Test
    public void testRemoveBought() {
        ListEngine test = new ListEngine();
        assertEquals(test.getSize(), 6);
    }

    @Test
    public void testRemoveSold() {
        ListEngine test = new ListEngine();
        test.setDisplay(1);
        assertEquals(test.getSize(), 0);
    }

    @Test
    public void testRemoveOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertEquals(test.getSize(), 3);
    }
}