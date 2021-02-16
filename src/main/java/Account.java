import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account extends Database{

    private List<Transaction> transactions;
    private Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBalance(int accountID) {

        return Dao.checkAmount(accountID);

    }

    public int depositOrWithdraw(int amount, int accountID,int customerID){

        return Dao.makeTransaction(amount,accountID,customerID);
    }

    public int depositAmount(int amount) {

        transactions.add(new Transaction(amount, new Date()));
        return getBalance();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
