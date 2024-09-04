package dev.nacho;

public class Truck extends Vehicle {
    private int axis;

    public Truck(String plate, int axis) {
        super(plate);
        this.axis = axis;
    }

    public int getAxis() {
        return axis;
    }

    


}
