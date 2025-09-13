package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1, b2;

    Withdrawl(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 690, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 690);
        add(l3);

        JLabel lable1 = new JLabel("MAXIMUM WITHDRAWAL IS RS 10,000");
        lable1.setForeground(Color.WHITE);
        lable1.setFont(new Font("raleway", Font.BOLD, 14));
        lable1.setBounds(420, 180, 500, 35);
        l3.add(lable1);

        JLabel lable2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        lable2.setForeground(Color.WHITE);
        lable2.setFont(new Font("raleway", Font.BOLD, 14));
        lable2.setBounds(420, 220, 400, 35);
        l3.add(lable2);

        textField = new JTextField();  // Use the class-level variable
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("raleway", Font.BOLD, 22));
        textField.setBounds(420, 260, 300, 25);
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("raleway", Font.BOLD, 12));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(620, 300, 150, 30);
        b1.addActionListener(this);  // Add action listener for withdraw
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("raleway", Font.BOLD, 12));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(620, 340, 150, 30);
        b2.addActionListener(this);  // Add action listener for back
        l3.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                String amount = textField.getText().trim();
                Date date = new Date();

                if (amount.equals("") || Integer.parseInt(amount) <= 0) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Amount to Withdraw");
                    return;
                }

                // Convert the java.util.Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                Conn c1 = new Conn();
                // Use PreparedStatement to prevent SQL injection
                String query = "SELECT * FROM bank WHERE pin = ?";
                PreparedStatement stmt = c1.connection.prepareStatement(query);
                stmt.setString(1, pin);

                ResultSet resultSet = stmt.executeQuery();

                int balance = 0;

                // Calculate balance from transaction history
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else if (resultSet.getString("type").equals("Withdraw")) {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                // Check if the withdrawal amount exceeds available balance
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Insert the withdrawal transaction
                String insertQuery = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = c1.connection.prepareStatement(insertQuery);
                insertStmt.setString(1, pin);
                insertStmt.setDate(2, sqlDate);  // Use sqlDate (java.sql.Date)
                insertStmt.setString(3, "Withdraw");
                insertStmt.setString(4, amount);
                insertStmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "RS " + amount + " Withdrawn Successfully");

                // Close current window and open the main class
                setVisible(false);
                new Main_Class(pin);

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");  // Passing empty string to simulate without pin
    }
}
