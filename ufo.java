package com.company;

import java.awt.*;
import java.util.Timer;

public class UFO {
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int yThreshold = 125;
    private JPanelExample panel;
    private int counter = 0;
    private static final int DIAMETER = 50;


    public UFO(int x, int y, int xVel, int yVel, JPanelExample jpe){
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        panel = jpe;
    }

    public void move(){
        if (x<=0) xVel = -xVel;
        if (y<=0) yVel = -yVel;
        if (x>=panel.getWidth()-75) xVel = -xVel;
        if (y>=yThreshold-10) yVel = -yVel;
        x+=xVel;
        y+=yVel;
    }

    public void collision(UFO b){
        int dx = (x-b.x)+(xVel-b.xVel);
        int dy = (y-b.y)+(yVel-b.yVel);

        if (Math.sqrt(dx*dx+dy*dy)<=DIAMETER){
            xVel^=b.xVel;
            b.xVel^=xVel;
            xVel^=b.xVel;

            yVel^=b.yVel;
            b.yVel^=yVel;
            yVel^=b.yVel;
        }

    }

    public void paint(Graphics2D g){
        counter+=1;
        g.setColor(new Color((int)(Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
        g.fillOval(x+26, y-10, 20, 20);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x, y, 70, 30);
    }
}
