package Lab1;

import java.awt.*;

public abstract class Car extends Vehicle {
    private final int nrDoors; // Number of doors on the car

    public Car(double power, double speed, Color clr, String name, int doors) {
        super(power, speed, clr, name);
        this.nrDoors = doors;
    }

    public int getNrDoors() {
        return nrDoors;
    }
}
