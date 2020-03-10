package com.company;
import javax.swing.*;
import java.awt.*;

public class UFO {
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int yThreshold = 125;
    private JPanelExample panel;

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
        if (x>=panel.getWidth()-40) xVel = -1;
        if (y>=yThreshold-10) yVel = -1;
        x+=xVel;
        y+=yVel;
    }

    public void paint(Graphics2D g){
        g.setColor(Color.PINK);
        g.fillOval(x, y, 50, 20);
    }
}
