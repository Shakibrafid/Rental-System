

package project.lab1;


import java.util.Scanner;

public class Customer {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Items");
            System.out.println("2. Return Item");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewItems();
                    break;
                case 2:
                    returnItem();
                    break;
                case 3:
                    System.out.println("Exiting Customer Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewItems() {
        Item item = new Item();
        item.viewItem();
        System.out.println("1. Add to cart\n0. No");
        int cm = scanner.nextInt();
        scanner.nextLine();
        if (cm == 1) {
            item.makeOrder();
            System.out.println("1. Confirm your order and make payment.\n2. Cancel order");
            int m = scanner.nextInt();
            scanner.nextLine();
            if (m == 1) {
                System.out.println("Thank you for your order. Pay in:");
                item.makePayment();
            } else if (m == 2) {
                System.out.println("Order canceled.");
            } else {
                System.out.println("Wrong input");
            }
        } else if (cm == 0) {
            System.out.println("OK. Thank you");
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void returnItem() {
        System.out.println("Return Your Item");
        Owner owner = new Owner();
        owner.GetMoneyBack();
        owner.ItemReturn();
    }
}
