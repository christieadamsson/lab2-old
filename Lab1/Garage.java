package Lab1;

import java.util.ArrayList;
public class Garage <T extends Vehicle> implements Adds<T> {
    private final int capacity;
    private final ArrayList<T> vehicles;

    public Garage(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNrVehicles(){
        return vehicles.size();
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
