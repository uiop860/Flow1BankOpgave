import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao extends Database {

    /*
    try{
        con.prepareStatement("");
        con.close();
    }catch (SQLException e){
        e.printStackTrace();
    }
    */


    public static int makeTransaction(int moneyChange, int accountID, int customerID) {
        try {
            Database.setup();
            PreparedStatement withdrawMoney = con.prepareStatement("INSERT INTO bank.transactions(moneychange,accounts_accountid,accounts_customer_customerid) VALUES (?,?,?)");
            withdrawMoney.setInt(1, moneyChange);
            withdrawMoney.setInt(2, accountID);
            withdrawMoney.setInt(3, customerID);
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

    public static void insertCustomerIntoDatabase(String name, int age, String address){
        PreparedStatement insertCustomer;
        try {
            Database.setup();
            insertCustomer = con.prepareStatement("INSERT INTO bank.customer(Name, Age, Address) VALUES (?,?,?);");
            insertCustomer.setString(1,name);
            insertCustomer.setInt(2,age);
            insertCustomer.setString(3,address);
            insertCustomer.executeUpdate();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}


















