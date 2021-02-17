import java.util.Scanner;

public class Customer extends Database {

    private String name;
    private int age;
    private String Address;
    private int customerID;

    public Customer(String name, int age, String address) {
        this.name = name;
        this.age = age;
        Address = address;

    }

    public String takeInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }
}
