package service;

import vehicle.Vehicle;
import java.util.*;

public class serviceManager {
    private List<Vehicle> records = new ArrayList<>();

    // Add new vehicle service record (reject duplicate regNo)
    public void addRecord(Vehicle v) {
        for (Vehicle r : records) {
            if (r.getRegNo().equalsIgnoreCase(v.getRegNo())) {
                System.out.println("  Error: A record with this registration number already exists.");
                return;
            }
        }
        records.add(v);
        System.out.println("  Vehicle service record added.");
    }

    // Delete by registration number
    public void deleteRecord(String regNo) {
        boolean removed = records.removeIf(r -> r.getRegNo().equalsIgnoreCase(regNo));
        if (removed) System.out.println("  Record deleted.");
        else System.out.println("  No record found with RegNo: " + regNo);
    }

    // Update service info (service type and mileage)
    public void updateRecord(String regNo, String newServiceType, int newMileage) {
        for (Vehicle r : records) {
            if (r.getRegNo().equalsIgnoreCase(regNo)) {
                r.setServiceType(newServiceType);
                r.setMileage(newMileage);
                System.out.println("  Record updated.");
                return;
            }
        }
        System.out.println("  No record found with RegNo: " + regNo);
    }

    // Display all records
    public void displayAll() {
        if (records.isEmpty()) {
            System.out.println("  No vehicle records available.");
            return;
        }
        System.out.println("\n--- All Vehicle Service Records ---");
        for (Vehicle v : records) v.displayInfo();
    }

    // Display vehicles needing service by mileage threshold
    public void displayDueByMileage(int threshold) {
        List<Vehicle> due = new ArrayList<>();
        for (Vehicle v : records) {
            if (v.getMileage() >= threshold) due.add(v);
        }
        if (due.isEmpty()) {
            System.out.println("  No vehicles with mileage >= " + threshold);
            return;
        }
        Collections.sort(due);
        System.out.println("\n--- Vehicles needing service (mileage >= " + threshold + ") ---");
        for (Vehicle v : due) v.displayInfo();
    }
}
