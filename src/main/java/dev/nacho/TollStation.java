package dev.nacho;

public class TollStation {
    private String name;
    private String city;
    private int tollCollected;

    public TollStation(String name, String city, int tollCollected) {
        this.name = name;
        this.city = city;
        this.tollCollected = tollCollected;
    }

    public void calculateToll(Vehicle vehicle) {
        int toll = switch(vehicle) {
            case Car c-> 100;
            case Motorbike m-> 50;
            case Truck t-> t.getAxis()*50;
            default-> throw new IllegalArgumentException("Vehicle not supported");
        };

        tollCollected = tollCollected + toll ;
    }


    
}
