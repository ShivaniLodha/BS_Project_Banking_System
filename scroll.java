package bank.management.system;


import javax.swing.*;
import java.awt.*;

public class scroll extends JFrame {
    public scroll() {
        // Set JFrame title, size, and layout
        setTitle("Scrollbar Example");
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Create a JTextArea that is larger than the visible area
        JTextArea textArea = new JTextArea(20, 30);  // 20 rows and 30 columns
        textArea.setText("This is a long text that will overflow and show the scrollbars. "
                + "Keep adding more text to make sure scrollbars appear...\n"
                + "You can add more lines and observe how the scrollbars behave.\n");

        // Add JTextArea inside JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Add JScrollPane to JFrame
        add(scrollPane, BorderLayout.CENTER);

        // Set JFrame visibility and close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new scroll();
    }
}
