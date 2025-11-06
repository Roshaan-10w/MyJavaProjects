//1)

package LAB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    // Components for Frame 1 (Registration Form)
    JTextField nameField, ageField;
    JRadioButton male, female;
    JCheckBox java, python, ai;
    JComboBox<String> deptBox;
    JButton submitButton;

    public StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));
        setLocationRelativeTo(null);

        // Components
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel courseLabel = new JLabel("Courses:");
        JLabel deptLabel = new JLabel("Department:");

        nameField = new JTextField();
        ageField = new JTextField();

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        ai = new JCheckBox("AI");

        String[] departments = {"CSE", "ECE", "EEE", "MECH", "CIVIL"};
        deptBox = new JComboBox<>(departments);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add components
        add(nameLabel); add(nameField);
        add(ageLabel); add(ageField);
        add(genderLabel);
        JPanel genderPanel = new JPanel();
        genderPanel.add(male); genderPanel.add(female);
        add(genderPanel);

        add(courseLabel);
        JPanel coursePanel = new JPanel();
        coursePanel.add(java); coursePanel.add(python); coursePanel.add(ai);
        add(coursePanel);

        add(deptLabel); add(deptBox);
        add(new JLabel("")); add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Gather data
            String name = nameField.getText();
            String age = ageField.getText();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not Selected");

            StringBuilder courses = new StringBuilder();
            if (java.isSelected()) courses.append("Java ");
            if (python.isSelected()) courses.append("Python ");
            if (ai.isSelected()) courses.append("AI ");

            String department = (String) deptBox.getSelectedItem();

            // Open second frame to show details
            new DisplayFrame(name, age, gender, courses.toString(), department);
        }
    }

    // Second JFrame class to display student details
    class DisplayFrame extends JFrame {
        public DisplayFrame(String name, String age, String gender, String courses, String dept) {
            setTitle("Student Details");
            setSize(350, 250);
            setLayout(new GridLayout(6, 1, 10, 10));
            setLocationRelativeTo(null);

            add(new JLabel("Name: " + name));
            add(new JLabel("Age: " + age));
            add(new JLabel("Gender: " + gender));
            add(new JLabel("Courses: " + courses));
            add(new JLabel("Department: " + dept));
            add(new JLabel("✅ Registration Completed Successfully!"));

            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}



//2)


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
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10)); // rows, cols, hgap, vgap

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
                JOptionPane.showMessageDialog(this, "Login Successful ✅");
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed ❌");
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
