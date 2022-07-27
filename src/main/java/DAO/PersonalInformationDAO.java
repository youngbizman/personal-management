package DAO;

import Entity.PersonalInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class PersonalInformationDAO {
    private static Connection conn = null;

    public void CreatePersonalInformation(PersonalInformation personalInformation) {
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
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

    public void search() throws InterruptedException {
        int i;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a national code without a 0 in the beginning:");
        i = keyboard.nextInt();
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
            dbHandler.openConnection();


            int nationalCode = i;

            String sql = "SELECT name FROM PERSONEL1 WHERE nationalcode= values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ;
            preparedStatement.setInt(1, nationalCode);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
        Thread.sleep(2000);

    }

    public String searchNameByNationalCode(int nationalCode) throws InterruptedException {
        int i;
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

        try {
            dbHandler.openConnection();


            String sql = "SELECT name FROM PERSONEL1 WHERE nationalcode= values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ;
            preparedStatement.setInt(1, nationalCode);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                return name;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        dbHandler.closeConnection();
        Thread.sleep(2000);

        return null;
    }


};

