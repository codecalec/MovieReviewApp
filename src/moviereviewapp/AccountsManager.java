package moviereviewapp;

import java.sql.ResultSet;

public class AccountsManager {

    private DatabaseManager dbm = new DatabaseManager("movieappdatabase");
    public String[][] getAccounts() {
        String[][] accounts = null;
        try {
            ResultSet countRS = dbm.queryDatabase("SELECT COUNT(*) FROM accountstbl");
            countRS.next();
            int count = countRS.getInt(1);
            accounts = new String[count][];
            ResultSet accountRS = dbm.queryDatabase("SELECT * FROM accountstbl;");
            for (int i = 0; i < count; i++) {
                accountRS.next();
                String[] acc = {accountRS.getString(2), accountRS.getString(3)};
                accounts[i] = acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: reading account database");
        }
        return accounts;
    }
}
