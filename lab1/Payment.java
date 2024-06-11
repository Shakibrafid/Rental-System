
package project.lab1;


import java.util.Scanner;

public class Payment {
    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Payment Method:");
        System.out.println("1. Bkash\n2. Cash on Delivery");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Payment successful through Bkash.");
        } else if (choice == 2) {
            System.out.println("Payment successful on delivery.");
        } else {
            System.out.println("Invalid payment method.");
        }
    }
}
