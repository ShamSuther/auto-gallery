import java.util.*;
import java.lang.*;

// main interface
interface utility {
    Scanner input = new Scanner(System.in);

    public void get_details();

    public void set_details();
}

/*
 * The Main class contains the primary logic for the AutoGallery application.
 * It displays a menu to the user and allows them to add and view showrooms,
 * employees, and cars.
 */

public class Main {
    // constants
    public static final String APP_NAME = "AutoGallery";
    public static Scanner input = new Scanner(System.in);

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
        System.out.print("-- Enter your choice: ");
    }

    /**
     * The main method that starts the application.
     * It manages user input and directs the flow of the application based on user
     * choices.
     */
    public static void main(String[] args) {
        Showroom showroom[] = new Showroom[5];
        Employees employee[] = new Employees[25];
        Cars car[] = new Cars[5];

        int car_counter = 0;
        int showroom_counter = 0;
        int employees_counter = 0;
        int choice = 100;

        // keep the loop running until exit 0.

        while (choice != 0) {
            Main.main_menu();
            choice = input.nextInt();

            // exit
            if (choice == 0) {
                System.out.println();
                System.out.print("Exiting");

                // delay the exit
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(".");
                }

                System.out.println();
                System.out.println("\ntoodle-oo!\n");
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
                        System.out.println("1) Add New Showroom");
                        System.out.println("9) Go back to Main Menu");
                        choice = take_input();
                        break;
                    case 2:
                        if (showroom_counter >= 1) {
                            employee[employees_counter] = new Employees();
                            employee[employees_counter].set_details();
                            if (does_showroom_exist(showroom, showroom_counter, employee[employees_counter])) {
                                employees_counter++;
                            } else {
                                employees_counter--;
                            }
                            System.out.println();
                            System.out.println("2) Add New Employee");
                            System.out.println("9) Go back to Main Menu");
                            choice = take_input();
                        } else {
                            System.out.println();
                            System.out.println("+-----------------------------+");
                            System.out.println("! Please add a showroom first !");
                            System.out.println("+-----------------------------+");
                            choice = 9;
                        }
                        break;
                    case 3:
                        if (showroom_counter > 0) {
                            car[car_counter] = new Cars();
                            car[car_counter].set_details();
                            if (does_showroom_exist(showroom, showroom_counter, car[car_counter])) {
                                car_counter++;
                            } else {
                                car_counter--;
                            }
                            System.out.println();
                            System.out.println("3) Add New Car");
                            System.out.println("9) Go back to Main Menu");
                            choice = take_input();
                        } else {
                            System.out.println();
                            System.out.println("+-----------------------------+");
                            System.out.println("! Please add a showroom first !");
                            System.out.println("+-----------------------------+");
                            choice = 9;
                        }
                        break;
                    case 4:
                        if (showroom_counter > 0) {
                            System.out.println();
                            for (int i = 0; i < showroom_counter; i++) {
                                System.out.println("#" + (i + 1));
                                System.out.println();
                                showroom[i].get_details();
                                if (i != showroom_counter - 1) {
                                    System.out.println();
                                }
                            }
                            System.out.println();
                            choice = 9;
                        } else {
                            System.out.println();
                            System.out.println("+-----------------------------+");
                            System.out.println("! Please add a showroom first !");
                            System.out.println("+-----------------------------+");
                            choice = 9;
                        }
                        break;
                    case 5:
                        if (employees_counter >= 1) {
                            System.out.println();
                            for (int i = 0; i < employees_counter; i++) {
                                System.out.println("#" + (i + 1));
                                System.out.println();
                                employee[i].get_details();
                                if (i != employees_counter - 1) {
                                    System.out.println();
                                }
                            }
                            choice = 9;
                        } else {
                            System.out.println();
                            System.out.println("+----------------------------+");
                            System.out.println("! Please add employees first !");
                            System.out.println("+----------------------------+");
                            choice = 9;
                        }
                        break;
                    case 6:
                        if (car_counter >= 1) {
                            System.out.println();
                            for (int i = 0; i < car_counter; i++) {
                                System.out.println("#" + (i + 1));
                                System.out.println();
                                car[i].get_details();
                                if (i != car_counter - 1) {
                                    System.out.println();
                                }
                            }
                            choice = 9;
                        } else {
                            System.out.println();
                            System.out.println("+-----------------------+");
                            System.out.println("! Please add cars first !");
                            System.out.println("+-----------------------+");
                            choice = 9;
                        }
                        break;
                    default:
                        System.out.println("ENTER VALID CHOICE: ");
                        break;
                }
            }
        }

    }

    // utility function

    // take user input

    public static int take_input() {
        System.out.println();
        System.out.print("-- Enter your choice: ");
        return input.nextInt();
    }

    // check showroom existence

    public static boolean does_showroom_exist(Showroom[] showrooms, int showroom_counter, Object obj) {
        boolean showroomExists = false;
        String sid;

        if (obj instanceof Employees) {
            Employees employee = (Employees) obj;
            for (int i = 0; i < showroom_counter; i++) {
                if (showrooms[i].showroom_name.equals(employee.showroom_name)) {
                    showroomExists = true;
                    sid = showrooms[i].get_showroom_id();
                    employee.set_showroom_id(sid);
                    break;
                }
            }
        } else if (obj instanceof Cars) {
            Cars car = (Cars) obj;
            for (int i = 0; i < showroom_counter; i++) {
                if (showrooms[i].showroom_name.equals(car.showroom_name)) {
                    showroomExists = true;
                    sid = showrooms[i].get_showroom_id();
                    car.set_showroom_id(sid);
                    break;
                }
            }
        }

        return showroomExists;
    }
}