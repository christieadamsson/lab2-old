package Lab1;

import Lab1.Car;

import javax.crypto.Mac;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CarTransport extends Truck implements Adds<Car> {
    private UpAndDownRamp ramp;
    private boolean rampDown;
    private static final int MaxCars = 6;
    private Deque<Car> loadedCars = new ArrayDeque<>();


    public CarTransport(){
        super(200,0,Color.BLACK,"Car Transport");
    }


    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lowerRamp();
        }
    }

    public void raiseRamp(){
        if(getCurrentSpeed() == 0) {
            ramp.raiseRamp();
        }
    }

    private boolean closeEnough(Car car){
        double dx = (car.getX() - this.getX());
        double dy = (car.getY()- this.getY());

        double distance = Math.sqrt((dx*dx) + (dy*dy));
        return distance < 1;
    }


    public void removeCar(){
            if(getCurrentSpeed() == 0 && ramp.isRampDown() && !loadedCars.isEmpty()){
                Car removedCar = loadedCars.pop();
                removedCar.setPosition(this.getX(), this.getY()-1);
            }
    }

    @Override
    public void add(Car car) {
        if (getCurrentSpeed() == 0 && loadedCars.size() < MaxCars && closeEnough(car) && ramp.isRampDown()) {
            car.stopEngine();
            loadedCars.push(car);
            car.setPosition(this.getX(), this.getY());
        }
    }

    @Override
    protected boolean isSafeForDriving() {
        return ramp.isSafeForDriving();
    }

    @Override
    protected void incrementSpeed(double amount) {
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if (newSpeed > getCurrentSpeed()) {
            setCurrentSpeed(newSpeed);
        }
    }
    @Override
    protected void decrementSpeed(double amount) {
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (newSpeed < getCurrentSpeed()) {
            setCurrentSpeed(newSpeed);
        }
    }

    @Override
    protected double speedFactor() {
        return 0.01*getEnginePower();
    }

    @Override
    public void move(){
        if (isSafeForDriving()) {
            super.move();
            for (Car car : loadedCars) {
                car.setPosition(this.getX(), this.getY());
            }
        }
    }

}
