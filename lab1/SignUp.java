
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    private JTextField nameField, idField, ageField, phoneField, emailField, cityField;
    private JPasswordField passField;
    private JButton signupButton, backButton;

    public SignUp() {
        setTitle("Signup");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nameField = new JTextField(20);
        idField = new JTextField(20);
        passField = new JPasswordField(20);
        ageField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        cityField = new JTextField(20);
        signupButton = new JButton("Signup");
        backButton = new JButton("Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("NSU ID:"));
        panel.add(idField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("City:"));
        panel.add(cityField);
        panel.add(signupButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        signupButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            
            String name = nameField.getText();
            String id = idField.getText();
            String pass = new String(passField.getPassword());
            int age = Integer.parseInt(ageField.getText());
            String phone = phoneField.getText();
            String email = emailField.getText();
            String city = cityField.getText();

           
            DatabaseHelper.addUserCredentials(id, pass);

            
            JOptionPane.showMessageDialog(this, "Signup successful. Please login now.");
            new LogIn().setVisible(true);
            this.dispose();
        } else if (e.getSource() == backButton) {
            new MainMenu().setVisible(true);
            this.dispose();
        }
    }
}
