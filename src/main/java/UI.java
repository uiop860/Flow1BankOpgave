import java.util.Scanner;

public class UI {

    private static Customer customer;
    private static Account account;
   ;


        public String takeStringInput(){
            Scanner input = new Scanner(System.in);
            return  input.nextLine();
        }


    public void run() {
        System.out.println("Velkommen til banken");
        System.out.println("1 - Hæve penge \n 2 - Indsæt penge\n 3 - Kontoudtog\n 4 - Overfør penge\"");
        String input = takeStringInput();
        switch (input) {
            case "1":
                System.out.println("Indtast venligst dit konto nummer");
                int id = Integer.parseInt(takeStringInput());
                int amount = account.getBalance(id);
                System.out.println("Du har:" + amount);
                System.out.println("Hvor mange penge vil du hæve?");


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
                System.out.println("forkert input, prøv igen");


        }

    }}
