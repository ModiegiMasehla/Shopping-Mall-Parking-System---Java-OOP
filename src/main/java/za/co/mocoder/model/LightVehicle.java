package za.co.mocoder.model;

/** Abstract category for vehicles using standard mall parking bays. */
public abstract class LightVehicle extends Vehicle {
    private final String parkingTag;
    private boolean active;

    public LightVehicle(String licensePlate, String ownerName, String color, String province, String parkingTag) {
        super(licensePlate, ownerName, color, province);
        this.parkingTag = parkingTag;
        this.active = true;
    }

    public String getParkingTag() { return parkingTag; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public abstract double getHourlyFee();
    public abstract String getParkingZone();

    /** Calculates the fee for a positive number of parking hours. */
    public double calculateParkingFee(int hours) {
        if (hours < 1) throw new IllegalArgumentException("Parking hours must be at least 1");
        return getHourlyFee() * hours;
    }

    @Override
    public String toString() {
        return super.toString() + ", Parking tag: " + parkingTag + ", Active: " + active;
    }
}
