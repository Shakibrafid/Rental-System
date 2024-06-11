
package project.lab1;


import java.io.Serializable;
import java.util.Scanner;

public class Item implements Serializable {
    private String name;
    private double price;
    private int stock;

    
    private transient Scanner scanner = new Scanner(System.in);

    public Item() {
        
    }

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void viewItem() {
        CreateFile cf = new CreateFile();
        cf.readFromFile();
    }

    public void makeOrder() {
        System.out.println("Enter your order: ");
        String order = scanner.nextLine();
        CreateFile cf = new CreateFile();
        cf.writeInFile(order);
    }

    public void makePayment() {
        System.out.println("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Payment of " + amount + " received. Thank you!");
    }

    public void addItem() {
        System.out.println("Enter item name: ");
        String name = scanner.nextLine();

        System.out.println("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter item stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();  

        Item item = new Item(name, price, stock);
        CreateFile cf = new CreateFile();
        cf.writeInFile(item);

        System.out.println("Item added successfully.");
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.addItem();
        item.viewItem();
    }
}
