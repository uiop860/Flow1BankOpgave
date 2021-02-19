package bank.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginSystemTest {

    @Test
    void passwordEncryption() {

        System.out.println(LoginSystem.passwordEncryption("kage"));;

    }
}