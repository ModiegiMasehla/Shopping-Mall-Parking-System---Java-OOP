package za.co.mocoder.service;

import za.co.mocoder.model.*;
import java.util.*;

/** Manages registered vehicles and calculates parking revenue for the mall. */
public class ShoppingMallParking {
    private final String mallName;
    private final List<LightVehicle> lightVehicles = new ArrayList<>();
    private final List<HeavyVehicle> heavyVehicles = new ArrayList<>();

    public ShoppingMallParking(String mallName) { this.mallName = mallName; }
    public String getMallName() { return mallName; }

    public void addLightVehicle(LightVehicle vehicle) { lightVehicles.add(Objects.requireNonNull(vehicle)); }
    public void addHeavyVehicle(HeavyVehicle vehicle) { heavyVehicles.add(Objects.requireNonNull(vehicle)); }

    public List<LightVehicle> getLightVehicles() { return Collections.unmodifiableList(lightVehicles); }
    public List<HeavyVehicle> getHeavyVehicles() { return Collections.unmodifiableList(heavyVehicles); }

    public LightVehicle findLightVehicle(String tag) {
        for (LightVehicle vehicle : lightVehicles) if (vehicle.getParkingTag().equals(tag)) return vehicle;
        return null;
    }
    public HeavyVehicle findHeavyVehicle(String operatorId) {
        for (HeavyVehicle vehicle : heavyVehicles) if (vehicle.getOperatorId().equals(operatorId)) return vehicle;
        return null;
    }
    public void removeLightVehicle(String tag) {
        Iterator<LightVehicle> iterator = lightVehicles.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getParkingTag().equals(tag)) { iterator.remove(); return; }
        }
        throw new IllegalArgumentException("Light vehicle not found: " + tag);
    }
    public List<LightVehicle> getActiveLightVehicles() {
        List<LightVehicle> active = new ArrayList<>();
        for (LightVehicle vehicle : lightVehicles) if (vehicle.isActive()) active.add(vehicle);
        return Collections.unmodifiableList(active);
    }
    public double getLightVehicleRevenue(int hours) {
        double total = 0;
        for (LightVehicle vehicle : lightVehicles) if (vehicle.isActive()) total += vehicle.calculateParkingFee(hours);
        return total;
    }
    public double getHeavyVehicleRevenue(int hours) {
        double total = 0;
        for (HeavyVehicle vehicle : heavyVehicles) total += vehicle.calculateParkingFee(hours);
        return total;
    }
    public void printAllVehicleClasses() {
        for (LightVehicle vehicle : lightVehicles) System.out.println(vehicle.getVehicleClass());
        for (HeavyVehicle vehicle : heavyVehicles) System.out.println(vehicle.getVehicleClass());
    }
}
