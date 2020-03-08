import javax.swing.*;
import java.awt.*;

public class Building {
    private Rectangle base;
    private int widthInWindows;
    private int heightInWindows;
    private int x1;
    private int y1;
    private Rectangle[][] windows;
    private int[][] lightState;

    public Building(int x1, int y1, int widthInWindows, int heightInWindows) {
        base = new Rectangle(x1, y1, widthInWindows * 20, heightInWindows * 20);
        this.widthInWindows = widthInWindows;
        this.heightInWindows = heightInWindows;
        this.x1 = x1;
        this.y1 = y1;
        this.createWindowArray();
    }

    public void createWindowArray() {
        windows = new Rectangle[widthInWindows][heightInWindows];
        for (int i = 0; i < windows.length; i++) {
            for (int k=0; k<windows[i].length; k++){
                windows[i][k] = new Rectangle(x1+20*(i)+2, y1+20*(k)+2, 17, 17);
            }
        }
        lightState = new int[widthInWindows][heightInWindows];
        for (int i=0; i<lightState.length; i++){
            for (int k=0; k<lightState[i].length; k++){
                lightState[i][k] = (int)(Math.random()*2+1);
            }
        }
    }

    public void paint(Graphics2D g){
        g.setColor(Color.GRAY);
        g.fill(base);
        for (int i=0; i<windows.length; i++){
            for (int k=0; k<windows[i].length; k++){
                if (lightState[i][k]==1) g.setColor(Color.BLACK);
                if (lightState[i][k]==2) g.setColor(Color.YELLOW);
                g.fill(windows[i][k]);
            }
        }
    }
}