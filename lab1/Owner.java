
package project.lab1;


import java.io.Serializable;
import java.util.Scanner;

public class Owner implements Serializable {
    private Scanner scanner = new Scanner(System.in);
    private Item item = new Item();

    public void AddItem() {
        item.addItem();
    }

    public void GetMoneyBack() {
        System.out.println("Money back process initiated.");
    }

    public void ItemReturn() {
        System.out.println("Item return process initiated.");
    }
}
