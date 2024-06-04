import java.util.UUID;

public class Employees extends Showroom {
    private String showroom_id;
    private String emp_id;
    private int emp_age;
    String emp_name;
    String emp_department;

    public void set_showroom_id(String sid) {
        this.showroom_id = sid;
    }

    @Override
    public void get_details() {
        System.out.println("ID: " + emp_id);
        System.out.println("Name: " + emp_name);
        System.out.println("Age: " + emp_age);
        System.out.println("Department: " + emp_department);
        System.out.println("Showroom Name: " + showroom_name);

    }

    @Override
    public void set_details() {
        UUID uuid = UUID.randomUUID();
        emp_id = String.valueOf(uuid).substring(0, 5);
        System.out.println();
        System.out.println("- ENTER EMPLOYEE DETAILS");
        System.out.println();
        System.out.print("Name: ");
        emp_name = input.nextLine();
        System.out.print("Age: ");
        emp_age = input.nextInt();
        input.nextLine();
        System.out.print("Department: ");
        emp_department = input.nextLine();
        System.out.print("Showroom Name: ");
        showroom_name = input.nextLine();
    }
}
