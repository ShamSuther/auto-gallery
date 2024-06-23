import java.util.UUID;

public class Cars extends Showroom {
    private String showroom_id;
    private String car_id;
    String car_name;
    String car_brand;
    String car_color;
    String car_fuel_type;
    int car_price;
    String car_type;
    String car_transmission;
    String showroom_name;
    
    public void set_showroom_id(String sid) {
        this.showroom_id = sid;
    }

    @Override
    public void get_details() {
        System.out.println("Model: " + car_name);
        System.out.println("Brand: " + car_brand);
        System.out.println("Color: " + car_color);
        System.out.println("Fuel Type: " + car_fuel_type);
        System.out.println("Price: $" + car_price);
        System.out.println("Car type: " + car_type);
        System.out.println("Transmission: " + car_transmission);
    }

    @Override
    public void set_details() {
        UUID uuid = UUID.randomUUID();
        String temp = String.valueOf(uuid).substring(0, 3);
        car_id = String.format("car_%s", temp);
        System.out.println();
        System.out.println("- ENTER CAR DETAILS");
        System.out.println();
        System.out.print("Model: ");
        car_name = input.nextLine();
        System.out.print("Brand: ");
        car_brand = input.nextLine();
        System.out.print("Color: ");
        car_color = input.nextLine();
        System.out.print("Fuel type: ");
        car_fuel_type = input.nextLine();
        System.out.print("Price: ");
        car_price = input.nextInt();
        input.nextLine();
        System.out.print("Car type (sedan/SUV/HatchBack): ");
        car_type = input.nextLine();
        System.out.print("Transmission type: ");
        car_transmission = input.nextLine();
        System.out.print("Showroom name: ");
        showroom_name = input.nextLine();
        total_cars_in_stock++;
    }
}
