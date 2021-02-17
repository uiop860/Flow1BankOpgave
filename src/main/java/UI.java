import java.sql.SQLOutput;
import java.util.Scanner;

public class UI {

    private static Customer customer;
    private static Account account;




    public String takeStringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    int id = 0;

    public void setup() {
        System.out.println("Velkommen til banken");
        System.out.println("Indtast venligst dit kunde ID");
        try {
            id = Integer.parseInt(takeStringInput());
            System.out.println("Mange tak, vælg venligst et af følgende funktioner");
            run();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public void run() {
        System.out.println(" 1 - Hæve penge \n 2 - Indsæt penge\n 3 - Kontoudtog\n 4 - Overfør penge\n 5 - Afslut");
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
                try {
                    int depositCurrentBalance = Dao.checkBalance(id);
                    System.out.println("Du har:" + depositCurrentBalance);
                    System.out.println("Hvor meget ønsker du at indsætte?");
                    int depositAmount = Integer.parseInt(takeStringInput());
                    Dao.makeTransaction(depositAmount, id);
                    int depositCurrentBalanceAfterDeposit = Dao.checkBalance(id);
                    System.out.println("Du har indsat" + depositAmount + "på" + id + "den nye balance er" + depositCurrentBalanceAfterDeposit);
                    run();
                } catch (NullPointerException e){
                    System.out.println(e);
                }
                System.out.println("Indtast venligst dit konto nummer:");

                break;
            case "3":
                System.out.println("Transactionerne på din konto er:");
                System.out.println(Dao.getTransactions(id).toString());
                run();
                break;
            case "4":
                try {
                    System.out.println("Hvor meget ønsker du at overføre?");
                    int transferAmount = Integer.parseInt(takeStringInput());
                    Dao.makeTransaction(-transferAmount,id);
                    System.out.println("Hvilken konto ønsker at indsætte på?");
                    int transferId = Integer.parseInt(takeStringInput());
                    Dao.makeTransaction(transferAmount, transferId);
                    System.out.println("Du har sat" + transferAmount + "DKK ind på" + transferId);
                    // Sout om balancen på kontoen :)
                }catch(NullPointerException e){
                System.out.println(e);
                run();
            }
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("Forkert input, prøv igen");


        }

    }
}
