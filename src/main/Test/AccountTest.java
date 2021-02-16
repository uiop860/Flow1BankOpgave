import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class AccountTest {


    private Customer customer;
    private Account account;

    @BeforeEach
    void temp(){
        customer = new Customer("Jens",18,"Kirkevej");
        account = new Account(customer);

    }

    @Test
    void getCustomer(){
        Assertions.assertNotNull(account.getCustomer());
        Assertions.assertEquals(customer,account.getCustomer());
    }

    @Test
    public void getBalance() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100,new Date()));

        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }

        Assertions.assertEquals(100,sum);

    }

    @Test
    void withDrawAmount() {
        account.depositAmount(100);
        try {
            Assertions.assertEquals(50,account.withDrawAmount(50));
        } catch (BankExeption bankExeption) {
            bankExeption.printStackTrace();
        }
    }

    @Test
    void depositAmount() {
        Assertions.assertEquals(100, account.depositAmount(100));

    }

    @Test
    void getTransactions() {
        account.depositAmount(100);
        account.depositAmount(200);
        account.depositAmount(175);
        Assertions.assertEquals(100,account.getTransactions().get(0).getAmount());
        Assertions.assertEquals(200,account.getTransactions().get(1).getAmount());
        Assertions.assertEquals(175,account.getTransactions().get(2).getAmount());
        Assertions.assertNotNull(account.getTransactions());
    }
}