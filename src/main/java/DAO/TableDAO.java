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
            String sql = "CREATE TABLE IF NOT EXISTS Vacation (" +
                    "ID int AUTO_INCREMENT PRIMARY KEY," +
                    "beginningDate DATE ," +
                    "endingDate DATE ," +
                    "nationalCode varchar (255)," +
                    "difference number " +
                    ");";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }

    public void createTablePersonnel() {
        DBHandler dbHandler = new DBHandler();
        Connection conn = dbHandler.openConnection();

        try {
            Statement st = conn.createStatement();
            dbHandler.openConnection();
            st.execute("CREATE TABLE IF NOT EXISTS personel1 (\n" +
                    "     ID int AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    Name varchar(255),\n" +
                    "    Address varchar(255),\n" +
                    "    Age int,\n" +
                    "    NationalCode varchar(255),\n" +
                    "    HasVacation boolean \n" +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }

    }

