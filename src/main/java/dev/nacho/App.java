package dev.nacho;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        TollStation toll = new TollStation("Zombie Station", "Raccoon City", 0);
        toll.calculateToll(new Car("2093-OMW"));
        toll.calculateToll(new Motorbike("9980-BKF"));
        toll.calculateToll(new Truck("2468-NGL", 2));
        System.out.println(toll.getVehicles());
        System.out.println(toll.getTollCollected());
    }
}
