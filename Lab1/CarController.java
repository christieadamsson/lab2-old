package Lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarController {

    private final int delay;
    private final Timer timer;

    private final Model model;
    private final Refresh view;



    public CarController(Model model, Refresh view, int delayMs) {
        this.model = model;
        this.view = view;
        this.delay = delayMs;
        this.timer = new Timer(delay, new TimerListener());
    }

    public void start() {
        timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
            view.repaint();
        }
    }

    public void gas(int amount) {
        model.gas(amount);
    }
    public void brake(int amount) {
        model.brake(amount);
    }
    public void setTurboOn() {
        model.setTurboOn();
    }
    public void setTurboOff() {
        model.setTurboOff();
    }
    public void lowerRamp() {
        model.lowerRamp();
    }
    public void raiseRamp() {
        model.raiseRamp();
    }
    public void stopAllCars() {
        model.stopAllCars();
    }
    public void startAllCars() {
        model.startAllCars();
    }

    public void addCar(){
        model.addCar();
    }

    public void removeCar(){
        model.removeCar();
    }
}