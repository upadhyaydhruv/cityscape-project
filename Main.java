import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GoodManMcGee");
        frame.setSize(1020,640);
        frame.setBackground(Color.BLACK);
        frame.add(new JPanelExample());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}