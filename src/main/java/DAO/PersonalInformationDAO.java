package DAO;

import Entity.PersonalInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class PersonalInformationDAO {
    private static Connection conn = null;

    public void CreatePersonalInformation(PersonalInformation personalInformation) {
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
       //     Statement st = conn.createStatement();
            dbHandler.openConnection();

            String firstName = personalInformation.getName();
            int age = personalInformation.getAge();
            int nationalCode = personalInformation.getNationalCode();
            String address = personalInformation.getAddress();
            boolean hasVacation = false;

            String sql = "insert into personel1(name,age,nationalCode,hasVacation,address) values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, nationalCode);
            preparedStatement.setBoolean(4, hasVacation);
            preparedStatement.setString(5, address);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }
};

