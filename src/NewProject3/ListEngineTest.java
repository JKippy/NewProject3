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
        assertEquals(3, test.getRowCount());
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
    public void testGetValueAtDefault() {
        ListEngine test = new ListEngine();
        for (int j = 0; j < test.getRowCount(); j++) {
            assertEquals(test.get(j).getAutoName(), test.getValueAt(j, 0));
            assertEquals(test.get(j).getBoughtCost(), test.getValueAt(j, 1));
            assertEquals(DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(test.get(j).getBoughtOn().getTime()), test.getValueAt(j, 2));
            assertEquals(test.get(j).getTrim(), test.getValueAt(j, 3));
            if (test.get(j) instanceof Truck)
                assertEquals(((Truck) test.get(j)).isFourByFour(), test.getValueAt(j, 4));
            else
                assertEquals("-", test.getValueAt(j, 4));
            if (test.get(j) instanceof Car)
                assertEquals(((Car) test.get(j)).isTurbo(), test.getValueAt(j, 5));
            else
                assertEquals("-", test.getValueAt(j, 5));
        }

    }
    @Test
    public void testGetValueAtBought() {
        ListEngine test = new ListEngine();
        test.setDisplay(0);
        for (int j = 0; j < test.getRowCount(); j++) {
            assertEquals(test.get(j).getAutoName(), test.getValueAt(j, 0));
            assertEquals(test.get(j).getBoughtCost(), test.getValueAt(j, 1));
            assertEquals(DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(test.get(j).getBoughtOn().getTime()), test.getValueAt(j, 2));
            assertEquals(test.get(j).getTrim(), test.getValueAt(j, 3));
            if (test.get(j) instanceof Truck)
                assertEquals(((Truck) test.get(j)).isFourByFour(), test.getValueAt(j, 4));
            else
                assertEquals("-", test.getValueAt(j, 4));
            if (test.get(j) instanceof Car)
                assertEquals(((Car) test.get(j)).isTurbo(), test.getValueAt(j, 5));
            else
                assertEquals("-", test.getValueAt(j, 5));
        }
    }

    @Test
    public void testGetValueAtSold() {
        ListEngine test = new ListEngine();

        test.get(0).setSoldOn(test.get(0).getBoughtOn());
        test.setDisplay(1);
        test.updateScreen();

        for (int j = 0; j < test.getRowCount(); j++) {
            assertEquals(test.get(j).getAutoName(), test.getValueAt(j, 0));
            assertEquals(test.get(j).getBoughtCost(), test.getValueAt(j, 1));
            assertEquals(DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(test.get(j).getBoughtOn().getTime()), test.getValueAt(j, 2));
            assertEquals(test.get(j).getNameOfBuyer(), test.getValueAt(j, 3));
            assertEquals(test.get(j).getSoldPrice(), test.getValueAt(j, 4));
            assertEquals(DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(test.get(j).getSoldOn().getTime()), test.getValueAt(j, 5));
        }
    }

    @Test
    public void testGetValueOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        for (int j = 0; j < test.getRowCount(); j++) {
            assertEquals(test.get(j).getAutoName(), test.getValueAt(j, 0));
            assertEquals(test.get(j).getBoughtCost(), test.getValueAt(j, 1));
            assertEquals(DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(test.get(j).getBoughtOn().getTime()), test.getValueAt(j, 2));
            assertEquals(test.get(j).getOverDueDays(), test.getValueAt(j, 3));
        }
    }

    @Test (expected = RuntimeException.class)
    public void testGetValueInvalidDefault() {
        ListEngine test = new ListEngine();
        assertEquals(test.get(0).getAutoName(), test.getValueAt(0, 10));
    }

    @Test (expected = RuntimeException.class)
    public void testGetValueInvalidBought() {
        ListEngine test = new ListEngine();
        test.setDisplay(0);
        assertEquals(test.get(0).getAutoName(), test.getValueAt(0, 10));
    }

    @Test (expected = RuntimeException.class)
    public void testGetValueInvalidOverdue() {
        ListEngine test = new ListEngine();
        test.setDisplay(2);
        assertEquals(test.get(0).getAutoName(), test.getValueAt(0, 10));
    }

    @Test (expected = RuntimeException.class)
    public void testGetValueInvalidSold() {
        ListEngine test = new ListEngine();
        test.get(0).setSoldOn(test.get(0).getBoughtOn());
        test.setDisplay(1);
        test.updateScreen();
        assertEquals(test.get(0).getAutoName(), test.getValueAt(0, 10));
    }
}