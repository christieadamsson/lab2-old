package Lab1;

public class UpAndDownRamp implements IRamp {
    private boolean rampDown;

    public boolean isRampDown() {
        return rampDown;
    }

    @Override
    public boolean isSafeForDriving() {
        return !rampDown;
    }

    @Override
    public void lowerRamp() {
        rampDown = true;
    }

    @Override
    public void raiseRamp() {
        rampDown = false;
    }
}