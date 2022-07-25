package DAO;

import java.sql.Connection;
import java.sql.Statement;

public class TableDAO {

    public void createTableVacation() {
        DBHandler dbHandler = new DBHandler();
        Connection conn = dbHandler.openConnection();

        try {
            Statement st = conn.createStatement();
            dbHandler.openConnection();
            st.execute("CREATE TABLE IF NOT EXISTS Vacation (\n" +
                    "     ID int AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    beginningDate DATE (255),\n" +
                    "     endingDate DATE (255),\n" +
                    "     nationalCode int (255),\n" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }

    public void createTablePersonnel() {

    }
}
