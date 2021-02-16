import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DaoTest {

    @Test
    void checkAmount() {

        Assertions.assertEquals(1000, Dao.checkAmount(2));

    }

    @Test
    void makeTransaction() {

        Dao.makeTransaction(-100,2,1);

    }
}