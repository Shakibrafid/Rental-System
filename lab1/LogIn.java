
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame implements ActionListener {
    private JTextField nsuIdField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LogIn() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("NSU ID:"));
        nsuIdField = new JTextField();
        panel.add(nsuIdField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton);

        statusLabel = new JLabel("");
        panel.add(statusLabel);

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nsuId = nsuIdField.getText();
        String password = new String(passwordField.getPassword());

        if (DatabaseHelper.verifyUser(nsuId, password)) {
            
            JOptionPane.showMessageDialog(this, "Login successful.");
            
            new GiveMenu().setVisible(true);
            this.dispose();
        } else {
            statusLabel.setText("Invalid NSU ID or password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogIn().setVisible(true);
        });
    }
}

