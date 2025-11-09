package LAB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EXERCISE_10 extends JFrame implements ActionListener {
    // GUI Components
    private JLabel userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, clearButton;

    public EXERCISE_10() {
        // Frame setup
        setTitle("Login Form");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 20, 15)); // rows, cols, hgap, vgap

        // Components
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");

        userField = new JTextField();
        passField = new JPasswordField();

        loginButton = new JButton("Login");
        clearButton = new JButton("Clear");

        // Add components to frame
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
        add(clearButton);

        // Add action listeners
        loginButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    // Handle button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("Karunya") && password.equals("Karunya")) {
                JOptionPane.showMessageDialog(this, "Login Successful ");
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed ");
            }
        } else if (e.getSource() == clearButton) {
            userField.setText("");
            passField.setText("");
        }
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        new EXERCISE_10();
    }
}
