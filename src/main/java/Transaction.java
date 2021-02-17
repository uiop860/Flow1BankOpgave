import java.util.Date;
import java.util.Scanner;

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
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", moneyChange=" + moneyChange +
                ", date='" + date + '\'' +
                ", accountID=" + accountID +
                '}'+"\n";
    }

    /** Getters and setters */

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getMoneyChange() {
        return moneyChange;
    }

    public void setMoneyChange(int moneyChange) {
        this.moneyChange = moneyChange;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
