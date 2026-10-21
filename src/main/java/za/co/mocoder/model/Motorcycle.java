package za.co.mocoder.model;
public class Motorcycle extends LightVehicle {
    public static final double HOURLY_FEE = 8.00;
    public Motorcycle(String plate, String owner, String color, String province, String parkingTag) {
        super(plate, owner, color, province, parkingTag);
    }
    @Override public double getHourlyFee() { return HOURLY_FEE; }
    @Override public String getParkingZone() { return "Motorcycle bays"; }
    @Override public String getVehicleClass() { return "Motorcycle"; }
    @Override public String toString() { return super.toString() + ", Class: Motorcycle"; }
}
