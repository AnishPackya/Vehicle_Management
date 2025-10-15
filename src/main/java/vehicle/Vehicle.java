package vehicle;

public class Vehicle implements Comparable<Vehicle> {
    private String regNo;
    private String ownerName;
    private String model;
    private int mileage; // in kilometres
    private String serviceType; // e.g. "Oil Change", "Full Service"

    public Vehicle(String regNo, String ownerName, String model, int mileage, String serviceType) {
        this.regNo = regNo;
        this.ownerName = ownerName;
        this.model = model;
        this.mileage = mileage;
        this.serviceType = serviceType;
    }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public void displayInfo() {
        System.out.println("RegNo: " + regNo +
                " | Owner: " + ownerName +
                " | Model: " + model +
                " | Mileage: " + mileage +
                " | Service: " + serviceType);
    }

    @Override
    public int compareTo(Vehicle other) {
        return this.regNo.compareToIgnoreCase(other.regNo);
    }
}
