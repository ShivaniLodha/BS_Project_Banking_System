package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    JTextField textField;
    JButton b1, b2;

    Deposit(String pin) {
        this.pin = pin;

        // Setting up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 700);
        add(l3);

        // Label for deposit amount
        JLabel label = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label.setFont(new Font("system", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        label.setBounds(400, 180, 400, 30);
        l3.add(label);

        // Text field for amount
        textField = new JTextField();
        textField.setFont(new Font("raleway", Font.BOLD, 22));
        textField.setBackground(new Color(65, 128, 125));
        textField.setForeground(Color.WHITE);
        textField.setBounds(400, 220, 320, 30);
        l3.add(textField);

        // Deposit button
        b1 = new JButton("DEPOSIT");
        b1.setBounds(620, 300, 150, 30);
        b1.setBackground(new Color(65, 128, 125));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(620, 340, 150, 30);
        b2.setBackground(new Color(65, 128, 125));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        // Frame setup
        setLayout(null);
        setUndecorated(true);
        setSize(1500, 1080);
        setVisible(true);
        setLocation(0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText().trim();
            Date date = new Date();

            // Check if deposit button was clicked
            if (e.getSource() == b1) {
                // Validate if the input is empty or non-numeric
                if (amount.equals("") || !isNumeric(amount) || Integer.parseInt(amount) <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount to deposit.");
                    return;
                }

                // Create connection
                Conn c1 = new Conn();

                // Convert Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                // SQL query to insert deposit record using PreparedStatement to prevent SQL injection
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = c1.connection.prepareStatement(query);
                stmt.setString(1, pin);
                stmt.setDate(2, sqlDate); // Use sqlDate (java.sql.Date)
                stmt.setString(3, "Deposit");
                stmt.setString(4, amount);
                stmt.executeUpdate();

                // Show success message
                JOptionPane.showMessageDialog(null, "RS. " + amount + " Deposited Successfully");

                // Clear the text field after successful deposit
                textField.setText("");

                // Close the current window and return to the main screen
                setVisible(false);
                new Main_Class(pin);

            }
            // If the "BACK" button is clicked, return to the main screen
            else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    // Helper method to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Deposit("");  // Pass an empty string for testing purposes
    }
}
