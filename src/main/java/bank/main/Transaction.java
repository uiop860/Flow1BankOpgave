package bank.main;

public class Transaction extends Database {


    private int transactionID;
    private int moneyChange;
    private String date;
    private int accountID;

    public Transaction(int transactionID, int moneyChange, String date, int accountID) {
        this.transactionID = transactionID;
        this.moneyChange = moneyChange;
        this.date = date;
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "bank.main.Transaction{" +
                "transactionID=" + transactionID +
                ", moneyChange=" + moneyChange +
                ", date='" + date + '\'' +
                ", accountID=" + accountID +
                '}'+"\n";
    }
}
