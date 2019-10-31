package NewProject3;

import org.junit.Test;

import java.text.DateFormat;

import static org.junit.Assert.*;

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
        assertEquals("Outback", test.get(0).getAutoName());
    }

    @Test
    public void testGetRowCount() {
        ListEngine test = new ListEngine();

        Truck testTruck = new Truck();
        test.add(testTruck);

        assertEquals(7, test.getRowCount());
    }

    @Test
    public void testGetRowCountOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertEquals(4, test.getRowCount());
    }

    @Test
    public void testGetColumnCountBought() {
        ListEngine test = new ListEngine();
        assertEquals(6, test.getColumnCount());
    }

    @Test
    public void testGetColumnCountSold() {
        ListEngine test = new ListEngine();
        test.setDisplay(1);
        assertEquals(6, test.getColumnCount());
    }

    @Test
    public void testGetColumnCountOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertEquals(4, test.getColumnCount());
    }

    @Test
    public void testGetValueAt() {
        ListEngine test = new ListEngine();

        for(int j = 0; j < test.getRowCount(); j++) {
            assertEquals(test.get(j).getAutoName(), test.getValueAt(j, 0));
            assertEquals(test.get(j).getBoughtCost(), test.getValueAt(j, 1));
            assertEquals(DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(test.get(j).getBoughtOn().getTime()), test.getValueAt(j, 2));
            assertEquals(test.get(j).getTrim(), test.getValueAt(j, 3));
//            if(test.get(j) instanceof Truck)
//                assertEquals(((Truck) test.get(j)).isFourByFour(), test.getValueAt(j, 4));
//            if(test.get(j) instanceof Car)
//                assertEquals(((Car) test.ge
//                        t(j)).isTurbo(), test.getValueAt(j, 4));
        }

    }
}
