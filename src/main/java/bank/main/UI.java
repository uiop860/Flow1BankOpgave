package bank.main;

import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    int id = 0;

    public String takeStringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void login(){
        LoginSystem loginSystem = new LoginSystem();
        String username = null;
        String password = null;
        String encryptedPassword = null;
        try{

            System.out.println("Velkommen til banken.");
            System.out.println("Indtast venligst brugernavn");
            username = takeStringInput();
            System.out.println("Indtast venligst kodeord");
            password = takeStringInput();
            encryptedPassword = LoginSystem.passwordEncryption(password);

            if (encryptedPassword.equals(loginSystem.checkPasswordInDB(username))){
                System.out.println("Korrekt kodeord");
                setup();
            } else {
                System.out.println("Forkert brugernavn eller kodeord");
                login();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    public void setup() {
        System.out.println("Velkommen til banken.");
        System.out.println("Indtast venligst dit kunde ID.");
        try {
            id = Integer.parseInt(takeStringInput());
            System.out.println("Mange tak, vælg venligst et af følgende funktioner.");
            run();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println(" 1 - Hæve penge \n 2 - Indsæt penge\n 3 - Kontoudtog\n 4 - Overfør penge\n 5 - Afslut");
            String input = takeStringInput();
            switch (input) {

                case "1":
                    int currentBalance = Dao.checkBalance(id);
                    System.out.println("Du har:" + currentBalance);
                    System.out.println("Hvor mange penge vil du hæve?");
                    int withdrawAmount;
                    try {
                        withdrawAmount = Integer.parseInt(takeStringInput());
                    } catch (NumberFormatException e) {
                        System.out.println("Forkert input, prøv igen BitchSo");
                        return;
                    }
                    Dao.makeTransaction(-withdrawAmount, id);
                    int currentBalanceAfterWithdraw = Dao.checkBalance(id);
                    System.out.println("Du har:" + currentBalanceAfterWithdraw);

                    break;
                case "2":
                    int depositCurrentBalance = Dao.checkBalance(id);
                    System.out.println("Du har:" + depositCurrentBalance);
                    System.out.println("Hvor meget ønsker du at indsætte?");
                    int depositAmount;
                    try {
                        depositAmount = Integer.parseInt(takeStringInput());
                    } catch (NumberFormatException e) {
                        System.out.println("Forkert input, prøv  igen BitchSo");
                        return;
                    }
                    Dao.makeTransaction(depositAmount, id);
                    int depositCurrentBalanceAfterDeposit = Dao.checkBalance(id);
                    System.out.println("Du har indsat " + depositAmount + " på " + id + " den nye balance er " + depositCurrentBalanceAfterDeposit);

                    break;
                case "3":
                    System.out.println("Transactionerne på din konto er:");
                    System.out.println(Dao.getTransactions(id).toString());

                    break;
                case "4":
                    System.out.println("Hvor meget ønsker du at overføre?");
                    int transferAmount;
                    try {
                        transferAmount = Integer.parseInt(takeStringInput());
                    } catch (NumberFormatException e) {
                        System.out.println("Forkert input, prøv igen BitchSo");
                        return;
                    }
                    Dao.makeTransaction(-transferAmount, id);
                    System.out.println("Hvilken konto ønsker at indsætte på?");
                    int transferId;
                    try {
                        transferId = Integer.parseInt(takeStringInput());
                    } catch (NumberFormatException e) {
                        System.out.println("Forkert input, prøv igen BitchSo");
                        return;
                    }
                    Dao.makeTransaction(transferAmount, transferId);
                    System.out.println("Du har sat " + transferAmount + " DKK ind på " + transferId);
                    System.out.println(Dao.checkBalance(id));
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Forkert input, prøv igen");
            }
        }
        System.exit(0);
    }
}
