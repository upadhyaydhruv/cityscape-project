import java.awt.*;
import java.util.Timer;

public class UFO {
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int yThreshold = 125;
    private JPanelExample panel;
    int counter = 0;
    Timer timer = new Timer();

    public UFO(int x, int y, JPanelExample jpe){
        this.x = x;
        this.y = y;
        xVel = 1;
        yVel = 1;
        panel = jpe;
    }

    public void move(){
        if (x<=0) xVel = 1;
        if (y<=0) yVel = 1;
        if (x>=panel.getWidth()-75) xVel = -1;
        if (y>=yThreshold-10) yVel = -1;
        x+=xVel;
        y+=yVel;
    }


    public void paint(Graphics2D g){
        counter+=1;
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, 70, 30);
        Color[] colors = new Color[2];
        colors[0] = Color.CYAN;
        colors[1] = Color.YELLOW;

        if  (counter%2==0) g.setColor(Color.YELLOW);
        else if (counter%2!=0) g.setColor(Color.CYAN);

        g.fillOval(x+26, y-5, 20, 20);
    }
}
