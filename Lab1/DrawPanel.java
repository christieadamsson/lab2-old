package Lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    Map<String, BufferedImage> images = new HashMap<>();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        loadImages();
    }

    private void loadImages() {
        try {
            images.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            images.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            images.put("Scania", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setVehicles(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

        for (Vehicle vehicle : vehicles) {
            BufferedImage image = images.get(vehicle.getModelName());

            if (image != null) {
                g.drawImage((Image) image, (int) vehicle.getX(), (int) vehicle.getY(), null); // see javadoc for more info on the parameters
            }
        }
    }

    public Point getVolvoWorkshopPoint() {
        return volvoWorkshopPoint;
    }
}
