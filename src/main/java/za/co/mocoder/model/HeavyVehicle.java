package za.co.mocoder.model;

/** Abstract category for service and commercial vehicles using designated bays. */
public abstract class HeavyVehicle extends Vehicle {
    private final String operatorId;
    private int axleCount;

    public HeavyVehicle(String licensePlate, String ownerName, String color, String province, String operatorId, int axleCount) {
        super(licensePlate, ownerName, color, province);
        if (axleCount < 2) throw new IllegalArgumentException("Axle count must be at least 2");
        this.operatorId = operatorId;
        this.axleCount = axleCount;
    }

    public String getOperatorId() { return operatorId; }
    public int getAxleCount() { return axleCount; }
    public void updateAxleCount(int axleCount) {
        if (axleCount < 2) throw new IllegalArgumentException("Axle count must be at least 2");
        this.axleCount = axleCount;
    }
    public abstract double getHourlyRate();
    public abstract String getParkingPurpose();
    public double calculateParkingFee(int hours) {
        if (hours < 1) throw new IllegalArgumentException("Parking hours must be at least 1");
        return getHourlyRate() * hours;
    }
    @Override
    public String toString() {
        return super.toString() + ", Operator ID: " + operatorId + ", Axles: " + axleCount;
    }
}
