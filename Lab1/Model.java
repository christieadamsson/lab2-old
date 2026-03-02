package Lab1;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.awt.Rectangle;

public class Model {

    public VehicleGroup vehicles = new VehicleGroup();
    ArrayList<Garage> garages = new ArrayList<>();

    public void update(){
        vehicles.moveAll();
        for (Vehicle vehicle: vehicles.getVehicles()){
            tryLoading(vehicle);
            carCollision(vehicle);
        }
    }

    public void carCollision(Vehicle vehicle) {
        boolean hitWall = false;
        double w = 690; //ok?
        double h = 500; //ok?

        if (vehicle.getX() <= 0) {
            vehicle.setPosition(1, vehicle.getY());
            hitWall = true;
        } else if (vehicle.getX() >= w) {
            vehicle.setPosition(w, vehicle.getY());
            hitWall = true;
        }

        if (vehicle.getY() <= 0) {
            vehicle.setPosition(vehicle.getX(), 1);
            hitWall = true;
        } else if (vehicle.getY() >= h) {
            vehicle.setPosition(vehicle.getX(), h);
            hitWall = true;
        }

        if (hitWall) {
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
        }
    }

    public void tryLoading(Vehicle vehicle) {
        int x = (int) Math.round(vehicle.getX());
        int y = (int) Math.round(vehicle.getY());

        for (Garage volvoGarage: garages) {
            int wx = (int) Math.round(volvoGarage.getX());
            int wy = (int) Math.round(volvoGarage.getY());


            int carW = 100, carH = 60;
            int workshopW = 100, workshopH = 100;

            Rectangle carRect = new Rectangle(x, y, carW, carH);
            Rectangle workshopRect = new Rectangle(wx, wy, workshopW, workshopH);

            if (carRect.intersects(workshopRect)) {
                if (vehicle instanceof Volvo240 volvo) {
                    volvoGarage.add(volvo);
                    vehicle.setPosition(wx, wy);
                }
            }
        }
    }

    // ===== Commands =====
    public void gas(int amount) {
        vehicles.gasAll(amount / 100.0);
    }

    public void brake(int amount) {
        vehicles.brakeAll(amount / 100.0);
    }

    public void stopAllCars() {
        vehicles.stopAll();
    }

    public void startAllCars() {
        vehicles.startAll();
    }

    public void addCar(){
        vehicles.addNew();
    }

    public void removeCar(){
        vehicles.removeCar();
    }

    // De här två behöver fortfarande loop per vehicle,
    // eftersom bara vissa typer påverkas
    public void setTurboOn() {
        for (Vehicle vehicle : vehicles.getVehicles()) {
            if (vehicle instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (Vehicle vehicle : vehicles.getVehicles()) {
            if (vehicle instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }

    public void lowerRamp() {
        for (Vehicle vehicle : vehicles.getVehicles()) {
            if (vehicle instanceof Scania scania) {
                scania.lowerRamp();
            }
        }
    }

    public void raiseRamp() {
        for (Vehicle vehicle : vehicles.getVehicles()) {
            if (vehicle instanceof Scania scania) {
                scania.raiseRamp();
            }
        }
    }
}
