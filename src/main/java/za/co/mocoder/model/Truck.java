package za.co.mocoder.model;
public class Truck extends HeavyVehicle {
    public static final double BASE_HOURLY_RATE = 35.00;
    public static final double RATE_PER_AXLE = 5.00;
    private String deliveryType;
    private final String deliveryPermit;
    public Truck(String plate, String owner, String color, String province, String operatorId, int axles, String deliveryType, String permit) {
        super(plate, owner, color, province, operatorId, axles); this.deliveryType = deliveryType; this.deliveryPermit = permit;
    }
    public String getDeliveryType() { return deliveryType; }
    public void updateDeliveryType(String deliveryType) { this.deliveryType = deliveryType; }
    public String getDeliveryPermit() { return deliveryPermit; }
    @Override public double getHourlyRate() { return BASE_HOURLY_RATE + getAxleCount() * RATE_PER_AXLE; }
    @Override public String getParkingPurpose() { return "Goods delivery"; }
    @Override public String getVehicleClass() { return "Delivery Truck (" + deliveryType + ")"; }
    @Override public String toString() { return super.toString() + ", Delivery type: " + deliveryType + ", Permit: " + deliveryPermit; }
}
