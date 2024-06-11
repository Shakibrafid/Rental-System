
package project.lab1;


import java.util.Scanner;

public class Return {
    private Scanner scanner = new Scanner(System.in);

    public void returnItem() {
        System.out.println("Return Your Item");
        Owner owner = new Owner();
        owner.GetMoneyBack();
        owner.ItemReturn();
    }
}
