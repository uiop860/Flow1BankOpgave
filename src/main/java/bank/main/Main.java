package bank.main;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        ui.setup();
        ui.run();


        Account account = new Account(new Customer("brina",12,"fisk"));


    }
}