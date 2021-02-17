import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DaoTest {

    @Test
    void checkAmount() {

        Assertions.assertEquals(1000, Dao.checkBalance(2));

    }

    @Test
    void makeTransaction() {

        Dao.makeTransaction(-456,2);

    }

    @Test
    void insertCustomerIntoDatabase() {

        Dao.insertCustomerIntoDatabase("Benny",25,"Langbortistan");
    }

    @Test
    void getCustomerIDFromAccountID(){

        System.out.println(Dao.getCustomerIDFromAccountID(1));


    }
}