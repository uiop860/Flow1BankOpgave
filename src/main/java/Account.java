import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private List<Transaction> transactions;
    private Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBalance(){
        // TODO: skal debugges
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }
        return sum;
    }

    public int withDrawAmount(int amount) throws BankExeption{
        // TODO: skal kodes og returnere ny saldo. Smid fejl hvis amount > saldo
        if (amount > getBalance()){
            throw new BankExeption("Du har ikke nok penge");
        } else if (amount < 0){
            throw new BankExeption("Du kan ikke hæve negative tal");
        }
        transactions.add(new Transaction(-amount,new Date()));

        return getBalance();
    }

    public int depositAmount(int amount){
        // TODO: skal debugges og returnere ny saldo. Smid fejl hvis amount < 0.
        transactions.add(new Transaction(amount, new Date()));
        return getBalance();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
