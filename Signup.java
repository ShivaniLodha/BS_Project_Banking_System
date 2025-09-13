
package bank.management.system;

// import calendar.JDateChooser;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;


public class Signup extends JFrame implements ActionListener {
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    JTextField textName, textfName, textemail, textaddress, textcity, textpin, textstate;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel lable1 = new JLabel("APPLICATION FORM NO:" + first);
        lable1.setBounds(160, 20, 600, 40);
        lable1.setFont(new Font("railway", Font.BOLD, 38));
        add(lable1);

        JLabel lable2 = new JLabel("Page 1");
        lable2.setBounds(330, 70, 600, 30);
        lable2.setFont(new Font("railway", Font.BOLD, 22));
        add(lable2);

        JLabel lable3 = new JLabel("Personal Details:");
        lable3.setFont(new Font("raleway", Font.BOLD, 22));
        lable3.setBounds(295, 90, 600, 30);
        add(lable3);

        JLabel lableName = new JLabel("Name:");
        lableName.setFont(new Font("raleway", Font.BOLD, 22));
        lableName.setBounds(100, 190, 100, 30);
        add(lableName);

        textName = new JTextField();
        textName.setFont(new Font("raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        JLabel lablefName = new JLabel("Father's Name:");
        lablefName.setFont(new Font("raleway", Font.BOLD, 22));
        lablefName.setBounds(100, 240, 200, 30);
        add(lablefName);

        textfName = new JTextField();
        textfName.setFont(new Font("raleway", Font.BOLD, 14));
        textfName.setBounds(300, 240, 400, 30);
        add(textfName);

        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("raleway", Font.BOLD, 22));
        DOB.setBounds(100, 290, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 290, 400, 30);
        add(dateChooser);

        JLabel lableG = new JLabel("Gender:");
        lableG.setFont(new Font("raleway", Font.BOLD, 22));
        lableG.setBounds(100, 340, 200, 30);
        add(lableG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("railway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 340, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(450, 340, 90, 30);
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("railway", Font.BOLD, 14));
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel lableemail = new JLabel("Email Address:");
        lableemail.setFont(new Font("railway", Font.BOLD, 22));
        lableemail.setBounds(100, 390, 200, 30);
        add(lableemail);

        textemail = new JTextField();
        textemail.setFont(new Font("railway", Font.BOLD, 14));
        textemail.setBounds(300, 390, 400, 30);
        add(textemail);

        JLabel lablems = new JLabel("Marital Status:");
        lablems.setFont(new Font("railway", Font.BOLD, 22));
        lablems.setBounds(100, 440, 200, 30);
        add(lablems);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("railway", Font.BOLD, 14));
        m1.setBackground(new Color(222, 255, 228));
        m1.setBounds(300, 440, 100, 30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("railway", Font.BOLD, 14));
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(450, 440, 100, 30);
        add(m2);

        m3 = new JRadioButton("Others");
        m3.setFont(new Font("railway", Font.BOLD, 14));
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(635, 440, 100, 30);
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel lableaddress = new JLabel("Address:");
        lableaddress.setFont(new Font("railway", Font.BOLD, 22));
        lableaddress.setBounds(100, 490, 200, 30);
        add(lableaddress);

        textaddress = new JTextField();
        textaddress.setFont(new Font("railway", Font.BOLD, 14));
        textaddress.setBounds(300, 490, 400, 30);
        add(textaddress);

        JLabel lablecity = new JLabel("City:");
        lablecity.setFont(new Font("railway", Font.BOLD, 22));
        lablecity.setBounds(100, 540, 200, 30);
        add(lablecity);

        textcity = new JTextField();
        textcity.setFont(new Font("railway", Font.BOLD, 14));
        textcity.setBounds(300, 540, 400, 30);
        add(textcity);

        JLabel lablepin = new JLabel("Pin Code:");
        lablepin.setFont(new Font("railway", Font.BOLD, 22));
        lablepin.setBounds(100, 590, 200, 30);
        add(lablepin);

        textpin = new JTextField();
        textpin.setFont(new Font("railway", Font.BOLD, 14));
        textpin.setBounds(300, 590, 400, 30);
        add(textpin);

        JLabel lablestate = new JLabel("State:");
        lablestate.setFont(new Font("railway", Font.BOLD, 22));
        lablestate.setBounds(100, 640, 200, 30);
        add(lablestate);

        textstate = new JTextField();
        textstate.setFont(new Font("railway", Font.BOLD, 14));
        textstate.setBounds(300, 640, 400, 30);
        add(textstate);

        next = new JButton("Next");
        next.setFont(new Font("railway", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(620, 680, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(800, 750);
        setLocation(360, 0);
        setUndecorated(true);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textfName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();


//        Date dob= dateChooser.getDate();

        // Format the date to match the MySQL date format (YYYY-MM-DD)
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dob = null;
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        String email = textemail.getText();
        String marital = null;
        if (m1.isSelected()) {
            marital = "married";
        } else if (m2.isSelected()) {
            marital = "unmarried";
        } else if (m3.isSelected()) {
            marital = "others";
        }
        String address = textaddress.getText();
        String city = textcity.getText();
        String pin = textpin.getText();
        String state = textstate.getText();

        try {
            // Validate that all fields are filled
            if (name.equals("") || fname.equals("") || dob.equals("") || gender == null || email.equals("") || marital == null || address.equals("") || city.equals("") || pin.equals("") || state.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                // Establishing a connection using the Conn class
                Conn conn1 = new Conn();
                String query = "INSERT INTO signupone (formno, name, father_name, dob, gender, email, maritalstatus, address, city, pincode, state) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Creating a PreparedStatement to prevent SQL injection
                PreparedStatement ps = conn1.connection.prepareStatement(query);
                ps.setString(1, formno);
                ps.setString(2, name);
                ps.setString(3, fname);
                ps.setString(4, dob);
                ps.setString(5, gender);
                ps.setString(6, email);
                ps.setString(7, marital);
                ps.setString(8, address);
                ps.setString(9, city);
                ps.setString(10, pin);
                ps.setString(11, state);

                // Execute the update
                ps.executeUpdate();

                // Close the PreparedStatement to avoid resource leak
                ps.close();

                // Navigate to the next screen (Signup2)
                new Signup2(formno);
                setVisible(false); // Hide current screen
            }
        } catch (Exception ex) {
            // Print error stack trace for debugging
            ex.printStackTrace();
            // Show user-friendly error message
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        new Signup();
    }
}
