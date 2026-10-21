package za.co.mocoder;
import za.co.mocoder.model.Motorcycle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class VehicleTest {
    @Test void constructorAndGettersWork() {
        Motorcycle v = new Motorcycle("MCA 123 GP","Lebo Molefe","Black","Gauteng","TAG001");
        assertEquals("MCA 123 GP",v.getLicensePlate()); assertEquals("Lebo Molefe",v.getOwnerName());
        assertEquals("Black",v.getColor()); assertEquals("Gauteng",v.getProvince());
    }
    @Test void fullIdCombinesOwnerAndPlate() {
        assertEquals("Lebo Molefe [MCA 123 GP]",new Motorcycle("MCA 123 GP","Lebo Molefe","Black","Gauteng","TAG001").getFullId());
    }
    @Test void mutableFieldsCanBeUpdated() {
        Motorcycle v=new Motorcycle("MCA 123 GP","Lebo Molefe","Black","Gauteng","TAG001");
        v.updateColor("Red"); v.updateProvince("Limpopo");
        assertEquals("Red",v.getColor()); assertEquals("Limpopo",v.getProvince());
    }
    @Test void concreteVehicleDefinesClassAndToString() {
        Motorcycle v=new Motorcycle("MCA 123 GP","Lebo Molefe","Black","Gauteng","TAG001");
        assertEquals("Motorcycle",v.getVehicleClass()); assertTrue(v.toString().contains("Lebo Molefe"));
        assertTrue(v.toString().contains("MCA 123 GP"));
    }
}
