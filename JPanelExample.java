import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelExample extends JPanel {
    Building[] buildingArr = new Building[5];
    private Building b1 = new Building(100, 240, 3, 10);
    private Building b2 = new Building(200, 200, 4, 12);
    private Building b3 = new Building(320, 280, 2, 8);
    private Building b4 = new Building(400, 160, 3, 14);
    private Building b5 = new Building(500, 220, 2, 11);

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        b1.paint(g2d);
        b2.paint(g2d);
        b3.paint(g2d);
        b4.paint(g2d);
        b5.paint(g2d);
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 441, 1020, 600);
    }
}
