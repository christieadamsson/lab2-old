package Lab1;

import java.util.Random;

public class VehicleFactory {

    public static Random random = new Random();

    public static  Vehicle  createVolvo(double x,double y){
        Vehicle volvo = new Volvo240();
        volvo.setPosition(x,y);
        return volvo;
    }

    public static  Vehicle createScania(double x,double y){
        Vehicle scania = new Scania();
        scania.setPosition(x,y);
        return scania;
    }
    public static Vehicle createSaab(double x,double y){
        Vehicle saab = new Saab95();
        saab.setPosition(x,y);
        return saab;
    }

    public static Garage createVolvoGarage(int capacity, double x,double y, String garageName){ //borde man ha med <Volvo240> i Garage?
        Garage<Volvo240> volvoGarage = new Garage(capacity, garageName);
        volvoGarage.setPosition(x,y);
        return volvoGarage;

    }

    public static Vehicle createRandomVehicle() {
        int choice = random.nextInt(3);
        int x = random.nextInt(690);
        int y = random.nextInt(500);
        switch (choice) {
            case 0:
                return createVolvo(x, y);
            case 1:
                return createSaab(x, y);
            case 2:
                return createScania(x, y);
            default:
                throw new IllegalStateException("Choose a value between 0-2");
        }
    }
}
