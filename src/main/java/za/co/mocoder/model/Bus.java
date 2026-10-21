package za.co.mocoder.model;
public class Bus extends HeavyVehicle {
    public static final double HOURLY_RATE = 40.00;
    private String routeName;
    public Bus(String plate, String owner, String color, String province, String operatorId, int axles, String routeName) {
        super(plate, owner, color, province, operatorId, axles); this.routeName = routeName;
    }
    public String getRouteName() { return routeName; }
    public void updateRouteName(String routeName) { this.routeName = routeName; }
    @Override public double getHourlyRate() { return HOURLY_RATE; }
    @Override public String getParkingPurpose() { return "Passenger transport"; }
    @Override public String getVehicleClass() { return "Shuttle Bus (" + routeName + ")"; }
    @Override public String toString() { return super.toString() + ", Route: " + routeName; }
}
