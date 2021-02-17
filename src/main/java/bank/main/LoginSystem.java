package bank.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginSystem extends Database {

    public String input() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void loginSystem(){
        System.out.println("Username");
        String username = input();
        System.out.println("Password");
        String encryptedPassword = passwordEncryption(input());

    }

    public void insertUserIntoDB(){
        PreparedStatement insertUserIntoDB;

        try {
            setup();
            insertUserIntoDB = con.prepareStatement("");


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getUserFromDB(String username, String password){
        PreparedStatement getUserFromDB;
        try {
            setup();
            String encryptedPassword = passwordEncryption(password);

            getUserFromDB = con.prepareStatement("SELECT ");


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String passwordEncryption(String passwordToHash){

        // tyv stjålet fra https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return generatedPassword;
    }
}
