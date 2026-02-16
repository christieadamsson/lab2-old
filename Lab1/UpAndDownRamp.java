package Lab1;

public class UpAndDownRamp implements IRamp {
    private boolean rampDown;


    public void lowerRamp() {
            rampDown = true;
    }

    public void raiseRamp(){
           rampDown = false;
    }

    public boolean isRampDown() {
        return rampDown;
    }

    @Override
    public boolean isSafeForDriving() {
        return !rampDown;
    }
}