package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry  extends JFrame implements ActionListener {
    JLabel lable2;
    JButton b1;
    String pin;

    BalanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 690, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 690);
        add(l3);

        JLabel lable1 = new JLabel("Your Current Balance is Rs");
        lable1.setForeground(Color.WHITE);
        lable1.setFont(new Font("raleway", Font.BOLD, 14));
        lable1.setBounds(400, 180, 500, 35);
        l3.add(lable1);

        lable2 = new JLabel();
        lable2.setForeground(Color.WHITE);
        lable2.setFont(new Font("raleway", Font.BOLD, 14));
        lable2.setBounds(400, 220, 400, 35);
        l3.add(lable2);

        b1 = new JButton("BACK");
        b1.setFont(new Font("raleway", Font.BOLD, 12));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(620, 340, 150, 30);
        b1.addActionListener(this);  // Add action listener for deposit
        l3.add(b1);


        int balance = 0;
        try{

            Conn c1 = new Conn();

            ResultSet resultSet = c1.statement.executeQuery("select * from  bank where pin = '"+pin+"'");
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance +=Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"error:"+e.getMessage());
        }


        lable2.setText(""+balance);


        setLayout(null);
        setSize(1550, 1080);
        setUndecorated(true);
        setLocation(0, 0);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new  Main_Class(pin);
        setVisible(false);

    }

    public static void main(String[] args) {

        new BalanceEnquiry("");




    }
}

