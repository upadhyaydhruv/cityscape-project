package com.company;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Car {
    private BufferedImage img = null;
    int w, h;
    private int xVel = -5;
    private int x, y;

    public Car(int x, int y) {
        try {
            this.img = ImageIO.read(new File("D:/Dhruv/car.png"));
            w = img.getWidth();
            h = img.getHeight();
        } catch (IOException e){
            System.out.println("res\\GoodManMcGee");
        }
        this.x = x;
        this.y = y;
    }

    public BufferedImage horizontalflip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage newImg = new BufferedImage(w, h, img.getType());
        Graphics2D g = newImg.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return newImg;
    }

    public void move(){
        if (xVel>0 && this.x>=720) {
            xVel = -5;
            this.img = horizontalflip(img);
        }
        else if (xVel<0 && this.x<=0){
            xVel = 5;
            this.img = horizontalflip(img);
        }
        this.x+=xVel;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(img, x,  y, null);
    }

}
