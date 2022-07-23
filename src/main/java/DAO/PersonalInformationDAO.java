package DAO;

import Entity.PersonalInformation;

import java.sql.Connection;
import java.sql.Statement;


public class PersonalInformationDAO {
    private static Connection conn = null;

    public void CreatePersonalInformation(PersonalInformation personalInformation) {
        DBHandler dbHandler = new DBHandler();
        conn = dbHandler.openConnection();

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

//            String sql = "insert into personel1(name,age,nationalCode,hasVacation) values('" + personalInformation.getName() + "','" + personalInformation.getAge() +
//                    "','" + personalInformation.getNationalCode() + "',true );";
//            st.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbHandler.closeConnection();
    }
    };

