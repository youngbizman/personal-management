package DAO;

import Entity.Vacation;

import java.sql.Connection;
import java.sql.Statement;

public class VacationDAO {
    private static Connection conn = null;

    public void createVacation(Vacation vacation) {
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
            Statement st = conn.createStatement();
            dbHandler.openConnection();

            String sql = "insert into Vacation(beginningDate,endingDate,nationalCode,difference) values('" + vacation.getBeginningDate() + "','" + vacation.getEndingDate()+
                    "','" + vacation.getPersonalInformation().getNationalCode()+ "','" + vacation.getDifference() + "');";
            st.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }
}
