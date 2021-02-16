import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoTest {

    @Test
    void checkAmount() {

        Assertions.assertEquals(1000,Dao.checkAmount(2));


    }
}