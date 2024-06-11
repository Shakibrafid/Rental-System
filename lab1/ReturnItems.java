
package project.lab1;


import javax.swing.*;
import java.awt.*;

public class ReturnItems extends JFrame {
    private JButton returnButton, backButton;
    private JTextArea returnItemDisplayArea;
    private Owner owner;

    public ReturnItems() {
        setTitle("Return Items");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        owner = new Owner();

        returnButton = new JButton("Return Item");
        backButton = new JButton("Back");
        returnItemDisplayArea = new JTextArea();
        returnItemDisplayArea.setEditable(false);

        returnItemDisplayArea.setText(getRentedItemDetails());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JScrollPane(returnItemDisplayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(returnButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        returnButton.addActionListener(e -> {
            owner.GetMoneyBack();
            owner.ItemReturn();
            JOptionPane.showMessageDialog(this, "Item returned successfully.");
        });

        backButton.addActionListener(e -> {
            new MainMenu().setVisible(true);
            this.dispose();
        });
    }

    private String getRentedItemDetails() {
        
        return "Item 1: Laptop, Rented Date: 2024-06-01\n" +
               "Item 2: Phone, Rented Date: 2024-06-02\n";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReturnItems().setVisible(true);
        });
    }
}
