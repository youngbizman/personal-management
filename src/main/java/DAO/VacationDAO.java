package DAO;

import Entity.Vacation;
import Service.PersonalInformationBusiness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public Vacation searchVacationByNationalCode(int nationalCode) throws InterruptedException {
        int i;
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
            dbHandler.openConnection();


            String sql = "SELECT* FROM VACATION WHERE nationalcode= values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ;
            preparedStatement.setInt(1, nationalCode);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int newNationalCode = resultSet.getInt("nationalCode");
                String endingDate = resultSet.getString("endingDate");
                String beginningDate = resultSet.getString("beginningDate");
                String difference = resultSet.getString("difference");
                Vacation vacation = new Vacation(beginningDate,endingDate,PersonalInformationBusiness.getPersonByNumber(newNationalCode));
                return vacation;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
        Thread.sleep(2000);
        return null;
    }
}


