
package project.lab1;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewItems extends JFrame {
    private JTable itemTable;
    private JButton addToCartButton, cancelButton;

    public ViewItems() {
        setTitle("View Items");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Item Name", "Price", "Stock"};
        Object[][] data = getItemData();

        itemTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        add(scrollPane, BorderLayout.CENTER);

        addToCartButton = new JButton("Add to cart");
        cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(addToCartButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addToCartButton.addActionListener(e -> {
            // Add item to cart
            new Payment().makePayment();
        });

        cancelButton.addActionListener(e -> {
            new MainMenu().setVisible(true);
            this.dispose();
        });
    }

    private Object[][] getItemData() {
        CreateFile cf = new CreateFile();
        List<Item> items = cf.readItemsFromFile();

        Object[][] data = new Object[items.size()][3];
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            data[i][0] = item.getName();
            data[i][1] = item.getPrice();
            data[i][2] = item.getStock();
        }

        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ViewItems().setVisible(true);
        });
    }
}
