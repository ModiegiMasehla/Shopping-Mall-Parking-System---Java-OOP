package za.co.mocoder.model;
public class Car extends LightVehicle {
    public static final double HOURLY_FEE = 15.00;
    private boolean loyaltyDiscount;
    public Car(String plate, String owner, String color, String province, String parkingTag) {
        super(plate, owner, color, province, parkingTag); this.loyaltyDiscount = false;
    }
    public boolean isLoyaltyDiscount() { return loyaltyDiscount; }
    public void applyLoyaltyDiscount(boolean applied) { loyaltyDiscount = applied; }
    @Override public double getHourlyFee() { return loyaltyDiscount ? HOURLY_FEE * 0.9 : HOURLY_FEE; }
    @Override public String getParkingZone() { return "Standard parking"; }
    @Override public String getVehicleClass() { return "Private Car"; }
    @Override public String toString() { return super.toString() + ", Class: Private Car, Loyalty discount: " + loyaltyDiscount; }
}
