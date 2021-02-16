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


    public static void withdrawmoney() throws SQLException {
        try {
            con.prepareStatement("INSERT INTO bank.transactions(MoneyChange,Accounts_Account id,Accounts_Customer_Customer id) VALUES (-?,?,?)");
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void checkAmount (int value) throws SQLException {
        try{
        con.prepareStatement("SELECT balance FROM bank.accounts WHERE accountid);
                con
        con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }




}