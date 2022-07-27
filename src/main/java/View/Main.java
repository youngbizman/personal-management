package View;


import Entity.PersonalInformation;
import Service.PersonalInformationBusiness;
import Service.TableService;
import Service.VacationBusiness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


enum MenuOptions
{
    a("Create personal"), b("Create Search"), c("Vacation Request"), d("Vacation Confirm"),
    e("Display Information"), q("quit"), z("Continue");

    // field
    private String meaning;

    // constructor
    MenuOptions(String meaning)
    {
        this.meaning = meaning;
    }

    // getters
    public String getMeaning()
    {
        return meaning;
    }
}

public class Main {
    int Phone;

    public static void main(String[] args) throws ParseException, InterruptedException {
        TableService tableService = new TableService();
        tableService.createTableVacation();
        tableService.createTablePersonnel();

        Scanner keyboard = new Scanner(System.in);

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<PersonalInformation> names = new ArrayList<PersonalInformation>();

        MenuOptions menuOptions = MenuOptions.z;

        while (true) {
            menu();
            menuOptions = MenuOptions.valueOf(keyboard.nextLine());


            switch (menuOptions) {
                case a:
                    PersonalInformationBusiness.personal();
                    break;

                case b:
                    PersonalInformationBusiness.search();
                    break;

                case c:
                    VacationBusiness.vacationRequest();
                    break;

                case d:
                    VacationBusiness.vacationConfirm();
                    break;

                case e:
                    break;

                case q:
                    System.out.println("Goodbye.");
                    System.exit(0);

                default:
                    System.out.println("Selection out of range. Try again");
            }
        }
    }

    public static void menu() {
        System.out.println("\nEnter:");
        System.out.println("\ta. Create personal");
        System.out.println("\tb. Search");
        System.out.println("\tc. Vacation Request");
        System.out.println("\td. Vacation Confirm");
      //  System.out.println("\te. Display Banks, Branches, Customers, and Transactions.");
        System.out.println("\tq. Quit Application.");
        System.out.print("\nSelection -> ");

    }








    }

