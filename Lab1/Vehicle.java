package Lab1;

import java.awt.*;

public abstract class Vehicle implements Movable{
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private double x;
    private double y;
    private Direction direction;


    public Vehicle(double power, double speed, Color clr, String name) {
        this.enginePower = power;
        this.currentSpeed = speed;
        this.color = clr;
        this.modelName = name;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH; // starts facing north
    }

    public double getEnginePower() {
        return enginePower;
    }

    protected void setCurrentSpeed(double speed) {
        this.currentSpeed = Math.max(0, Math.min(speed, getEnginePower()));
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setColor(Color clr) { //the color on the vehicle could be changed
        this.color = clr;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getX() {
        return x; }

    public double getY() {
        return y; }

    protected void setPosition(double x, double y){ //för labb 2
        this.x = x;
        this.y = y;
    }

    public Direction getDirection() {
        return direction; }

    protected abstract void incrementSpeed(double amount);
    protected abstract void decrementSpeed(double amount);
    protected abstract double speedFactor();

    public void gas(double amount) {
        if (amount>=0 && amount<=1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount>=0 && amount<=1){
            decrementSpeed(amount);
        }
    }

    @Override
    public void move() {
        switch (this.direction) {
            case NORTH -> this.y += this.currentSpeed;
            case EAST  -> this.x += this.currentSpeed;
            case SOUTH -> this.y -= this.currentSpeed;
            case WEST  -> this.x -= this.currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        switch (this.direction) {
            case NORTH -> this.direction = Direction.WEST;
            case WEST  -> this.direction = Direction.SOUTH;
            case SOUTH -> this.direction = Direction.EAST;
            case EAST  -> this.direction = Direction.NORTH;
        };
    }

    @Override
    public void turnRight() {
        switch (this.direction) {
            case NORTH -> this.direction = Direction.EAST;
            case EAST  -> this.direction = Direction.SOUTH;
            case SOUTH -> this.direction = Direction.WEST;
            case WEST  -> this.direction = Direction.NORTH;
        };
    }

}
