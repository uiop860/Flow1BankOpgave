import java.util.ArrayList;

import java.util.List;

public class Account extends Database{

    private List<Transaction> transactions;
    public Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }


    public int getBalance(int accountID) {

        return Dao.checkBalance(accountID);

    }

    public int depositOrWithdraw(int amount, int accountID,int customerID){

        return Dao.makeTransaction(amount,accountID,customerID);
    }



}
