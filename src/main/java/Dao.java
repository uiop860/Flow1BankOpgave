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
        PreparedStatement checkAmount;
        int result = 0;
        try {
            Database.setup();
            checkAmount = con.prepareStatement("SELECT balance FROM bank.accounts WHERE accountid=?");
            checkAmount.setInt(1, accountID);
            ResultSet rs = checkAmount.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void insertCustomerIntoDatabase(String name, int age, String address) {
        PreparedStatement insertCustomer;
        try {
            Database.setup();
            insertCustomer = con.prepareStatement("INSERT INTO bank.customer(Name, Age, Address) VALUES (?,?,?);");
            insertCustomer.setString(1, name);
            insertCustomer.setInt(2, age);
            insertCustomer.setString(3, address);
            insertCustomer.executeUpdate();
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

    public static ArrayList getTransactions(int accountID){
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






















