
 
package project.lab1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateFile implements Serializable {
    private File fileObj;
    private File fileObjinfo;

    public CreateFile() {
        fileObj = new File("Item.txt");
        fileObjinfo = new File("UserInfo.txt");
    }

    public void writeInFile(String s) {
        try (FileWriter writer = new FileWriter(fileObj, true)) {
            writer.write(s + "\r\n");
            System.out.println("Details: \n" + fileObj.getName());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (Scanner myReader = new Scanner(fileObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeInFileInfo(String s) {
        try (FileWriter writer = new FileWriter(fileObjinfo, true)) {
            writer.write(s + "\r\n");
            System.out.println("Details: \n" + fileObjinfo.getName());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFileInfo() {
        try (Scanner myReader = new Scanner(fileObjinfo)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeInFile(Item item) {
        try (FileWriter writer = new FileWriter(fileObj, true)) {
            writer.write(item.getName() + "," + item.getPrice() + "," + item.getStock() + "\r\n");
            System.out.println("Item written to file: " + fileObj.getName());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<Item> readItemsFromFile() {
        List<Item> items = new ArrayList<>();
        try (Scanner myReader = new Scanner(fileObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] itemData = data.split(",");
                if (itemData.length == 3) {
                    String name = itemData[0];
                    double price = Double.parseDouble(itemData[1]);
                    int stock = Integer.parseInt(itemData[2]);
                    items.add(new Item(name, price, stock));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return items;
    }

    public void displayItems() {
        List<Item> items = readItemsFromFile();
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
