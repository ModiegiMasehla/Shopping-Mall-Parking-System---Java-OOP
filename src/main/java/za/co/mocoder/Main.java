package za.co.mocoder;

import za.co.mocoder.model.*;
import za.co.mocoder.service.ShoppingMallParking;

public class Main {
    public static void main(String[] args) {
        ShoppingMallParking parking = new ShoppingMallParking("Maplewood Shopping Mall");
        parking.addLightVehicle(new Motorcycle("MCA 123 GP", "Lebo Molefe", "Black", "Gauteng", "TAG001"));
        parking.addLightVehicle(new Car("CAR 456 GP", "Ayesha Khan", "Silver", "Gauteng", "TAG002"));
        parking.addLightVehicle(new Minibus("MBX 789 GP", "Thabo Nkosi", "White", "Gauteng", "TAG003", "City Shuttle"));
        parking.addHeavyVehicle(new Truck("TRK 012 GP", "Mandla Dube", "Blue", "Gauteng", "OP001", 4, "Groceries", "DEL-2026"));
        parking.addHeavyVehicle(new Bus("BUS 345 GP", "Mall Shuttle", "Green", "Gauteng", "OP002", 2, "Route A"));
        System.out.println("=== " + parking.getMallName() + " ===");
        parking.printAllVehicleClasses();
        System.out.println("Light-vehicle revenue for 3 hours: R" + parking.getLightVehicleRevenue(3));
        System.out.println("Heavy-vehicle revenue for 3 hours: R" + parking.getHeavyVehicleRevenue(3));
    }
}
