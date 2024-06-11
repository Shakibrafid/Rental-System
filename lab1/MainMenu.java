
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    private JButton adminButton, ownerButton, customerButton, signupButton;

    public MainMenu() {
        setTitle("Rental System Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        adminButton = new JButton("Admin Login");
        ownerButton = new JButton("Owner");
        customerButton = new JButton("Customer");
        signupButton = new JButton("Sign Up");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));  
        panel.add(adminButton);
        panel.add(ownerButton);
        panel.add(customerButton);
        panel.add(signupButton);  

        add(panel, BorderLayout.CENTER);

        adminButton.addActionListener(this);
        ownerButton.addActionListener(this);
        customerButton.addActionListener(this);
        signupButton.addActionListener(this);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            new LogIn().setVisible(true);
            this.dispose();
        } else if (e.getSource() == ownerButton) {
            new GiveMenu().setVisible(true);
            this.dispose();
        } else if (e.getSource() == customerButton) {
            new CustomerMenu().setVisible(true);  
            this.dispose();
        } else if (e.getSource() == signupButton) {  
            new SignUp().setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
}
