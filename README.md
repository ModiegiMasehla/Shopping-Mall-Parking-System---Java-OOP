# Shopping Mall Parking Fees — Java OOP Summative Assessment 

## Overview


## Assessment structure
| Component | Suggested weighting | Suggested time |
|---|---:|---:|
| Implementation and unit tests | 50% | 2 hours |
| Comprehensive theory/design questions | 50% | 1 hour |

## Class hierarchy
```text
Vehicle (abstract)
├── LightVehicle (abstract)
│   ├── Motorcycle
│   ├── Car
│   └── Minibus
└── HeavyVehicle (abstract)
    ├── Truck
    └── Bus
```

## Business rules
- Every vehicle has a licence plate, owner, colour, and province.
- Licence plate and owner name are immutable after construction.
- Light vehicles have a parking tag, active status, hourly fee, and parking zone.
- Heavy vehicles have an operator ID and at least two axles.
- Motorcycle: R8 per hour.
- Car: R15 per hour, with an optional 10% loyalty discount.
- Minibus: R22 per hour.
- Truck: R35 per hour plus R5 per axle.
- Shuttle bus: fixed R40 per hour, independent of axle count.
- Parking duration must be at least one hour.
- Inactive light vehicles are excluded from light-vehicle revenue.
- The parking service returns unmodifiable views of its registered vehicle lists.

These are fictional assessment rates, not real mall prices.

## Implementation flow and requirements

### Step 1 — `Vehicle` (abstract)
File: `src/main/java/za/co/mocoder/model/Vehicle.java`
- Keep fields private.
- Make `licensePlate` and `ownerName` final.
- Provide getters, mutable colour/province update methods, `getFullId()`, `toString()`, and abstract `getVehicleClass()`.

### Step 2 — `LightVehicle` (abstract)
File: `model/LightVehicle.java`
- Extend `Vehicle`.
- Store immutable `parkingTag` and mutable `active` state (default `true`).
- Define abstract hourly-fee and parking-zone methods.
- Calculate a fee from hourly rate and number of hours; reject invalid duration.

### Step 3 — `HeavyVehicle` (abstract)
File: `model/HeavyVehicle.java`
- Extend `Vehicle`.
- Store immutable `operatorId` and mutable axle count.
- Reject axle counts below two.
- Define abstract hourly rate and parking-purpose methods.

### Step 4 — Concrete vehicle classes
Files: `Motorcycle.java`, `Car.java`, `Minibus.java`, `Truck.java`, and `Bus.java`.
- Each class supplies its own fee/rate and class description.
- `Car` supports an optional loyalty discount.
- `Truck` calculates its rate using axle count and stores delivery details.
- `Bus` has a fixed hourly rate and an editable route name.

### Step 5 — `ShoppingMallParking` service
File: `src/main/java/za/co/mocoder/service/ShoppingMallParking.java`
- Register, find, and remove vehicles.
- Provide read-only list views.
- Return active light vehicles.
- Calculate light-vehicle and heavy-vehicle revenue for a specified duration.
- Print vehicle class descriptions.

### Step 6 — Run and inspect tests
```bash
mvn clean test
mvn package
```
The tests cover constructor values, getters/update methods, inheritance, fee calculations, invalid inputs, collections, revenue totals, and class-specific behaviour. Do not edit tests merely to make a failing implementation pass.

## Project structure
```text
shopping-mall-parking-assessment/
├── pom.xml
├── README.md
├── answers.txt
└── src/
    ├── main/java/za/co/mocoder/
    │   ├── Main.java
    │   ├── model/
    │   └── service/ShoppingMallParking.java
    └── test/java/za/co/mocoder/
        ├── VehicleTest.java
        ├── LightVehicleTest.java
        ├── HeavyVehicleTest.java
        └── ShoppingMallParkingTest.java
```

## Theory and design questions
1. Explain encapsulation, inheritance, abstraction, and polymorphism using examples from this project.
2. Why are `Vehicle`, `LightVehicle`, and `HeavyVehicle` abstract? What would be lost if every class duplicated all vehicle fields?
3. Explain why `licensePlate` and `ownerName` are final, while `color` can be updated.
4. Explain how the truck and bus demonstrate polymorphism when their hourly rates are calculated.
5. Why does the parking service return unmodifiable lists? Give one benefit and one limitation.
6. Explain the purpose of unit testing and test-driven development. How is a test different from successful compilation?
7. A mall asks for electric-vehicle bays and a discounted rate. Describe the classes or methods you would add or change, and explain how you would test them.
8. A developer suggests placing all code in `Main`. Explain two problems with that design and how the current structure addresses them.
9. Identify one invalid-input edge case and explain how this solution handles it.
10. Describe a suitable high-level design for a parking system that must support different vehicle types and new pricing rules in future.

## Running the application
Run `za.co.mocoder.Main` from your IDE, or use:
```bash
mvn clean test
mvn package
java -cp target/shopping-mall-parking-1.0-SNAPSHOT.jar za.co.mocoder.Main
```
The last command may require dependency/classpath configuration in a standard Maven project; running `Main` from IntelliJ is the simplest option.
