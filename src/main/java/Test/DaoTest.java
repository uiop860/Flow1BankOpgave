import bank.main.Dao;
import org.junit.jupiter.api.Test;

class DaoTest {

    @Test
    void checkBalance() {

        Dao.checkBalance(1);

    }

    @Test
    void makeTransaction() {

        Dao.makeTransaction(-456,1);

    }

    @Test
    void insertCustomerIntoDatabase() {

        Dao.insertCustomerIntoDatabase("Benny",25,"Langbortistan");
    }

    @Test
    void getCustomerIDFromAccountID(){

        System.out.println(Dao.getCustomerIDFromAccountID(1));


    }

    @Test
    void getTransactions(){

        System.out.println(Dao.getTransactions(1).toString());

    }
}