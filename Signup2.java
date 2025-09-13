package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Signup2 extends JFrame implements ActionListener {
    String formno;
    JComboBox combobox, combobox2, combobox3, combobox4, combobox5;
    JTextField textpanno, textadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;

    Signup2(String formno) {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("railway", Font.BOLD, 22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setBounds(300, 60, 600, 40);
        l2.setFont(new Font("railway", Font.BOLD, 22));
        add(l2);

        JLabel l3 = new JLabel("Religion");
        l3.setBounds(100, 120, 100, 30);
        l3.setFont(new Font("railway", Font.BOLD, 18));
        add(l3);

        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        combobox = new JComboBox(religion);
        combobox.setFont(new Font("railway", Font.BOLD, 14));
        combobox.setBackground(new Color(252, 208, 76));
        combobox.setBounds(350, 120, 320, 30);
        add(combobox);

        JLabel l4 = new JLabel("Category:");
        l4.setFont(new Font("railway", Font.BOLD, 18));
        l4.setBounds(100, 170, 100, 30);
        add(l4);

        String category[] = {"General", "OBC", "SC", "ST", "Others"};
        combobox2 = new JComboBox(category);
        combobox2.setFont(new Font("railway", Font.BOLD, 14));
        combobox2.setBackground(new Color(252, 208, 76));
        combobox2.setBounds(350, 170, 320, 30);
        add(combobox2);

        JLabel l5 = new JLabel("Income:");
        l5.setFont(new Font("railway", Font.BOLD, 18));
        l5.setBounds(100, 220, 100, 30);
        add(l5);

        String income[] = {"< 1,50,000", "< 2,00,000", "5,50,000", "up to 10,00,000", "Above 10,00,000"};
        combobox3 = new JComboBox(income);
        combobox3.setFont(new Font("railway", Font.BOLD, 14));
        combobox3.setBackground(new Color(252, 208, 76));
        combobox3.setBounds(350, 220, 320, 30);
        add(combobox3);

        JLabel l6 = new JLabel("Education:");
        l6.setFont(new Font("railway", Font.BOLD, 18));
        l6.setBounds(100, 270, 150, 30);
        add(l6);

        String education[] = {"Graduate", "Non-Graduate", "Doctorate", "Other"};
        combobox4 = new JComboBox(education);
        combobox4.setFont(new Font("railway", Font.BOLD, 14));
        combobox4.setBackground(new Color(252, 208, 76));
        combobox4.setBounds(350, 270, 320, 30);
        add(combobox4);

        JLabel l7 = new JLabel("Occupation:");
        l7.setFont(new Font("railway", Font.BOLD, 18));
        l7.setBounds(100, 320, 150, 30);
        add(l7);

        String occupation[] = {"Salaried", "Teacher", "Doctor", "Employee", "Business", "Other"};
        combobox5 = new JComboBox(occupation);
        combobox5.setFont(new Font("railway", Font.BOLD, 14));
        combobox5.setBackground(new Color(252, 208, 76));
        combobox5.setBounds(350, 320, 320, 30);
        add(combobox5);

        JLabel l8 = new JLabel("Pan Number:");
        l8.setFont(new Font("railway", Font.BOLD, 18));
        l8.setBounds(100, 370, 150, 30);
        add(l8);

        textpanno = new JTextField();
        textpanno.setFont(new Font("railway", Font.BOLD, 14));
        textpanno.setBounds(350, 370, 320, 30);
        textpanno.setBackground(new Color(252, 208, 76));
        add(textpanno);

        JLabel l9 = new JLabel("Aadhar Number:");
        l9.setFont(new Font("railway", Font.BOLD, 18));
        l9.setBounds(100, 420, 150, 30);
        add(l9);

        textadhar = new JTextField();
        textadhar.setFont(new Font("railway", Font.BOLD, 14));
        textadhar.setBounds(350, 420, 320, 30);
        textadhar.setBackground(new Color(252, 208, 76));
        add(textadhar);

        JLabel l10 = new JLabel("Senior Citizen:");
        l10.setFont(new Font("railway", Font.BOLD, 18));
        l10.setBounds(100, 470, 180, 30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("railway", Font.BOLD, 18));
        r1.setBounds(350, 470, 100, 30);
        r1.setBackground(new Color(252, 208, 76));
        add(r1);


        r2 = new JRadioButton("No");
        r2.setFont(new Font("railway", Font.BOLD, 18));
        r2.setBounds(460, 470, 100, 30);
        r2.setBackground(new Color(252, 208, 76));
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);


        JLabel l11 = new JLabel("Existing Account:");
        l11.setFont(new Font("railway", Font.BOLD, 18));
        l11.setBounds(100, 520, 180, 30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("railway", Font.BOLD, 18));
        e1.setBounds(350, 520, 100, 30);
        e1.setBackground(new Color(252, 208, 76));
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("railway", Font.BOLD, 18));
        e2.setBounds(460, 520, 100, 30);
        e2.setBackground(new Color(252, 208, 76));
        add(e2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(e1);
        buttonGroup1.add(e2);

        JLabel l12 = new JLabel("Form no:");
        l12.setBounds(680, 10, 100, 30);
        l12.setFont(new Font("railway", Font.BOLD, 18));
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setBounds(760, 10, 60, 30);
        l13.setFont(new Font("railway", Font.BOLD, 18));
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("railway", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(500, 610, 100, 30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setUndecorated(true);
        setSize(850, 750);
        setLocation(480, 80);
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) combobox.getSelectedItem();
        String cate = (String) combobox2.getSelectedItem();
        String inc = (String) combobox3.getSelectedItem();
        String edu = (String) combobox4.getSelectedItem();
        String occu = (String) combobox5.getSelectedItem();

        String pan = textpanno.getText();
        String adhar = textadhar.getText();

//        String scitizen = r1.isSelected() ? "Yes" : "No";
//        String eAccount = e1.isSelected() ? "Yes" : "No";
        String scitizen = " ";
        if(r1.isSelected()){
            scitizen = "Yes";
        }
        else if(r2.isSelected()){
            scitizen = " No";
        }
        String eAccount = " ";
        if(r1.isSelected()){
            eAccount = "Yes";
        }
        else if(r2.isSelected()) {
            eAccount = " No";
        }

        try {
            if (pan.isEmpty() || adhar.isEmpty() || scitizen.isEmpty() || eAccount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
            } else {
                Conn c1 = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, cateory, income,  educate, occu, panno, adhar, seniorcitizen, existing_account) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = c1.connection.prepareStatement(query);
                ps.setString(1, formno);
                ps.setString(2, rel);
                ps.setString(3, cate);
                ps.setString(4, inc);
                ps.setString(5, edu);
                ps.setString(6, occu);
                ps.setString(7, pan);
                ps.setString(8, adhar);
                ps.setString(9, scitizen);
                ps.setString(10, eAccount);

                ps.executeUpdate();
                ps.close();

                new Signup3(formno); // Proceed to next page
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error:  " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        new Signup2("");  // Pass a sample form number for testing
    }
}
