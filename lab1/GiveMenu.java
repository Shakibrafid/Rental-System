
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiveMenu extends JFrame implements ActionListener {
    private JButton addItemButton, viewDetailsButton, exitButton;

    public GiveMenu() {
        setTitle("Owner Menu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addItemButton = new JButton("Add Your Item");
        viewDetailsButton = new JButton("View Your Item details");
        exitButton = new JButton("Exit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(addItemButton);
        panel.add(viewDetailsButton);
        panel.add(exitButton);

        add(panel, BorderLayout.CENTER);

        addItemButton.addActionListener(this);
        viewDetailsButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            new AddItemFrame().setVisible(true);
            this.dispose();
        } else if (e.getSource() == viewDetailsButton) {
            new ViewItems().setVisible(true);
            this.dispose();
        } else if (e.getSource() == exitButton) {
            new MainMenu().setVisible(true);
            this.dispose();
        }
    }
}

