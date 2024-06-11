
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemFrame extends JFrame implements ActionListener {
    private JTextField nameField, priceField, stockField;
    private JButton addButton, cancelButton;

    public AddItemFrame() {
        setTitle("Add Item");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create labels and text fields for item details
        JLabel nameLabel = new JLabel("Item Name:");
        nameField = new JTextField(20);
        
        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField(20);

        JLabel stockLabel = new JLabel("Stock:");
        stockField = new JTextField(20);

        // Create buttons
        addButton = new JButton("Add Item");
        cancelButton = new JButton("Cancel");

        // Add action listeners to buttons
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Layout the components in a grid
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(stockLabel);
        panel.add(stockField);
        panel.add(addButton);
        panel.add(cancelButton);

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String priceText = priceField.getText();
            String stockText = stockField.getText();

            if (name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);

                // Here you can add the item to your database or file system
                CreateFile cf = new CreateFile();
                cf.writeInFile(name + " " + price + " " + stock);

                JOptionPane.showMessageDialog(this, "Item added successfully.");
                nameField.setText("");
                priceField.setText("");
                stockField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Price and Stock must be numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == cancelButton) {
            // Close the frame
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddItemFrame().setVisible(true));
    }
}
