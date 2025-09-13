package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.MalformedInputException;

public class Main_Class extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Main_Class(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 700);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setFont(new Font("system",Font.BOLD,25));
        label.setForeground(Color.WHITE);
        label.setBounds(390,180,400,30);
        l3.add(label);


        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(370,230,150,25);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(615,230,150,25);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(370,270,150,25);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(615,270,150,25);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(370,310,150,25);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE INQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(615,310,150,25);
        b6.addActionListener(this);
        l3.add(b6);

        b7= new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(615,350,150,25);
        b7.addActionListener(this);
        l3.add(b7);





        setLayout(null);
        setUndecorated(true);
        setSize(1500,1080);
        setVisible(true);
        setLocation(0,0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0);

        } else if (e.getSource()==b2) {
            new Withdrawl(pin);
            setVisible(false);
        } else if (e.getSource()==b6) {
            new BalanceEnquiry(pin);
            setVisible(false);

        } else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
            
        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);

        }
        else if(e.getSource()==b4){
            new Mini(pin);
//            setVisible(false);
        }
//        if (e.getSource() == b1) {
//            // Example: Show a dialog when the "DEPOSIT" button is clicked
//            JOptionPane.showMessageDialog(this, "Deposit functionality not yet implemented.");
//        } else if (e.getSource() == b2) {
//            // Implement functionality for Cash Withdrawal here
//            JOptionPane.showMessageDialog(this, "Cash Withdrawal functionality not yet implemented.");
//        } else if (e.getSource() == b3) {
//            // Implement functionality for Fast Cash here
//            JOptionPane.showMessageDialog(this, "Fast Cash functionality not yet implemented.");
//        } else if (e.getSource() == b4) {
//            // Implement functionality for Mini Statement here
//            JOptionPane.showMessageDialog(this, "Mini Statement functionality not yet implemented.");
//        } else if (e.getSource() == b5) {
//            // Implement functionality for PIN Change here
//            JOptionPane.showMessageDialog(this, "PIN Change functionality not yet implemented.");
//        } else if (e.getSource() == b6) {
//            // Implement functionality for Balance Inquiry here
//            JOptionPane.showMessageDialog(this, "Balance Inquiry functionality not yet implemented.");
//        } else if (e.getSource() == b7) {
//            // Exit the application when "EXIT" button is clicked
//            System.exit(0);
//        }

    }

    public static void main(String[] args) {
        new Main_Class("");
    }

}