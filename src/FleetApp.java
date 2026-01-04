import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner user = new Scanner(System.in);
    private boolean running = true;
    public FleetApp() {
        vehicles.add(new Car("Audi", 2019, 100000, 4));
    }
    public void run() {
        while (running) {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");

            int choice = user.nextInt();
            user.nextLine();

            switch (choice) {
                case 1:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles in the fleet");
                    } else {
                        for (Vehicle v : vehicles) {
                            System.out.println(v);
                        }
                    }

                    break;

                case 2:
                    System.out.print("Model: ");
                    String carModel = user.nextLine();

                    System.out.print("Year: ");
                    int carYear = user.nextInt();

                    System.out.print("Base price: ");
                    double carPrice = user.nextDouble();

                    System.out.print("Number of doors: ");
                    int doors = user.nextInt();
                    user.nextLine();
                    vehicles.add(new Car(carModel, carYear, carPrice, doors));
                    System.out.println("Car added");
                    break;

                case 3:
                    System.out.print("Model: ");
                    String busModel = user.nextLine();

                    System.out.print("Year: ");
                    int busYear = user.nextInt();

                    System.out.print("Base price: ");
                    double busPrice = user.nextDouble();

                    System.out.print("Passenger capacity: ");
                    int capacity = user.nextInt();

                    vehicles.add(new Bus(busModel, busYear, busPrice, capacity));
                    System.out.println("Bus added");
                    break;

                case 4:
                    double total = 0;
                    for (Vehicle v : vehicles) {
                        total += v.calculateInsuranceFee();
                    }
                    System.out.println("Total insurance fee: " + total);
                    break;

                case 5:
                    System.out.print("Enter current year: ");
                    int currentYear = user.nextInt();

                    System.out.print("Enter N years: ");
                    int n = user.nextInt();


                    for (Vehicle v : vehicles) {
                        if (v.getAge(currentYear) > n) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 6:
                    for (Vehicle v : vehicles) {
                        if (v instanceof Servicable) {
                            ((Servicable) v).performService();
                        }
                    }
                    break;

                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
