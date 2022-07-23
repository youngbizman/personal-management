package Service;

import DAO.PersonalInformationDAO;
import Entity.PersonalInformation;

import java.util.Scanner;

public class PersonalInformationBusiness {
    public static PersonalInformation getPersonByNumber(int q) {
        int i;

        for (i = 0; i < PersonalInformation.persons.size(); i++) {
            if (PersonalInformation.persons.get(i).getNationalCode() == q)
            {
                return PersonalInformation.persons.get(i);
            }
        }
        return null;
    }

    public static PersonalInformation getPersonByName(String q) {
        int i;

        for (i = 0; i < PersonalInformation.persons.size(); i++) {
            if (PersonalInformation.persons.get(i).getName().equals(q))
            {
                return PersonalInformation.persons.get(i);
            }
        }
        return null;
    }
    public static void personal() throws InterruptedException {
        String Name;
        String Address;
        int Age;
        int nationalCode;
        int Confirm;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your name?\n");
        Name = keyboard.nextLine();

        System.out.print("What is your full address?\n");
        Address = keyboard.nextLine();

        System.out.print("how old are you ?\n");
        Age = Integer.parseInt(keyboard.nextLine());

        System.out.print("Type your  national code without 0 in the beginning:\n");
        nationalCode = Integer.parseInt(keyboard.nextLine());

        PersonalInformation personalInformation = new PersonalInformation (Name, Address, Age, nationalCode);
        for (int i = 1; i <= 1; i++) {
            System.out.println("Your name is " + personalInformation.getName());
            System.out.println("Your address is " + personalInformation.getAddress());
            System.out.println("Your age is " + personalInformation.getAge());
            System.out.println("Your national code " + personalInformation.getNationalCode());
        }
        System.out.print("please confirm your information entering 1\n");
        Confirm = keyboard.nextInt();
        if (Confirm == 1) {
            System.out.println("personal creation successfully done\n");
            Thread.sleep(2000);
            PersonalInformationBusiness personalInformationBusiness = new PersonalInformationBusiness();
            personalInformationBusiness.CreatePersonalInformation(personalInformation);
        }

    }
    public void CreatePersonalInformation(PersonalInformation personalInformation)   {
        PersonalInformationDAO personalInformationDAO = new PersonalInformationDAO();
        personalInformationDAO.CreatePersonalInformation(personalInformation);
    }
}
