package za.co.mocoder;
import za.co.mocoder.model.*;
import za.co.mocoder.service.ShoppingMallParking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ShoppingMallParkingTest {
    private ShoppingMallParking parking;
    private Motorcycle motorcycle; private Car car; private Minibus minibus; private Truck truck; private Bus bus;
    @BeforeEach void setUp() {
        parking=new ShoppingMallParking("Maplewood Shopping Mall");
        motorcycle=new Motorcycle("MCA 123 GP","Lebo Molefe","Black","Gauteng","TAG001");
        car=new Car("CAR 456 GP","Ayesha Khan","Silver","Gauteng","TAG002");
        minibus=new Minibus("MBX 789 GP","Thabo Nkosi","White","Gauteng","TAG003","City Shuttle");
        truck=new Truck("TRK 012 GP","Mandla Dube","Blue","Gauteng","OP001",4,"Groceries","DEL-2026");
        bus=new Bus("BUS 345 GP","Mall Shuttle","Green","Gauteng","OP002",2,"Route A");
    }
    @Test void mallNameIsReturned() { assertEquals("Maplewood Shopping Mall",parking.getMallName()); }
    @Test void addAndGetLightVehicles() { parking.addLightVehicle(motorcycle); assertEquals(1,parking.getLightVehicles().size()); }
    @Test void lightVehicleListCannotBeModifiedDirectly() {
        parking.addLightVehicle(motorcycle);
        assertThrows(UnsupportedOperationException.class,()->parking.getLightVehicles().add(car));
    }
    @Test void findLightVehicleByTagWorksAndUnknownReturnsNull() {
        parking.addLightVehicle(motorcycle); assertEquals("Lebo Molefe",parking.findLightVehicle("TAG001").getOwnerName());
        assertNull(parking.findLightVehicle("NOPE"));
    }
    @Test void removeLightVehicleWorksAndUnknownTagThrows() {
        parking.addLightVehicle(motorcycle); parking.addLightVehicle(car); parking.removeLightVehicle("TAG001");
        assertEquals(1,parking.getLightVehicles().size());
        assertThrows(IllegalArgumentException.class,()->parking.removeLightVehicle("NOPE"));
    }
    @Test void activeVehiclesOnlyIncludesActiveOnes() {
        parking.addLightVehicle(motorcycle); parking.addLightVehicle(car); car.setActive(false);
        assertEquals(1,parking.getActiveLightVehicles().size());
    }
    @Test void addAndFindHeavyVehicles() {
        parking.addHeavyVehicle(truck); parking.addHeavyVehicle(bus);
        assertEquals(2,parking.getHeavyVehicles().size()); assertEquals("Mall Shuttle",parking.findHeavyVehicle("OP002").getOwnerName());
        assertNull(parking.findHeavyVehicle("UNKNOWN"));
    }
    @Test void heavyVehicleListCannotBeModifiedDirectly() {
        parking.addHeavyVehicle(truck); assertThrows(UnsupportedOperationException.class,()->parking.getHeavyVehicles().add(bus));
    }
    @Test void lightRevenueUsesHourlyFeesAndActiveVehiclesOnly() {
        parking.addLightVehicle(motorcycle); parking.addLightVehicle(car); parking.addLightVehicle(minibus);
        assertEquals((8+15+22)*2,parking.getLightVehicleRevenue(2),0.001);
        car.setActive(false); assertEquals((8+22)*2,parking.getLightVehicleRevenue(2),0.001);
    }
    @Test void heavyRevenueSumsVehicleRates() {
        parking.addHeavyVehicle(truck); parking.addHeavyVehicle(bus);
        assertEquals((55+40)*2,parking.getHeavyVehicleRevenue(2),0.001);
    }
    @Test void revenuesAreZeroWhenNoVehiclesAreRegistered() {
        assertEquals(0,parking.getLightVehicleRevenue(2),0.001); assertEquals(0,parking.getHeavyVehicleRevenue(2),0.001);
    }
    @Test void printingVehicleClassesDoesNotThrow() {
        parking.addLightVehicle(motorcycle); parking.addHeavyVehicle(truck);
        assertDoesNotThrow(()->parking.printAllVehicleClasses());
    }
}
