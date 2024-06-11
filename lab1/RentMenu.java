
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentMenu extends JFrame implements ActionListener {
    private JButton viewButton, returnButton, backButton;

    public RentMenu() {
        setTitle("Rental Menu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        viewButton = new JButton("View Items");
        returnButton = new JButton("Return Items");
        backButton = new JButton("Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(viewButton);
        panel.add(returnButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        viewButton.addActionListener(this);
        returnButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            new ViewItems().setVisible(true);
            this.dispose();
        } else if (e.getSource() == returnButton) {
            new ReturnItems().setVisible(true);
            this.dispose();
        } else if (e.getSource() == backButton) {
            new MainMenu().setVisible(true);
            this.dispose();
        }
    }
}
