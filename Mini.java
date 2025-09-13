package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    Mini(String pin) {
        this.pin = pin;

        // Set up frame
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLayout(null);
        setLocation(20, 20);

        // Title Label
        JLabel labelTitle = new JLabel("Welcome To Statement!");
        labelTitle.setBounds(120, 20, 200, 30);
        labelTitle.setFont(new Font("system", Font.BOLD, 15));
        add(labelTitle);

        // Card Number Label
        JLabel labelCardNumber = new JLabel();
        labelCardNumber.setBounds(20, 80, 350, 30);
        add(labelCardNumber);



        // Transaction details label

        Date date = new Date();
        JLabel labelTransactionDetails1 = new JLabel(""+date);
        labelTransactionDetails1.setBounds(20, 120, 350, 250);
        labelTransactionDetails1.setFont(new Font("arial", Font.PLAIN, 12));
        add(labelTransactionDetails1);



        // Balance label
        JLabel labelBalance = new JLabel();
        labelBalance.setBounds(20, 400, 350, 30);
        labelBalance.setFont(new Font("raleway", Font.BOLD, 18));
        add(labelBalance);

        try {
            // Fetch and display card number (masked)
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM login1 WHERE pin = '" + pin + "'");


            while (resultSet.next()) {
                String cardNumber = resultSet.getString("card_number");
                // Display the card number (first 4 digits, then xxxxxxxx, then last 4 digits)
                labelCardNumber.setText("Card Number: " + cardNumber.substring(0, 4) + "xxxxxxxx" + cardNumber.substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        try {
            // Fetch and display transaction details and balance
            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");

            StringBuilder transactionDetails1 = new StringBuilder();

//+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            while(resultSet.next()){
                labelTransactionDetails1.setText(labelTransactionDetails1.getText()+"<html>"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br></html>");
//                labelTransactionDetails1.setText(labelTransactionDetails1.getText()+resultSet.getString("date")+resultSet.getString("type ")+resultSet.getString(" amount"));

                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){

                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
            }
            labelBalance.setText("You are Balaane is Rs : "+balance);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        // Exit Button
        button = new JButton("EXIT");
        button.setBounds(20, 450, 80, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        add(button);

        // Set frame visibility
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Main_Class(pin);  // Redirect to the main class when 'EXIT' is clicked
        setVisible(false);  // Close the mini statement window
    }

    public static void main(String[] args) {
        new Mini("");  // Replace "1234" with actual pin when using
    }
}
