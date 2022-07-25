package Service;

import DAO.VacationDAO;
import Entity.Vacation;

import java.text.ParseException;
import java.util.Scanner;

public class VacationBusiness {
    public static Vacation getVacationByName(String q) {
        int i;

        for (i = 0; i < Vacation.vacations.size(); i++) {
            if (Vacation.vacations.get(i).getPersonalInformation().getName().equals(q))
            {
                return Vacation.vacations.get(i);
            }
        }



        return null;
    }
    public static void printAllVacations() throws InterruptedException {
        int i ;
        for ( i = 0 ; i <Vacation.vacations.size(); i++)
        {

            System.out.println(Vacation.vacations.get(i).getPersonalInformation().getName()+"'s vacation");
            System.out.println("starting from "+Vacation.vacations.get(i).getBeginningDate());
            System.out.println("until "+Vacation.vacations.get(i).getEndingDate());
            if (Vacation.vacations.get(i).isRequestConfirm() == true) {
                System.out.println("state : confirmed");
            }
            else System.out.println("state : not confirmed\n");
        }
        Thread.sleep(2000);

    }
    public static void printConfirmedVacations() throws InterruptedException {

        int i ;
        for ( i = 0 ; i <Vacation.vacations.size(); i++)
        {
            if (Vacation.vacations.get(i).isRequestConfirm() == true)
            {
                System.out.println(Vacation.vacations.get(i).getPersonalInformation().getName()+"'s vacation");
                System.out.println("starting from "+Vacation.vacations.get(i).getBeginningDate());
                System.out.println("until "+Vacation.vacations.get(i).getEndingDate());
                Thread.sleep(2000);
            }
        }
    }
    public static void printUnconfirmedVacations() throws InterruptedException {

        int i ;
        for ( i = 0 ; i <Vacation.vacations.size(); i++)
        {
            if (Vacation.vacations.get(i).isRequestConfirm() == false)
            {
                System.out.println(Vacation.vacations.get(i).getPersonalInformation().getName()+"'s vacation");
                System.out.println("starting from "+Vacation.vacations.get(i).getBeginningDate());
                System.out.println("until "+Vacation.vacations.get(i).getEndingDate());
                Thread.sleep(2000);

            }
        }
    }
    public static void changeConfirmedVacation() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Whose vacation do you wanna confirmed?");
        String name;
        name = keyboard.nextLine();
        VacationBusiness.getVacationByName(name).setRequestConfirm(true);
        System.out.println(PersonalInformationBusiness.getPersonByName(name).getName() + "'s vacation has been successfully  confirmed");
    }
    public static void changeUnconfirmedVacation() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Whose vacation do you wanna unconfirmed?");
        String name;
        name = keyboard.nextLine();
        VacationBusiness.getVacationByName(name).setRequestConfirm(false);
        System.out.println(PersonalInformationBusiness.getPersonByName(name).getName()+ "'s vacation has been successfully  unconfirmed");
    }
    public static void vacationConfirm() throws ParseException, InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        String name;
        int i = 0;

        System.out.println("enter:\n a.  all vacations\n b.  confirmed vacations\n c.  unconfirmed vacations\n");
        String key = keyboard.nextLine();

        if (key.equalsIgnoreCase("a")) {
            VacationBusiness.printAllVacations();
        }
        if (key.equalsIgnoreCase("b")) {
            VacationBusiness.printConfirmedVacations();
            System.out.println("access editing clicking 1 ");
            i = keyboard.nextInt();
            if (i == 1) VacationBusiness.changeUnconfirmedVacation();

        }
        if (key.equalsIgnoreCase("c")) {
            VacationBusiness.printUnconfirmedVacations();
            System.out.println("access editing clicking 1 ");
            i = keyboard.nextInt();
            if (i == 1) {
                VacationBusiness.changeConfirmedVacation();
            }
        }

        else vacationConfirm();


    }
    public static void vacationRequest() throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        String name;
        String beginning;
        String ending;
        int confirm;
        System.out.println("please enter your name");
        name = keyboard.nextLine();
        System.out.println("" + PersonalInformationBusiness.getPersonByName(name).getName() + " you have been successfully logged in");
        System.out.println("please enter your Vacation's beginning time in yyyy-mm-dd format");
        beginning = keyboard.nextLine();
        System.out.println("please enter your Vacation's ending time in yyyy-mm-dd format");
        ending = keyboard.nextLine();
        Vacation vacation = new Vacation(beginning, ending, PersonalInformationBusiness.getPersonByName(name));
        System.out.println("you want a " + vacation.getDifference() + " days vacation from "
                + vacation.getBeginningDate() + " until " + vacation.getEndingDate() + "\n" + " confirm entering 1 ");
        confirm = keyboard.nextInt();
        if (confirm == 1) {
            System.out.println(" your vacation request has been  successfully sent");
        }
        VacationBusiness vacationBusiness = new VacationBusiness();
        vacationBusiness.CreateVacation(vacation);


    }
    public void CreateVacation(Vacation vacation)   {
        VacationDAO vacationDAO = new VacationDAO();
        vacationDAO.createVacation(vacation);
    }

}
