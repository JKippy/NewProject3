package NewProject3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;


public class ListEngine extends AbstractTableModel {

    private static final int boughtScrn = 0;
    private static final int soldScrn = 1;
    private static final int overDueScrn = 2;

    private ArrayList<Auto> listAutos;
    private ArrayList<Auto> filteredListAutos;

    int display = -1;

    private String[] columnNamesBought = {"Auto Name", "Bought Cost",
            "Bought Date", "Trim Package ", "Four by Four", "Turbo"};

    private String[] columnNamesSold = {"Auto Name", "Bought Cost", "Bought Date", "Buyer's Name",
            "Sold For", "Sold On"};

    private String[] columnNamesOverDue = {"Auto Name", "Bought Cost", "Bought Date", "Days overDue"};

    @Override
    public String getColumnName(int col) {
        switch(display){
            case soldScrn:
                System.out.println(columnNamesSold[col]);
                return columnNamesSold[col];
            case overDueScrn:
                System.out.println(columnNamesOverDue[col]);
                return columnNamesOverDue[col];
            default:
                System.out.println(columnNamesBought[col]);
                return columnNamesBought[col];
        }
    }

    public ListEngine() {
        super();
        listAutos = new ArrayList<Auto>();
        filteredListAutos = new ArrayList<Auto>();
        createList();
    }

    public void setDisplay(int selected){
        display = selected;
        updateScreen();
    }

    public int getDisplay(){
        return display;
    }

    public Auto remove(int i) {
        return null;
    }

    public void add(Auto a) {
        switch(display){
            case soldScrn:
                filteredListAutos.add(a);
            case overDueScrn:
                filteredListAutos.add(a);
            case boughtScrn:
                filteredListAutos.add(a);
            default:
                listAutos.add(a);
        }
        fireTableDataChanged();
    }

    public Auto get(int i) {
        switch(display){
            case soldScrn:
                return filteredListAutos.get(i);
            case overDueScrn:
                return filteredListAutos.get(i);
            case boughtScrn:
                return filteredListAutos.get(i);
            default:
                return listAutos.get(i);
        }
    }

    public int getSize() {
        switch(display){
            case soldScrn:
                return filteredListAutos.size();
            case overDueScrn:
                return filteredListAutos.size();
            case boughtScrn:
                return filteredListAutos.size();
            default:
                return listAutos.size();
        }
    }

    @Override
    public int getRowCount() {
        switch(display){
            case soldScrn:
                return filteredListAutos.size();
            case overDueScrn:
                return filteredListAutos.size();
            case boughtScrn:
                return filteredListAutos.size();
            default:
                return listAutos.size();
        }
    }

    @Override
    public int getColumnCount() {
        switch(display){
            case soldScrn:
                return columnNamesSold.length;
            case overDueScrn:
                return columnNamesOverDue.length;
            default:
                return columnNamesBought.length;
        }    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(display){
            case soldScrn:
                switch (col) {
                    case 0:
                        return (filteredListAutos.get(row).getAutoName());

                    case 1:
                        return (filteredListAutos.get(row).getBoughtCost());

                    case 2:
                        return (DateFormat.getDateInstance(DateFormat.SHORT)
                                .format(filteredListAutos.get(row).getBoughtOn().getTime()));

                    case 3:
                        return (filteredListAutos.get(row).getNameOfBuyer());

                    case 4:
                        return (filteredListAutos.get(row).getSoldPrice());
                    case 5:
                        return (DateFormat.getDateInstance(DateFormat.SHORT)
                                .format(filteredListAutos.get(row).getSoldOn().getTime()));

                    default:
                        throw new RuntimeException("JTable row,col out of range: " + row + " " + col);
                }
            case overDueScrn:
                switch (col) {
                    case 0:
                        return (filteredListAutos.get(row).getAutoName());

                    case 1:
                        return (filteredListAutos.get(row).getBoughtCost());

                    case 2:
                        return (DateFormat.getDateInstance(DateFormat.SHORT)
                                .format(filteredListAutos.get(row).getBoughtOn().getTime()));
                    case 3:
                        return (filteredListAutos.get(row).getOverDueDays());
                    default:
                        throw new RuntimeException("JTable row,col out of range: " + row + " " + col);
                }
            case boughtScrn:
                switch (col) {
                    case 0:
                        return (filteredListAutos.get(row).getAutoName());

                    case 1:
                        return (filteredListAutos.get(row).getBoughtCost());

                    case 2:
                        return (DateFormat.getDateInstance(DateFormat.SHORT)
                                .format(filteredListAutos.get(row).getBoughtOn().getTime()));

                    case 3:
                        return (filteredListAutos.get(row).getTrim());

                    case 4:
                    case 5:
                        if (filteredListAutos.get(row) instanceof Truck)
                            if (col == 4)
                                return (((Truck) filteredListAutos.get(row)).isFourByFour());
                            else
                                return "-";

                        else {
                            if (col == 5)
                                return (((Car) filteredListAutos.get(row)).isTurbo());
                            else
                                return "-";
                        }
                    default:
                        throw new RuntimeException("JTable row,col out of range: " + row + " " + col);
                }
            default:
                switch (col) {
                    case 0:
                        return (listAutos.get(row).getAutoName());

                    case 1:
                        return (listAutos.get(row).getBoughtCost());

                    case 2:
                        return (DateFormat.getDateInstance(DateFormat.SHORT)
                                .format(listAutos.get(row).getBoughtOn().getTime()));

                    case 3:
                        return (listAutos.get(row).getTrim());

                    case 4:
                    case 5:
                        if (listAutos.get(row) instanceof Truck)
                            if (col == 4)
                                return (((Truck) listAutos.get(row)).isFourByFour());
                            else
                                return "-";

                        else {
                            if (col == 5)
                                return (((Car) listAutos.get(row)).isTurbo());
                            else
                                return "-";
                        }
                    default:
                        throw new RuntimeException("JTable row,col out of range: " + row + " " + col);
                }
        }
    }

    public void updateScreen(){
        switch(display){
            case soldScrn:
                filteredListAutos = (ArrayList<Auto>)listAutos.stream().filter(arg -> arg.soldOn != null).collect(Collectors.toList());
                Collections.sort(filteredListAutos, Comparator.comparing(arg2 -> arg2.nameOfBuyer));
                break;
            case boughtScrn:
                filteredListAutos = (ArrayList<Auto>)listAutos.stream().filter(arg -> arg.soldOn == null).collect(Collectors.toList());
                Collections.sort(filteredListAutos, Comparator.comparing(arg2 -> arg2.getBoughtOn()));
                break;
            case overDueScrn:
                filteredListAutos = (ArrayList<Auto>)listAutos.stream().filter(arg -> arg.soldOn == null).collect(Collectors.toList());
                filteredListAutos = (ArrayList<Auto>)filteredListAutos.stream().filter(arg -> arg.getOverDueDays() > 90).collect(Collectors.toList());
                Collections.sort(filteredListAutos, Comparator.comparing(arg2 -> arg2.getOverDueDays()));
                break;
        }
        fireTableDataChanged();
        fireTableStructureChanged();
    }

    public void saveDatabase(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(listAutos);
            os.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in saving db");

        }
    }

    public void loadDatabase(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream is = new ObjectInputStream(fis);

            listAutos = (ArrayList<Auto>) is.readObject();
            fireTableDataChanged();
            is.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in loading db");
        }
    }

    /*****************************************************************
     * The following code is half baked code. It should help you
     * understand how to save to a text file.
     *
     * @param filename Name of the file where the data is being loaded from
     */
    public void saveAsText(String filename) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException ex) {
            throw new IllegalArgumentException();
        }

        Auto auto;
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        pw.println(listAutos.size());

        for(int i = 0; i < listAutos.size(); i++) {
            auto = listAutos.get(i);

            if(auto instanceof Car) {
                pw.println("Car");
                pw.println(((Car) auto).isTurbo());
            } else {
                pw.println("Truck");
                pw.println(((Truck) auto).isFourByFour());
            }

            pw.println(auto.getAutoName());
            pw.println(auto.getBoughtCost());

            GregorianCalendar tempBoughtDate;
            tempBoughtDate = auto.getBoughtOn();

            pw.println(df.format(tempBoughtDate.getTime()));

            pw.println(auto.getTrim());

            if(auto.getNameOfBuyer() != null)
                pw.println(auto.getNameOfBuyer());
            else
                pw.println("No buyer's name");

            pw.println(auto.getSoldPrice());

            GregorianCalendar tempSoldDate;
            tempSoldDate = auto.getSoldOn();

            if(tempSoldDate != null) {
                pw.println(df.format(tempSoldDate.getTime()));
            }  else
                pw.println("No sold date");

            //90 days overdue here
        }

        pw.close();
    }

    /*****************************************************************
     * The following code is half baked code. It should help you
     * understand how to load to a text file.  THis code does NOT
     * function correctyly but, should give you a great start to
     * your code.
     *
     * @param filename Name of the file where the data is being stored in
     */
    public void loadFromText(String filename) {
        try{
            listAutos.clear();
            Scanner fileReader = new Scanner(new File(filename));

            int numOfAutos = Integer.parseInt(fileReader.nextLine());

            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

            Car tempCar;
            Truck tempTruck;

            for(int i = 0; i < numOfAutos; i++) {
                String autoType = fileReader.nextLine();
                boolean boolAutoValue = Boolean.parseBoolean(fileReader.nextLine());
                String autoName = fileReader.nextLine();
                double autoBoughtPrice = Double.parseDouble(fileReader.nextLine());

                GregorianCalendar tempBoughtDate = new GregorianCalendar();
                Date d = df.parse(fileReader.nextLine());
                tempBoughtDate.setTime(d);

                String autoTrim = fileReader.nextLine();

                String autoBuyerName = fileReader.nextLine();
                if(autoBuyerName.equals("No buyer's name"))
                    autoBuyerName = null;

                double autoSoldPrice = Double.parseDouble(fileReader.nextLine());

                GregorianCalendar tempSoldDate = new GregorianCalendar();
                String checkSoldDate = fileReader.nextLine();
                if(checkSoldDate.equals("No sold date")) {
                    tempSoldDate = null;

                } else {
                    Date d2 = df.parse(checkSoldDate);
                    tempSoldDate.setTime(d2);
                }

                if(autoType.equals("Car")) {
                    tempCar = new Car(tempBoughtDate, autoName, autoBuyerName, autoTrim, boolAutoValue);
                    tempCar.setBoughtCost(autoBoughtPrice);
                    tempCar.setSoldOn(tempSoldDate);
                    tempCar.setSoldPrice(autoSoldPrice);
                    listAutos.add(tempCar);
                }
                if(autoType.equals("Truck")) {
                    tempTruck = new Truck(tempBoughtDate, autoName, autoBuyerName, autoTrim, boolAutoValue);
                    tempTruck.setBoughtCost(autoBoughtPrice);
                    tempTruck.setSoldOn(tempSoldDate);
                    tempTruck.setSoldPrice(autoSoldPrice);
                    listAutos.add(tempTruck);
                }
            }

            fireTableDataChanged();
            fileReader.close();
        } catch(Exception e) {
            System.out.println("Error");
            throw new IllegalArgumentException();
        }
    }

    public void createList() {

        // This code has been provided to get you started on the project.

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        GregorianCalendar temp3 = new GregorianCalendar();
        GregorianCalendar temp4 = new GregorianCalendar();
        GregorianCalendar temp5 = new GregorianCalendar();
        GregorianCalendar temp6 = new GregorianCalendar();

        try {
            Date d1 = df.parse("3/20/2019");
            temp1.setTime(d1);
            Date d2 = df.parse("9/20/2019");
            temp2.setTime(d2);
            Date d3 = df.parse("12/20/2018");
            temp3.setTime(d3);
            Date d4 = df.parse("9/20/2019");
            temp4.setTime(d4);
            Date d5 = df.parse("1/20/2010");
            temp5.setTime(d5);
            Date d6 = df.parse("10/20/2019");
            temp6.setTime(d6);


            Car Car1 = new Car(temp3, "Outback", "Buyer1", "LX", false);
            Car Car2 = new Car(temp2, "Chevy", "Buyer2", "EX", false);
            Car Car3 = new Car(temp6, "Focus", "Buyer3", "EX", true);
            Truck Truck1 = new Truck(temp4, "F150", "BuyerA", "LX", false);
            Truck Truck2 = new Truck(temp1, "F250", "BuyerB", "LX", false);
            Truck Truck3 = new Truck(temp5, "F350", "BuyerC", "EX", true);

            add(Car1);
            add(Car2);
            add(Car3);
            add(Truck1);
            add(Truck2);
            add(Truck3);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

    }

/*
   Here is the instructor's test data.  This will be the starting point for project
   demonstration day.
 SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        GregorianCalendar temp3 = new GregorianCalendar();
        GregorianCalendar temp4 = new GregorianCalendar();
        GregorianCalendar temp5 = new GregorianCalendar();
        GregorianCalendar temp6 = new GregorianCalendar();
        try {
            Date d1 = df.parse("3/20/2019");
            temp1.setTime(d1);
            Date d2 = df.parse("9/20/2019");
            temp2.setTime(d2);
            Date d3 = df.parse("12/20/2018");
            temp3.setTime(d3);
            Date d4 = df.parse("9/20/2019");
            temp4.setTime(d4);
            Date d5 = df.parse("1/20/2010");
            temp5.setTime(d5);
            Date d6 = df.parse("10/20/2019");
            temp6.setTime(d6);
            Car Car1 = new Car (temp1, "Outback", 18000,"LX", false);
            Car Car2 = new Car (temp2, "Chevy", 11000,"EX", false);
            Car Car3 = new Car (temp3, "Focus", 19000,"EX", true);
            Truck Truck1 = new Truck(temp4,"F150",12000,"Tow",false);
            Truck Truck2 = new Truck(temp5,"F250",42000,"NA",false);
            Truck Truck3 = new Truck(temp1,"F350",2000,"Turbo",true);
            add(Car1);
            add(Car2);
            add(Car3);
            add(Truck1);
            add(Truck2);
            add(Truck3);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }
    }
 */
}