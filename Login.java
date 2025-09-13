package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login() {
        super("BANK MANAGEMENT SYSTEM");

        // Bank Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        // Card Icon
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 330, 100, 100);
        add(iimage);

        // Welcome label
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("avantgrade", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        // Card Number label and text field
        label2 = new JLabel("CARD NO:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("railway", Font.BOLD, 28));
        label2.setBounds(150, 190, 375, 30);
        add(label2);
        textField2 = new JTextField(15);
        textField2.setFont(new Font("arial", Font.BOLD, 14));
        textField2.setBounds(325, 190, 230, 30);
        add(textField2);

        // PIN label and password field
        label3 = new JLabel("PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("railway", Font.BOLD, 28));
        label3.setBounds(150, 230, 365, 50);
        add(label3);
        passwordField3 = new JPasswordField(15);
        passwordField3.setFont(new Font("arial", Font.BOLD, 28));
        passwordField3.setBounds(325, 230, 230, 30);
        add(passwordField3);

        // Sign In button
        button1 = new JButton("SIGN IN");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setFont(new Font("arial", Font.BOLD, 14));
        button1.setBounds(350, 300, 130, 35);
        button1.addActionListener(this);
        add(button1);

        // Clear button
        button2 = new JButton("CLEAR");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 350, 130, 35);
        button2.setFont(new Font("arial", Font.BOLD, 14));
        button2.addActionListener(this);
        add(button2);

        // Sign Up button
        button3 = new JButton("SIGN UP");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setFont(new Font("arial", Font.BOLD, 14));
        button3.setBounds(290, 350, 130, 35);
        button3.addActionListener(this);
        add(button3);

        // Background image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 450, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 450);
        add(iiimage);

        // Frame settings
        setLayout(null);
        setSize(858, 480);
        setLocation(450, 200);
//        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // If Sign In button is clicked
            if (e.getSource() == button1) {
                Conn c = new Conn();
                String cardno = textField2.getText().trim();  // Trim input to avoid extra spaces
                String pin = String.valueOf(passwordField3.getPassword()).trim();  // Trim PIN input

                System.out.println("Card Number: " + cardno);  // Debugging output
                System.out.println("PIN: " + pin);

                // Ensure card number and pin are not empty
                if (cardno.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Card Number and PIN cannot be empty.");
                    return;
                }

//                 SQL query to validate the user credentials
                String q = "SELECT * FROM login1 WHERE TRIM(card_number) = ? AND  TRIM(pin) = ?";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setString(1, cardno);
                ps.setString(2, pin);

                ResultSet resultSet = ps.executeQuery();

//                ResultSet resultSet = c.statement.executeQuery("select * from login1 where card_number = '"+cardno+"' and pin = '"+pin+"'");

                // If credentials match
                if (resultSet.next()) {
                    // Successfully authenticated, hide the login window
                    setVisible(false);

                    // Pass pin to Main_Class and open it
                    new Main_Class(pin);

                } else {
                    // Invalid login credentials
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN.");
                }

            }
            // If Clear button is clicked
            else if (e.getSource() == button2) {
                // Clear the text fields
                textField2.setText("");
                passwordField3.setText("");
            }
            // If Sign Up button is clicked
            else if (e.getSource() == button3) {
                // Open the Sign Up page
                new Signup();
                setVisible(false);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
