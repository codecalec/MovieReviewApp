package moviereviewapp;

import java.sql.ResultSet;

public class MovieManager {

    private DatabaseManager dbm = new DatabaseManager("movieappdatabase");

    public void addMovie(Movie m) {
        try {
            dbm.updateDatabase(""
                    + "INSERT INTO moviestbl (MovieName, Director,DateOfRelease)"
                    + "VALUES ('" + m.getName() + "','" + m.getDirector() + "','" + m.getDateOfRelease() + "');");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: adding movie");
        }
    }

    public void deleteMovie(Movie m) {
        try {
            dbm.updateDatabase(""
                    + "DELETE FROM moviestbl "
                    + "WHERE idMovies = " + m.getID() + ";");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: deleting movie");
        }
    }

    public void editMovie(Movie m) {
        try {
            dbm.updateDatabase(""
                    + "UPDATE moviestbl "
                    + "SET MovieName = '" + m.getName() + "', Director = '" + m.getDirector() + "', DateOfRelease = '" + m.getDateOfRelease() + "' "
                    + "WHERE idMovies = " + m.getID() + ";");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: editing movie");
        }
    }

    public Movie[] getMovies() {
        Movie[] arr = null;
        try {
            ResultSet countRS = dbm.queryDatabase("SELECT COUNT(*) FROM moviestbl");
            countRS.next();
            int count = countRS.getInt(1);
            arr = new Movie[count];
            ResultSet movieRS = dbm.queryDatabase("SELECT * FROM moviestbl;");
            for (int i = 0; i < count; i++) {
                movieRS.next();
                Movie m = new Movie(movieRS.getInt(1), movieRS.getString(2), movieRS.getString(3), movieRS.getString(4));
                arr[i] = m;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: reading movie database");
        }
        return arr;
    }
}
