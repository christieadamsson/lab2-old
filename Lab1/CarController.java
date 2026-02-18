package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Garage<Volvo240> volvoGarage = new Garage<>(10); //hur många ska den kunna ta in?
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Vehicle Volvo = new Volvo240();
        Volvo.setPosition(0, 0);
        Vehicle Saab = new Saab95();
        Saab.setPosition(0, 100);
        Vehicle Scania = new Scania();
        Scania.setPosition(0, 200);

        cc.vehicles.add(Volvo);
        cc.vehicles.add(Saab);
        cc.vehicles.add(Scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.setVehicles(cc.vehicles);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double w = frame.drawPanel.getWidth();
            double h = frame.drawPanel.getHeight();

            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                tryLoading(vehicle);

                boolean hitWall = false;

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
                frame.drawPanel.repaint();
            }
        }
    }

    private void tryLoading(Vehicle vehicle) {
        int x = (int) Math.round(vehicle.getX());
        int y = (int) Math.round(vehicle.getY());

        int wx = frame.drawPanel.getVolvoWorkshopPoint().x;
        int wy = frame.drawPanel.getVolvoWorkshopPoint().y;

        // ungefär samma storlekar
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

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
                ) {
            vehicle.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
        }
    }

    void setTurboOn(){
        for (Vehicle vehicle : vehicles
        ) {
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for (Vehicle vehicle : vehicles
        ) {
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void raiseRamp(){
        for (Vehicle vehicle : vehicles
        ) {
            if(vehicle instanceof Scania){
                ((Scania) vehicle).raiseRamp();
            }
        }
    }

    void lowerRamp(){
        for (Vehicle vehicle : vehicles
        ) {
            if(vehicle instanceof Scania){
                ((Scania) vehicle).lowerRamp();
            }
        }
    }

    void stopAllCars(){
        for (Vehicle vehicle: vehicles
        ) {
            vehicle.stopEngine();
        }
    }
    void startAllCars(){
        for (Vehicle vehicle: vehicles
        ) {
            vehicle.startEngine();
        }
    }

}
