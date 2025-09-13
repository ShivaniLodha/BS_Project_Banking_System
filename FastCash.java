package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame  implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
FastCash(String pin){

    this.pin = pin;

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
    Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
    l3.setBounds(0, 0, 1400, 700);
    add(l3);

    JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
    label.setFont(new Font("system",Font.BOLD,22));
    label.setForeground(Color.WHITE);
    label.setBounds(390,180,400,25);
    l3.add(label);


    b1 = new JButton("Rs. 100");
    b1.setForeground(Color.WHITE);
    b1.setBackground(new Color(65,125,128));
    b1.setBounds(370,230,150,25);
    b1.addActionListener(this);
    l3.add(b1);

    b2 = new JButton("Rs. 200");
    b2.setForeground(Color.WHITE);
    b2.setBackground(new Color(65,125,128));
    b2.setBounds(615,230,150,25);
    b2.addActionListener(this);
    l3.add(b2);

    b3 = new JButton("Rs. 500");
    b3.setForeground(Color.WHITE);
    b3.setBackground(new Color(65,125,128));
    b3.setBounds(370,270,150,25);
    b3.addActionListener(this);
    l3.add(b3);

    b4 = new JButton("Rs. 1000");
    b4.setForeground(Color.WHITE);
    b4.setBackground(new Color(65,125,128));
    b4.setBounds(615,270,150,25);
    b4.addActionListener(this);
    l3.add(b4);

    b5 = new JButton("Rs. 2000");
    b5.setForeground(Color.WHITE);
    b5.setBackground(new Color(65,125,128));
    b5.setBounds(370,310,150,25);
    b5.addActionListener(this);
    l3.add(b5);

    b6 = new JButton("Rs. 10000");
    b6.setForeground(Color.WHITE);
    b6.setBackground(new Color(65,125,128));
    b6.setBounds(615,310,150,25);
    b6.addActionListener(this);
    l3.add(b6);

    b7= new JButton("BACK");
    b7.setForeground(Color.WHITE);
    b7.setBackground(new Color(65,125,128));
    b7.setBounds(615,350,150,25);
    b7.addActionListener(this);
    l3.add(b7);





    setLayout(null);
    setSize(1500,1080);
    setVisible(true);
    setLocation(0,0);



}

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==b7){
        setVisible(false);
        new Main_Class(pin);
    }else{
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String amount =((JButton)e.getSource()).getText().substring(4);
        Conn c1 = new Conn();
//        Date date = new Date();

        try{
            ResultSet resultSet = c1.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;

            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){

                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
//            String num ="17";

            if(e.getSource() != b7 && balance <Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }

            c1.statement.executeUpdate("insert into bank values('"+pin+"','"+sqlDate+"','withdrawl','"+amount+"')");
            JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited sucessfully");
        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"error:"+E.getMessage());
        }
        setVisible(false);
        new Main_Class(pin);

    }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
