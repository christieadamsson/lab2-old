package Lab1;
import java.util.ArrayList;


public class VehicleGroup {
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void add(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void addNew() {
        Vehicle vehicle = VehicleFactory.createRandomVehicle();
        vehicles.add(vehicle);
    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    public void removeCar(){
        if (vehicles.isEmpty()) return;
        int last = vehicles.size()-1;
        vehicles.remove(last);
    }

    public void moveAll() {
        for (Vehicle v : vehicles)
            v.move();
    }
    public void gasAll(double amount) {
        for (Vehicle vehicle : vehicles)
            vehicle.gas(amount);
    }
    public void brakeAll(double amount) {
        for (Vehicle vehicle : vehicles)
            vehicle.brake(amount);
    }
    public void stopAll() {
        for (Vehicle vehicle : vehicles)
            vehicle.stopEngine();
    }
    public void startAll() {
        for (Vehicle vehicle : vehicles)
            vehicle.startEngine();
    }
}

