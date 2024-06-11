
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame implements ActionListener {
    private JButton viewItemsButton, returnItemsButton, backButton;

    public CustomerMenu() {
        setTitle("Customer Menu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        viewItemsButton = new JButton("View Items");
        returnItemsButton = new JButton("Return Items");
        backButton = new JButton("Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(viewItemsButton);
        panel.add(returnItemsButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        viewItemsButton.addActionListener(this);
        returnItemsButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewItemsButton) {
            new ItemViewFrame().setVisible(true);
            this.dispose();
        } else if (e.getSource() == returnItemsButton) {
            new ReturnItems().setVisible(true);
            this.dispose();
        } else if (e.getSource() == backButton) {
            new MainMenu().setVisible(true);
            this.dispose();
        }
    }
}
