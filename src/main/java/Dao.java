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
    private static PreparedStatement checkAmount;


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

        return checkAmount(accountID);

    }

    public static int checkAmount(int accountID) {
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
}