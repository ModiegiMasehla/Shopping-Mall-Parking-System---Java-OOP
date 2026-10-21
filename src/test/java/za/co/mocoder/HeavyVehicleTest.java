package za.co.mocoder;
import za.co.mocoder.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class HeavyVehicleTest {
    private final Truck truck=new Truck("TRK 012 GP","Mandla Dube","Blue","Gauteng","OP001",4,"Groceries","DEL-2026");
    private final Bus bus=new Bus("BUS 345 GP","Mall Shuttle","Green","Gauteng","OP002",2,"Route A");
    @Test void operatorAndAxleDetailsAreStored() {
        assertEquals("OP001",truck.getOperatorId()); assertEquals(4,truck.getAxleCount());
        truck.updateAxleCount(6); assertEquals(6,truck.getAxleCount());
        assertThrows(IllegalArgumentException.class,()->truck.updateAxleCount(1));
    }
    @Test void truckHourlyRateIncludesAxleCharge() {
        assertEquals(55.0,truck.getHourlyRate(),0.001); truck.updateAxleCount(6);
        assertEquals(65.0,truck.getHourlyRate(),0.001);
    }
    @Test void truckDeliveryDetailsCanBeReadAndUpdated() {
        assertEquals("Groceries",truck.getDeliveryType()); truck.updateDeliveryType("Furniture");
        assertEquals("Furniture",truck.getDeliveryType()); assertEquals("DEL-2026",truck.getDeliveryPermit());
        assertEquals("Delivery Truck (Furniture)",truck.getVehicleClass());
    }
    @Test void busHasFixedRateAndEditableRoute() {
        assertEquals(Bus.HOURLY_RATE,bus.getHourlyRate(),0.001); bus.updateAxleCount(6);
        assertEquals(Bus.HOURLY_RATE,bus.getHourlyRate(),0.001);
        bus.updateRouteName("Route B"); assertEquals("Shuttle Bus (Route B)",bus.getVehicleClass());
        assertEquals("Passenger transport",bus.getParkingPurpose());
    }
    @Test void heavyVehicleFeeMultipliesByHours() { assertEquals(165.0,truck.calculateParkingFee(3),0.001); }
    @Test void heavyVehicleRejectsInvalidAxlesAndDuration() {
        assertThrows(IllegalArgumentException.class,()->new Bus("BUS 345 GP","Mall Shuttle","Green","Gauteng","OP002",1,"Route A"));
        assertThrows(IllegalArgumentException.class,()->bus.calculateParkingFee(-1));
    }
}
