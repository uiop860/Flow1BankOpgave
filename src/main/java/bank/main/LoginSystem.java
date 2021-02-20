package bank.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSystem extends Database {


    public int getCustomerIDFromDB(String username) {
        PreparedStatement getPasswordFromDB;
        int result = 0;
        try {
            setup();

            getPasswordFromDB = con.prepareStatement("SELECT Customer_customerid FROM bank.login WHERE username=?;");
            getPasswordFromDB.setString(1, username);
            ResultSet rs = getPasswordFromDB.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public String checkPasswordInDB(String username) {
        PreparedStatement getPasswordFromDB;
        String result = null;
        try {
            setup();

            getPasswordFromDB = con.prepareStatement("SELECT password FROM bank.Login WHERE username=?;");
            getPasswordFromDB.setString(1, username);
            ResultSet rs = getPasswordFromDB.executeQuery();
            rs.next();
            result = rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String passwordEncryption(String passwordToHash) {

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
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }
}
