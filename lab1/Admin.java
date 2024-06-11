
package project.lab1;


import java.io.Serializable;

public class Admin implements Serializable {
    private String id;

    public void setId(String id) {
        this.id = id;
        idGenerator();
    }

    public void idGenerator() {
        try {
            if (id.length() == 8) {
                int year = Integer.parseInt(id.substring(0, 2));
                char thirdDigit = id.charAt(2);
                String randomDigits = id.substring(3, 8);

                if ((year >= 0 && year <= 99) && (thirdDigit == '0' || thirdDigit == '1') && isNumeric(randomDigits)) {
                    System.out.println("User NSU ID format is correct.");
                } else {
                    System.out.println("User NSU ID format is incorrect.");
                }
            } else {
                System.out.println("User NSU ID must be 8 characters.");
            }
        } catch (NumberFormatException e) {
            System.out.println("User NSU ID must be numeric.");
        }
    }

    public void verification() {
        if (id.length() != 8) {
            System.out.println("This User NSU ID is not valid.");
        } else {
            String yearStr = id.substring(0, 2);
            try {
                int year = Integer.parseInt(yearStr);
                char thirdDigit = id.charAt(2);
                String randomDigits = id.substring(3, 8);

                if ((year >= 0 && year <= 99) && (thirdDigit == '0' || thirdDigit == '1') && isNumeric(randomDigits)) {
                    System.out.println("This User NSU ID is valid.");
                } else {
                    System.out.println("This User NSU ID is not valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("This User NSU ID is not valid.");
            }
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
