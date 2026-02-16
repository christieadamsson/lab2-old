package Lab1;

public class AngleRamp implements IRamp{
    private double rampAngle;

    public double getRampAngle() {
        return rampAngle;
    }

    public void raiseRampAngle(double angle) {
        if (angle <0) return;
        double newAngle = rampAngle + angle;

        if (newAngle > 70) {
            rampAngle = 70;
        } else {
            rampAngle = newAngle;
        }

    }

    public void lowerRampAngle(double angle) {
        if (angle <0) return;

        double newAngle = rampAngle - angle;
        if (newAngle<0){
            rampAngle = 0;
        }
        else {
            rampAngle = newAngle;
        }
    }

    @Override
    public boolean isSafeForDriving() { //funkar det verkligen att ha public här? Vi vill väl ej att användare ska kunna ändra
        return rampAngle == 0;
    }

}
