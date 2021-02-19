package bank.main;

import com.mysql.cj.protocol.Resultset;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            insertUserIntoDB = con.prepareStatement("");


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String checkPasswordInDB(String username){
        PreparedStatement getPasswordFromDB;
        String result = null;
        try {
            setup();

            getPasswordFromDB = con.prepareStatement("SELECT password FROM bank.Login WHERE username=?;");
            getPasswordFromDB.setString(1,username);
            ResultSet rs = getPasswordFromDB.executeQuery();
            rs.next();
            result = rs.getString(1);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public String checkUsernameInDB(String username){
        PreparedStatement getUsernameFromDB;
        String result = null;
        try {
            setup();

            getUsernameFromDB = con.prepareStatement("SELECT username FROM bank.login where password=?;");
            getUsernameFromDB.setString(1,username);
            ResultSet rs = getUsernameFromDB.executeQuery();
            rs.next();
            result = rs.getString(1);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static String passwordEncryption(String passwordToHash){

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
