package Lab1;

import java.util.ArrayList;
public class Garage <T extends Vehicle> implements Adds<T> {
    private final int capacity;
    private double x;
    private double y;
    private String garageName;
    private final ArrayList<T> vehicles;

    public Garage(int capacity, String garageName) {
        this.capacity = capacity;
        this.x = 0;
        this.y = 0;
        this.garageName = garageName;
        this.vehicles = new ArrayList<>(capacity);
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNrVehicles(){
        return vehicles.size();
    }

    public String getGarageName(){
        return garageName;
    }

    public void setPosition(double x, double y){
        this.x= x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public T remove(T vehicle){
        boolean v = vehicles.remove(vehicle);
        if (v) {
            return vehicle;
        }
        else{
            return null;
        }
    }

    @Override
    public void add(T vehicle){
        if (vehicles.size() >= capacity) {
            return;
        }
        if (vehicles.contains(vehicle)) {
            return;
        }
        vehicles.add(vehicle);
    }
}
