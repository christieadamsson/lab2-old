package Lab1;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Instance of this class
        Model model = new Model();
        CarView view = new CarView("CarSim 1.0");
        CarController cc = new CarController(model, view, 50);


        model.vehicles.add(VehicleFactory.createVolvo(300,0));
        model.vehicles.add(VehicleFactory.createSaab(200,0));
        model.vehicles.add(VehicleFactory.createScania(100,0));
        model.garages.add(VehicleFactory.createVolvoGarage(10,300,300, "VolvoGarage"));


        view.setVehicles((model.vehicles.getVehicles()));
        view.setController(cc);
        view.setGarages(model.garages);

        // Start the timer
        cc.start();
    }

}