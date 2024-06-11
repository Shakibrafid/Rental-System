
package project.lab1;



import java.util.Scanner;

public class Info {
    private CreateFile cf = new CreateFile();
    private Admin admin = new Admin();
    private String name;
    private String AId;
    private String pass;
    private int age;
    private String phoneNumber;
    private String gmail;
    private String city;

    public void getInfo(String name, String AId, String pass, int age, String PhoneNumber, String gmail, String city) {
        setName(name);
        setAId(AId);
        setPass(pass);
        setAge(age);
        setPhoneNumber(PhoneNumber);
        setGmail(gmail);
        setCity(city);
        String info = "Name: " + name + "\nID: " + AId + "\nAge: " + age + "\nPhone Number: " + PhoneNumber + "\nGmail: " + gmail + "\nCity: " + city;
        cf.writeInFileInfo(info);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAId(String AId) {
        this.AId = AId;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAId() {
        return AId;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGmail() {
        return gmail;
    }

    public String getCity() {
        return city;
    }
}
