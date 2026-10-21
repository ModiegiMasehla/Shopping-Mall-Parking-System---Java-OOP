package za.co.mocoder;
import za.co.mocoder.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LightVehicleTest {
    private final Motorcycle motorcycle=new Motorcycle("MCA 123 GP","Lebo Molefe","Black","Gauteng","TAG001");
    private final Car car=new Car("CAR 456 GP","Ayesha Khan","Silver","Gauteng","TAG002");
    private final Minibus minibus=new Minibus("MBX 789 GP","Thabo Nkosi","White","Gauteng","TAG003","City Shuttle");
    @Test void lightVehiclesStartActiveAndCanBeDeactivated() {
        assertTrue(motorcycle.isActive()); assertTrue(car.isActive()); car.setActive(false); assertFalse(car.isActive());
    }
    @Test void parkingTagIsStored() { assertEquals("TAG001",motorcycle.getParkingTag()); }
    @Test void motorcycleFeeZoneAndClassAreCorrect() {
        assertEquals(8.0,motorcycle.getHourlyFee(),0.001); assertEquals("Motorcycle bays",motorcycle.getParkingZone());
        assertEquals("Motorcycle",motorcycle.getVehicleClass());
    }
    @Test void carFeeAndLoyaltyDiscountWork() {
        assertEquals(Car.HOURLY_FEE,car.getHourlyFee(),0.001); assertFalse(car.isLoyaltyDiscount());
        car.applyLoyaltyDiscount(true); assertTrue(car.isLoyaltyDiscount()); assertEquals(13.5,car.getHourlyFee(),0.001);
        assertEquals("Private Car",car.getVehicleClass());
    }
    @Test void minibusHasItsOwnFeeAndOperator() {
        assertEquals(22.0,minibus.getHourlyFee(),0.001); assertEquals("City Shuttle",minibus.getOperatorName());
        assertEquals("Passenger pick-up zone",minibus.getParkingZone());
    }
    @Test void feeMultipliesByHoursAndRejectsInvalidDuration() {
        assertEquals(24.0,motorcycle.calculateParkingFee(3),0.001);
        assertThrows(IllegalArgumentException.class,()->motorcycle.calculateParkingFee(0));
    }
    @Test void feesDifferAcrossVehicleTypes() {
        assertNotEquals(motorcycle.getHourlyFee(),car.getHourlyFee());
        assertNotEquals(car.getHourlyFee(),minibus.getHourlyFee());
    }
}
