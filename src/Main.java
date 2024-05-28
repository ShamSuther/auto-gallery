import java.util.*;
import java.lang.*;

// main interface
interface utility {
    public void get_details();

    public void set_details();
}

public class Main {
    // constants
    public static final String APP_NAME = "AutoGallery";

    // main menu
    static void main_menu() {
        String WELCOME = String.format("*** Welcome to %s ***", APP_NAME);

        System.out.println();
        System.out.println(WELCOME);
        System.out.println();
        System.out.println("THE SHOWROOM MANAGEMENT SYSTEM");
        System.out.println();
        System.out.println("1) Add Showrooms \t2) Add Employees \t3) Add Cars");
        System.out.println();
        System.out.println("4) Get Showrooms \t5) Get Employees \t6) Get Cars");
        System.out.println();
        System.out.println("PRESS 0 TO EXIT PROGRAM.");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Showroom showroom[] = new Showroom[5];
        Employees employee[] = new Employees[25];
        Cars car[] = new Cars[5];

        int car_counter = 0;
        int showroom_counter = 0;
        int employees_counter = 0;
        int choice = 100;

        // keep the loop running until exit 0.

        while (choice != 0) {
            main_menu();
            choice = input.nextInt();

            // exit
            if(choice == 0){
                System.out.println();
                System.out.print("Exiting");

                // delay the exit
                for(int i = 0; i < 3;i++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(".");
                }

                System.out.println();
                System.out.println("\nTodaloo!\n");
                input.close();
            }

            // main choices
            while (choice != 9 && choice != 0) {
                switch (choice) {
                    case 1:
                        showroom[showroom_counter] = new Showroom();
                        showroom[showroom_counter].set_details();
                        showroom_counter++;
                        System.out.println();
                        System.out.println("1].ADD NEW SHOWROOM");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choice = input.nextInt();
                        break;
                    case 2:
                        employee[employees_counter] = new Employees();
                        employee[employees_counter].set_details();
                        employees_counter++;
                        System.out.println();
                        System.out.println("2].ADD NEW EMPLOYEE");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choice = input.nextInt();
                        break;
                    case 3:
                        car[car_counter] = new Cars();
                        car[car_counter].set_details();
                        car_counter++;
                        System.out.println();
                        System.out.println("3].ADD NEW CAR");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choice = input.nextInt();
                        break;
                    case 4:
                        for (int i = 0; i < showroom_counter; i++) {
                            showroom[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choice = input.nextInt();
                        break;
                    case 5:
                        for (int i = 0; i < employees_counter; i++) {
                            employee[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choice = input.nextInt();
                        break;
                    case 6:
                        for (int i = 0; i < car_counter; i++) {
                            car[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choice = input.nextInt();
                        break;
                    default:
                        System.out.println("ENTER VALID CHOICE: ");
                        break;
                }
            }
        }

    }
}