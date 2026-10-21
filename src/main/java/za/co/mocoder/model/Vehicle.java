package za.co.mocoder.model;

/** Abstract parent class for every vehicle using the shopping mall parking facility. */
public abstract class Vehicle {
    private final String licensePlate;
    private final String ownerName;
    private String color;
    private String province;

    public Vehicle(String licensePlate, String ownerName, String color, String province) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.color = color;
        this.province = province;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getOwnerName() { return ownerName; }
    public String getColor() { return color; }
    public void updateColor(String color) { this.color = color; }
    public String getProvince() { return province; }
    public void updateProvince(String province) { this.province = province; }
    public String getFullId() { return ownerName + " [" + licensePlate + "]"; }
    public abstract String getVehicleClass();

    @Override
    public String toString() {
        return "Owner: " + ownerName + ", License plate: " + licensePlate
                + ", Colour: " + color + ", Province: " + province;
    }
}
