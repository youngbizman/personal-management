package DAO;

import Entity.Vacation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VacationDAO {
    private static Connection conn = null;

    public void createVacation(Vacation vacation) {
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
          //  Statement st = conn.createStatement();
            dbHandler.openConnection();

            String beginningDate = vacation.getBeginningDate();
            String endingDate = vacation.getEndingDate();
            int nationalCode = vacation.getPersonalInformation().getNationalCode();
            long difference = vacation.getDifference();

            String sql = "insert into Vacation(beginningDate,endingDate,nationalCode,difference) values(?, ?, ?, ? )";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, beginningDate);
            preparedStatement.setString(2, endingDate);
            preparedStatement.setInt(3, nationalCode);
            preparedStatement.setLong(4, difference);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }
}


