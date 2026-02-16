package Lab1;

import java.awt.*;

abstract public class Truck extends Vehicle{

    public Truck(double power, double speed, Color clr, String name) {
        super(power, speed, clr, name);

    }

    protected abstract boolean isSafeForDriving();

    @Override
    public void gas(double amount) {
        if (!isSafeForDriving()) return;
        super.gas(amount);
    }





}
