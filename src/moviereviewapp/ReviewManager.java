package moviereviewapp;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ReviewManager {

    private DatabaseManager dbm = new DatabaseManager("movieappdatabase");

    public void addReview(Review r) {
        try {
            dbm.updateDatabase(""
                    + "INSERT INTO reviewtbl (Movie,User,DateOfSubmission,Rating)"
                    + "VALUES ('" + r.getMovieID() + "','" + r.getUserID() + "','" + r.getDateOfSubmission() + "','" + r.getRating() + "');");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "This Movie and/or User ID doesn't exist");
            System.out.println("Error: adding review");
        }
    }

    public void deleteReview(Review r) {
        try {
            dbm.updateDatabase(""
                    + "DELETE FROM reviewtbl "
                    + "WHERE idReview = " + r.getID() + ";");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: deleting review");
        }
    }

    public void editReview(Review r) {
        try {
            dbm.updateDatabase(""
                    + "UPDATE reviewtbl "
                    + "SET Movie = '" + r.getMovieID() + "', User = '" + r.getUserID() + "', DateOfSubmission = '" + r.getDateOfSubmission() + "', Rating = '" + r.getRating() + "'"
                    + "WHERE idReview = '" + r.getID() + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: editing review");
        }
    }

    public Review[] getReviews() {
        Review[] arr = null;
        try {
            ResultSet countRS = dbm.queryDatabase("SELECT COUNT(*) FROM reviewtbl");
            countRS.next();
            int count = countRS.getInt(1);
            arr = new Review[count];
            ResultSet reviewRS = dbm.queryDatabase("SELECT * FROM reviewtbl;");
            for (int i = 0; i < count; i++) {
                reviewRS.next();
                Review r = new Review(reviewRS.getInt(1), reviewRS.getInt(2), reviewRS.getInt(3), reviewRS.getString(4), reviewRS.getInt(5));
                arr[i] = r;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: reading movie database");
        }
        return arr;
    }
}
