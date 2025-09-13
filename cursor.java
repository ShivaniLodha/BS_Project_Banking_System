package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cursor extends JFrame  {
    JButton button;

    public cursor() {
        setTitle("Cursor Example");
        setSize(700, 600);
        setLocation(360, 40);
        setUndecorated(true);
        setLayout(null);

        // Create a button to demonstrate cursor change
        button = new JButton("Click Me");
        button.setBounds(250, 250, 200, 50);
        add(button);

        // Set default cursor for the JFrame (in this case, the default arrow cursor)
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        // Set hand cursor when the mouse enters the button
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Set wait cursor when the button is clicked
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));  // Change to wait cursor
                    try {
                        Thread.sleep(2000); // Simulate a process that takes 2 seconds
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));  // Revert to default cursor
                }

        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new cursor();
    }
}
