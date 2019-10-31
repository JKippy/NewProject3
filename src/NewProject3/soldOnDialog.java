package NewProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class soldOnDialog extends JDialog implements ActionListener {

    private JTextField txtName;
    private JTextField txtDate;
    private JTextField txtCost;

    private JButton okButton;
    private JButton cancelButton;
    private int closeStatus;
    private Auto auto;
    static final int OK = 0;
    static final int CANCEL = 1;

    /*********************************************************
     Instantiate a Custom Dialog as 'modal' and wait for the
     user to provide data and click on a button.
     @param parent reference to the JFrame application
     @param auto an instantiated object to be filled with data
     *********************************************************/

    public soldOnDialog(JFrame parent, Auto auto) {
        // call parent and create a 'modal' dialog
        super(parent, true);

        this.auto = auto;
        setTitle("Sold to dialog box");
        closeStatus = CANCEL;
        setSize(400,200);

        // prevent user from closing window
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String stringDate = df.format(date);

        // instantiate and display two text fields
        txtName = new JTextField("Joe",30);
        txtDate = new JTextField(stringDate,15);
        txtCost = new JTextField("14000.00",15);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(4,2));
        textPanel.add(new JLabel("Name of Buyer: "));
        textPanel.add(txtName);
        textPanel.add(new JLabel("Sold on Date: "));
        textPanel.add(txtDate);
        textPanel.add(new JLabel("Sold for ($): "));
        textPanel.add(txtCost);
        getContentPane().add(textPanel, BorderLayout.CENTER);

        // Instantiate and display two buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setVisible (true);

    }

    /**************************************************************
     Respond to either button clicks
     @param e the action event that was just fired
     **************************************************************/
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        // if OK clicked the fill the object
        if (button == okButton) {
            closeStatus = OK;
            GregorianCalendar temp = new GregorianCalendar();
            SimpleDateFormat df;

            Date d;
            try {
                df = new SimpleDateFormat("MM/dd/yyyy");
                df.setLenient(false);
                d = df.parse(txtDate.getText());
                temp.setTime(d);
                if(temp.compareTo(this.auto.getBoughtOn()) < 0) {
                    throw new Exception();
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Invalid date. Setting date to " +
                        "default day.", "ERROR", JOptionPane.ERROR_MESSAGE);
                closeStatus = CANCEL;
            }

            auto.setNameOfBuyer(txtName.getText());
            auto.setSoldOn(temp);
            auto.setSoldPrice(Double.parseDouble(txtCost.getText()));
        }

        if(button == cancelButton) {
            dispose();
        }
        dispose();
    }

    /**************************************************************
     Return a String to let the caller know which button
     was clicked
     @return an int representing the option OK or CANCEL
     **************************************************************/
    public int getCloseStatus(){
        return closeStatus;
    }

}