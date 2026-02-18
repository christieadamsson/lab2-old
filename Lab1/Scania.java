package Lab1;

import java.awt.*;

public class Scania extends Truck {
    private AngleRamp ramp;

    public Scania() {
    super(200,0,Color.blue,"Scania");

}
    public double getRampAngle() {
        return ramp.getRampAngle();
    }

    public void raiseRampAngle(double angle) {
        if(getCurrentSpeed() == 0){
            ramp.raiseRampAngle(angle);
        }
    }

    public void lowerRampAngle(double angle) {
        if(getCurrentSpeed() ==0) {
            ramp.lowerRampAngle(angle);
            }
    }

    public void raiseRamp(){
        if (getCurrentSpeed() == 0){
            ramp.raiseRamp();
        }
    }

    public void lowerRamp(){
        if (getCurrentSpeed() == 0){
            ramp.lowerRamp();
        }
    }

    @Override
    protected double speedFactor() {
        return 0.01*getEnginePower();
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
    protected boolean isSafeForDriving() {
        return ramp.isSafeForDriving();
    }

}
