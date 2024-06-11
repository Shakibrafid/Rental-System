
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemViewFrame extends JFrame implements ActionListener {
    private JButton addToCartButton, cancelButton;
    private JTextArea itemDisplayArea;
    private Item item;

    public ItemViewFrame() {
        setTitle("View Items");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        item = new Item();

        addToCartButton = new JButton("Add to cart");
        cancelButton = new JButton("Cancel");
        itemDisplayArea = new JTextArea();
        itemDisplayArea.setEditable(false);

        item.viewItem();  
        itemDisplayArea.setText(getItemDetails());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        panel.add(new JScrollPane(itemDisplayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(addToCartButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        addToCartButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            item.makeOrder();
            new Payment().makePayment();
        } else if (e.getSource() == cancelButton) {
            new MainMenu().setVisible(true);
            this.dispose();
        }
    }

    private String getItemDetails() {
        
        return "Item 1: Laptop, Price: 1000, Quantity: 5\n" +
               "Item 2: Phone, Price: 500, Quantity: 10\n";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ItemViewFrame().setVisible(true);
        });
    }
}
