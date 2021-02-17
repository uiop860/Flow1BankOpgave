import java.sql.SQLOutput;
import java.util.Scanner;

public class UI {

    private static Customer customer;
    private static Account account;

    ;


    public String takeStringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    int id = 0;

    public void Setup() {
        System.out.println("Velkommen til banken");
        System.out.println("Indtast venligst dit kunde ID");
        try {
            id = Integer.parseInt(takeStringInput());
            System.out.println("Mange tak, vælg venligst et af følgende funktioner");
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public void run() {
        System.out.println("1 - Hæve penge \n 2 - Indsæt penge\n 3 - Kontoudtog\n 4 - Overfør penge");
        String input = takeStringInput();
        switch (input) {

            case "1":
                int currentBalance = Dao.checkBalance(id);
                System.out.println("Du har:" + currentBalance);
                try {
                    System.out.println("Hvor mange penge vil du hæve?");
                    int withdrawAmount = Integer.parseInt(takeStringInput());
                    Dao.makeTransaction(withdrawAmount, id);
                    int currentBalanceAfterWithdraw = Dao.checkBalance(id);
                    System.out.println("Du har:" + currentBalanceAfterWithdraw);
                    run();
                } catch (NullPointerException e) {

                    System.out.println(e);
                }
                break;
            case "2":



                System.out.println("Indtast venligst dit konto nummer:");

                break;
            case "3":
                System.out.println("Indtast venligst dit konto nummer:");

                break;
            case "4":
                System.out.println("Vælg beløb til");
            default:
                System.out.println("Forkert input, prøv igen");


        }

    }
}
