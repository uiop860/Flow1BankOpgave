package bank.main;

import org.junit.jupiter.api.Test;
import sun.rmi.runtime.Log;

import static org.junit.jupiter.api.Assertions.*;

class UITest {

    @Test
    void login() {
        LoginSystem loginSystem = new LoginSystem();
        String username = "fisk";
        String password = "fisk";
        String encryptedPassword = LoginSystem.passwordEncryption(password);

        if (encryptedPassword.equals(loginSystem.checkPasswordInDB(username))){
            System.out.println("Korrekt kodeord");
        } else {
            System.out.println("Forkert brugernavn eller kodeord");
        }
    }
}