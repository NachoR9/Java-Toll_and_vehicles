package dev.nacho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TollStationTest {

    private TollStation tollStation;

    @BeforeEach
    void setUp() {
        tollStation = new TollStation("Zombie Station", "Raccoon City", 0);
    }

    @Test
    void testCalculateTollForCar() {
        Car car = new Car("RTE464");
        tollStation.calculateToll(car);
        assertEquals(100, tollStation.getTollCollected());
        List<Vehicle> vehicles = tollStation.getVehicles();
        assertEquals(1, vehicles.size());
        assertTrue(vehicles.get(0) instanceof Car);
    }

    @Test
    void testCalculateTollForMotorbike() {

        Motorbike motorbike = new Motorbike("RLY237");
        tollStation.calculateToll(motorbike);
        assertEquals(50, tollStation.getTollCollected());
        List<Vehicle> vehicles = tollStation.getVehicles();
        assertEquals(1, vehicles.size());
        assertTrue(vehicles.get(0) instanceof Motorbike);
    }

    @Test
    void testCalculateTollForTruck() {

        Truck truck = new Truck("TRK791", 3);

        tollStation.calculateToll(truck);

        assertEquals(150, tollStation.getTollCollected());

        List<Vehicle> vehicles = tollStation.getVehicles();
        assertEquals(1, vehicles.size());
        assertTrue(vehicles.get(0) instanceof Truck);
    }

    @Test
    void testCalculateTollForMultipleVehicles() {

        Car car = new Car("BRR100");
        Motorbike motorbike = new Motorbike("BRB320");
        Truck truck = new Truck("CRK800", 4);

        tollStation.calculateToll(car);
        tollStation.calculateToll(motorbike);
        tollStation.calculateToll(truck);

        assertEquals(100 + 50 + (4 * 50), tollStation.getTollCollected());

        List<Vehicle> vehicles = tollStation.getVehicles();
        assertEquals(3, vehicles.size());
    }

    @Test
    void testCalculateTollForUnsupportedVehicle() {

        Vehicle unsupportedVehicle = new Vehicle("NOP000") {
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tollStation.calculateToll(unsupportedVehicle);
        });
        assertEquals("Vehicle not supported", exception.getMessage());
        assertEquals(0, tollStation.getTollCollected());
    }
}
