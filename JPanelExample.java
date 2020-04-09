import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JPanelExample extends JPanel {
    private Building b1 = new Building(100, 240, 3, 10);
    private Building b2 = new Building(200, 200, 4, 12);
    private Building b3 = new Building(320, 280, 2, 8);
    private Building b4 = new Building(400, 160, 3, 14);
    private Building b5 = new Building(500, 220, 2, 11);
    private UFO[] list = new UFO[5];
    private Car car = new Car(300, 250);
    private UFO special;

    public JPanelExample(){
        for (int i=0; i<list.length-1; i++){
            list[i] = new UFO((i+1)*50, (i+1)*20, (int) (Math.random()*2)+1, (int) (Math.random()*2)+1, false, this);
        }
        list[list.length-1] = new UFO(500,50, 1, 1, true, this);
        special = list[list.length-1];
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
            }
            @Override
            public void keyReleased(KeyEvent e){
                special.keyReleased(e);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                special.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    private void move(){
        car.move();
        for (int i=0; i<list.length; i++)
            for(int j=i+1; j<list.length; j++)
                list[i].collision(list[j]);
        for (UFO ufo:list) ufo.move();
        special.move();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0,0,153));
        g2d.fillRect(0,0,1020, 600);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 441, 1020, 600);
        b1.paint(g2d);
        b2.paint(g2d);
        b3.paint(g2d);
        b4.paint(g2d);
        b5.paint(g2d);
        for (UFO ufo:list) ufo.paint(g2d);
        special.paint(g2d);
        car.paint(g2d);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("GoodManMcGee");
        frame.setSize(1020,640);
        JPanelExample panel = new JPanelExample();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            panel.move();
            panel.repaint();
            Thread.sleep(10);
        }
    }
}
