package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;

Pin(String pin){

    this.pin = pin;

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
    Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
    l3.setBounds(0, 0, 1400, 700);
    add(l3);
    JLabel label = new JLabel("ENTER CHANGE PIN");
    label.setFont(new Font("system", Font.BOLD, 16));
    label.setForeground(Color.WHITE);
    label.setBounds(400, 200, 400, 30);
    l3.add(label);


    JLabel label2 = new JLabel("NEW PIN");
    label2.setFont(new Font("system", Font.BOLD, 16));
    label2.setForeground(Color.WHITE);
    label2.setBounds(400, 230, 400, 30);
    l3.add(label2);

    p1 = new JPasswordField();
   p1.setFont(new Font("raleway", Font.BOLD, 22));
   p1.setBackground(new Color(65, 128, 125));
   p1.setForeground(Color.WHITE);
   p1.setBounds(570, 230, 200, 25);
    l3.add(p1);

    JLabel label3 = new JLabel("RE-Enter New PIN");
    label3.setFont(new Font("system", Font.BOLD, 16));
    label3.setForeground(Color.WHITE);
    label3.setBounds(400, 260, 400, 30);
    l3.add(label3);

    p2= new JPasswordField();
    p2.setFont(new Font("raleway", Font.BOLD, 22));
    p2.setBackground(new Color(65, 128, 125));
    p2.setForeground(Color.WHITE);
    p2.setBounds(570, 260, 200, 25);
    l3.add(p2);




    b1 = new JButton("CHANGE");
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



    setLayout(null);
    setSize(1500, 1080);
    setVisible(true);
    setLocation(0, 0);
}


    @Override
    public void actionPerformed(ActionEvent e) {
try{

    String pin1 = p1.getText();
    String pin2 = p2.getText();

    if(!pin1.equals(pin2)){
        JOptionPane.showMessageDialog(null,"Entered PIN does not match ");
        return;
    }
    if(e.getSource()==b1){
        if(p1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Entered New  PIN ");
            return;
        }
        if(p2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
            return;
        }
        Conn c = new Conn();

        String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
        String q2 = "update login1 set pin = '"+pin1+"' where pin = '"+pin+"'";
        String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

        c.statement.executeUpdate(q1);
        c.statement.executeUpdate(q2);
        c.statement.executeUpdate(q3);

        JOptionPane.showMessageDialog(null," PIN Change Sucessfully");
        setVisible(false);
        new Main_Class(pin);
    } else if (e.getSource()==b2) {
        new Main_Class(pin);
        setVisible(false);

    }

}catch (Exception e1){
    e1.printStackTrace();
    JOptionPane.showMessageDialog(null,"error:"+e1.getMessage());
}
    }

    public static void main(String[] args) {
    new Pin("");

    }
}
