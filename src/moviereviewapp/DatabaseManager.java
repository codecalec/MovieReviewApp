package moviereviewapp;

import java.sql.*;

public class DatabaseManager {

    private Connection conn = null;
//Tries to connect to the database

    public DatabaseManager(String dbName) {
        try {
            //Attempt to load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Connect to the appropriate Database
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, "root", "");
            System.out.println("Connection successful");
        } //if the connection fails the the error message 'Failed to get connection'
        //shows and the stacktrace is shown.
        catch (Exception e) {
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
//tries to run the SQL given to edit or read from the database.

    public ResultSet queryDatabase(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
//updates the database based on what the statement says.

    public void updateDatabase(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
}
