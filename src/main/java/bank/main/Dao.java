package bank.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao extends Database {


    public static int makeTransaction(int moneyChange, int accountID) {
        try {
            Database.setup();
            int customerIDFromDB = getCustomerIDFromAccountID(accountID);
            PreparedStatement withdrawMoney = con.prepareStatement("INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (?,?,?)");
            withdrawMoney.setInt(1, moneyChange);
            withdrawMoney.setInt(2, accountID);
            withdrawMoney.setInt(3, customerIDFromDB);
            withdrawMoney.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkBalance(accountID);
    }

    public static int checkBalance(int accountID) {
        PreparedStatement getSumOfTransactions;
        PreparedStatement updateBalance;
        PreparedStatement getBalance;
        int result = 0;
        try {
            Database.setup();

            getSumOfTransactions = con.prepareStatement("SELECT SUM(moneychange) FROM bank.transactions where accounts_accountid=?");
            getSumOfTransactions.setInt(1,accountID);
            ResultSet rsSum  = getSumOfTransactions.executeQuery();
            rsSum.next();
            int sum = rsSum.getInt(1);

            updateBalance = con.prepareStatement("UPDATE bank.accounts SET balance=? WHERE accountid=?");
            updateBalance.setInt(1,sum);
            updateBalance.setInt(2,accountID);
            updateBalance.executeUpdate();

            getBalance = con.prepareStatement("SELECT balance FROM bank.accounts WHERE accountid=?");
            getBalance.setInt(1, accountID);
            ResultSet rsBalance = getBalance.executeQuery();
            rsBalance.next();
            result = rsBalance.getInt(1);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void insertCustomerIntoDatabase(String name, int age, String address) {
        PreparedStatement insertCustomer;
        PreparedStatement createAccount;
        PreparedStatement createLogin;
        try {
            Database.setup();
            createLogin = con.prepareStatement("");



            insertCustomer = con.prepareStatement("INSERT INTO bank.customer(Name, Age, Address) VALUES (?,?,?);");
            insertCustomer.setString(1, name);
            insertCustomer.setInt(2, age);
            insertCustomer.setString(3, address);
            insertCustomer.executeUpdate();

            createAccount = con.prepareStatement("INSERT INTO bank.accounts(customer_Customerid) SELECT customerid FROM bank.customer WHERE name = ? ");
            createAccount.setString(1,name);
            createAccount.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getCustomerIDFromAccountID(int accountID) {
        PreparedStatement getCustomerID;
        int result = 0;

        try {
            Database.setup();
            getCustomerID = con.prepareStatement("SELECT accountid FROM bank.accounts WHERE customer_customerid=?;");
            getCustomerID.setInt(1,accountID);
            ResultSet rs = getCustomerID.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Transaction> getTransactions(int accountID){
        PreparedStatement getTransactions;

        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            Database.setup();
            getTransactions = con.prepareStatement("SELECT transactionid,moneychange,date,accounts_accountid FROM bank.transactions WHERE accounts_accountid=?;");
            getTransactions.setInt(1,accountID);
            ResultSet rs = getTransactions.executeQuery();
            while (rs.next()){
                transactions.add(new Transaction(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}






















