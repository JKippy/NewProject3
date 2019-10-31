package NewProject3;

import java.text.DateFormat;
import java.util.GregorianCalendar;

public class Car extends Auto {

    private String trim;
    private boolean turbo;


    public Car() {
    }

    public double getCost() {
        return getBoughtCost();
    }

    public Car(GregorianCalendar boughtOn,  String name,
               String nameOfBuyer, String trim, boolean turbo) {
        super(boughtOn, name, nameOfBuyer);
        this.trim = trim;
        this.turbo = turbo;
    }

    public Car(GregorianCalendar boughtOn,  String name,
               int cost, String trim, boolean turbo) {
        super(boughtOn, name, cost);
        this.trim = trim;
        this.turbo = turbo;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "Car    " +
                "trim='" + trim + '\'' +  "    " +
                ", turbo=" + turbo + "    " +
                ", autoName='" + autoName + '\'' + "    " +
                ' ';
    }
}
