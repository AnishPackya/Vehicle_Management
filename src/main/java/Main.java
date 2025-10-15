import vehicle.Vehicle;
import service.serviceManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        serviceManager manager = new serviceManager();

        while (true) {
            System.out.println("\n===== VEHICLE SERVICE MANAGEMENT =====");
            System.out.println("1. Add Service Record");
            System.out.println("2. Delete Record (by RegNo)");
            System.out.println("3. Display All Records");
            System.out.println("4. Display Vehicles Needing Service (by mileage)");
            System.out.println("5. Update Record (service type & mileage)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter RegNo: ");
                    String reg = sc.nextLine();
                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter Mileage (km): ");
                    int mileage = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Service Type: ");
                    String serviceType = sc.nextLine();
                    manager.addRecord(new Vehicle(reg, owner, model, mileage, serviceType));
                    break;
                case 2:
                    System.out.print("Enter RegNo to delete: ");
                    String delReg = sc.nextLine();
                    manager.deleteRecord(delReg);
                    break;
                case 3:
                    manager.displayAll();
                    break;
                case 4:
                    System.out.print("Enter mileage threshold: ");
                    int threshold = Integer.parseInt(sc.nextLine());
                    manager.displayDueByMileage(threshold);
                    break;
                case 5:
                    System.out.print("Enter RegNo to update: ");
                    String updReg = sc.nextLine();
                    System.out.print("Enter new Service Type: ");
                    String newService = sc.nextLine();
                    System.out.print("Enter new Mileage: ");
                    int newMileage = Integer.parseInt(sc.nextLine());
                    manager.updateRecord(updReg, newService, newMileage);
                    break;
                case 6:
                    System.out.println(" Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("  Invalid choice. Try again.");
            }
        }
    }
}
