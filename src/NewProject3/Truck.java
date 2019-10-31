package NewProject3;


import java.text.DateFormat;
import java.util.GregorianCalendar;

public class Truck extends Auto {

    private boolean FourByFour;

    public Truck() {
        super();
    }

    public double getCost() {
        return getBoughtCost();
    }

    public Truck(GregorianCalendar boughtOn, String name,
                 String nameOfBuyer, String trimPackage, boolean fourByFour) {
        super(boughtOn, name, nameOfBuyer);
        trim = trimPackage;
        FourByFour = fourByFour;
    }

    public Truck(GregorianCalendar boughtOn, String name,
                 int cost, String trimPackage, boolean fourByFour) {
        super(boughtOn, name, cost);
        trim = trimPackage;
        FourByFour = fourByFour;
    }

    public boolean isFourByFour() {
        return FourByFour;
    }

    public void setFourByFour(boolean fourByFour) {
        FourByFour = fourByFour;
    }

    @Override
    public String toString() {
        return "Truck     " +
                "trim=" + trim + "    " +
                ", FourByFour=" + FourByFour + "     " +
                ", autoName='" + autoName + '\'' + "     " +
                ' ';
    }
}