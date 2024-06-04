import java.util.UUID;

public class Showroom implements utility {
    private String showroom_id;
    String showroom_name;
    String showroom_address;
    String manager_name;
    int total_cars_in_stock = 0;
    private int total_employees;

    @Override
    public void get_details() {
        System.out.println("Showroom Name: " + showroom_name);
        System.out.println("Showroom Address: " + showroom_address);
        System.out.println("Manager: " + manager_name);
        System.out.println("Total Employees: " + total_employees);
        System.out.println("Cars in Stock: " + total_cars_in_stock);
    }

    @Override
    public void set_details() {
        UUID uuid = UUID.randomUUID();
        String temp = String.valueOf(uuid).substring(0, 9);
        showroom_id = String.format("s%s", temp);
        System.out.println();
        System.out.println("- ENTER SHOWROOM DETAILS");
        System.out.println();
        System.out.print("Showroom Name: ");
        showroom_name = input.nextLine();
        System.out.print("Showroom Address: ");
        showroom_address = input.nextLine();
        System.out.print("Manager Name: ");
        manager_name = input.nextLine();
        System.out.print("No. of employees: ");
        total_employees = input.nextInt();
        System.out.print("Cars in stock: ");
        total_cars_in_stock = input.nextInt();
        input.nextLine();
    }
}
