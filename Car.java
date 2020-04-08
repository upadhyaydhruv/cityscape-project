import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Car {
    private BufferedImage img = null;
    private int w, h;
    private static int xVel = -5;
    private static int yVel = 0;
    private static int x, y;

    public Car(int xIn, int yIn) {
        try {
            this.img = ImageIO.read(new File("D:/Dhruv/car.png"));
            w = img.getWidth();
            h = img.getHeight();
        } catch (IOException e){
            System.out.println("res\\GoodManMcGee");
        }
        x = xIn;
        y = yIn;
    }

    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public static void setxVel(int newXVel){
        xVel = newXVel;
    }

    public static void setyVel(int newYVel){
        yVel = newYVel;
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
        y+=yVel;
        x+=xVel;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(img, x,  y, null);
    }
}
