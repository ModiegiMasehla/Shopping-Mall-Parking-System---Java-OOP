package za.co.mocoder.model;
public class Minibus extends LightVehicle {
    public static final double HOURLY_FEE = 22.00;
    private final String operatorName;
    public Minibus(String plate, String owner, String color, String province, String parkingTag, String operatorName) {
        super(plate, owner, color, province, parkingTag); this.operatorName = operatorName;
    }
    public String getOperatorName() { return operatorName; }
    @Override public double getHourlyFee() { return HOURLY_FEE; }
    @Override public String getParkingZone() { return "Passenger pick-up zone"; }
    @Override public String getVehicleClass() { return "Minibus"; }
    @Override public String toString() { return super.toString() + ", Operator: " + operatorName; }
}
