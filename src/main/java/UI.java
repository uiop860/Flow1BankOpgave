import java.sql.SQLOutput;
import java.util.Locale;

public class UI {

    private static Customer customer;
   ;   



    public static void run() {
        System.out.println("Velkommen til banken");
        System.out.println("1 - Hæve penge \n 2 - Indsæt penge\n 3 - Kontoudtog\n 4 - Overfør penge\"");
        String input = customer.takeInput();
        switch (input) {
            case "1":
                System.out.println("Indtast venligst dit konto nummer:");

                break;
            case "2":
                System.out.println("Indtast venligst dit konto nummer:");

                break;
            case "3":
                System.out.println("Indtast venligst dit konto nummer:");

                break;
            case "4":
                System.out.println("Indtast venligst dit konto nummer:");

            default:
                System.out.println("forkert input, prøv igen");








    }
}
