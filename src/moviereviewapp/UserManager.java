package moviereviewapp;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserManager {

    private DatabaseManager dbm = new DatabaseManager("movieappdatabase");

    public void addUser(User u) {
        try {
            dbm.updateDatabase(""
                    + "INSERT INTO usertbl (UserName, DateOfCreation, PremiumUser, NumberOfReviews)"
                    + "VALUES ('" + u.getUsername() + "','" + u.getDateOfCreation() + "','" + (u.isPremium()?1:0) + "','" + u.getNumberOfReviews() + "');");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: adding user");
        }
    }

    public void deleteUser(User u) {
        try {
            dbm.updateDatabase(""
                    + "DELETE FROM usertbl "
                    + "WHERE idUser = " + u.getID() + ";");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: deleting user");
        }
    }

    public void edituser(User u) {
        try {
            dbm.updateDatabase(""
                    + "UPDATE usertbl "
                    + "SET Username = '" + u.getUsername() + "', DateOfCreation = '" + u.getDateOfCreation() + "', PremiumUser = '" + (u.isPremium()?"1":"0") + "', NumberOfReviews = '" + u.getNumberOfReviews() + "'"
                    + "WHERE idUser = '" + u.getID() + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: editing user");
        }
    }

    public User[] getUsers() {
        User[] arr = null;
        try {
            ResultSet countRS = dbm.queryDatabase("SELECT COUNT(*) FROM usertbl");
            countRS.next();
            int count = countRS.getInt(1);
            arr = new User[count];
            ResultSet userRS = dbm.queryDatabase("SELECT * FROM usertbl;");
            for (int i = 0; i < count; i++) {
                userRS.next();
                User u = new User(userRS.getInt(1), userRS.getString(2), userRS.getString(3), userRS.getBoolean(4), userRS.getInt(5));
                arr[i] = u;
            }
        } catch (Exception e) {
            e.printStackTrace();            
            System.out.println("error: reading movie database");
        }
        return arr;
    }
}
