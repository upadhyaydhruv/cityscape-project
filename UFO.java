import java.awt.*;
import java.awt.event.KeyEvent;

public class UFO {
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int yThreshold = 125;
    private JPanelExample panel;
    private static final int DIAMETER = 50;
    private boolean special;
    private boolean left, right, up, down;
    private boolean beam = false;

    public UFO(int x, int y, int xVel, int yVel, boolean special, JPanelExample jpe){
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        panel = jpe;
        this.special = special;
    }

    public void keyPressed(KeyEvent e){
        if (special && e.getKeyCode()==KeyEvent.VK_LEFT){
            left = true;
        }
        else if (special && e.getKeyCode()==KeyEvent.VK_RIGHT){
            right = true;
        }
        else if (special && e.getKeyCode() == KeyEvent.VK_UP){
            up = true;
        }
        else if (special && e.getKeyCode() == KeyEvent.VK_DOWN){
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            beam = true;
        }
    }

    public void keyReleased(KeyEvent e){
        if (special && e.getKeyCode()==KeyEvent.VK_LEFT){
            left = false;
        }
        else if (special && e.getKeyCode()==KeyEvent.VK_RIGHT){
            right = false;
        }
        else if (special && e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
        }
        else if (special && e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            beam = false;
        }
    }

    public void move(){
        if (!special) {
            if (x <= 0) xVel = -xVel;
            if (y <= 5) yVel = -yVel;
            if (x >= panel.getWidth() - 75) xVel = -xVel;
            if (y >= yThreshold - 10) yVel = -yVel;
            x += xVel;
            y += yVel;
        }

        if (special&&beam){
            if (Car.getX()<=this.x-140&&Car.getX()>=this.x-170){
                if (!right&&!left) {
                    Car.setxVel(0);
                }
                else {
                    if (right) {
                        Car.setxVel(this.xVel+1);
                    }
                    else {
                        Car.setxVel(-this.xVel-1);
                    }
                }
                Car.setyVel(-3);
                if (Car.getY()<=this.y-200){
                    Car.setyVel(0);
                    Car.removeCar() ;
                 }
            }
            if (left){
                x-=xVel;
            }
            if (right){
                x+=xVel;
            }
            if (up){
                y-=yVel;
            }
            if (down){
                y+=yVel;
            }
        }
        else {
            if (left){
                if (x<=0){

                }
                else {
                    x -= xVel;
                }
            }
            if (right){
                if (x>=panel.getWidth()-75){}
                else {
                    x += xVel;
                }
            }
            if (up){
                if (y<=5){}
                else {
                    y -= yVel;
                }
            }
            if (down){
                if (y>=yThreshold){}
                else {
                    y += yVel;
                }
            }
        }
    }

    public void collision(UFO b){
        int dx = (x-b.x)+(xVel-b.xVel);
        int dy = (y-b.y)+(yVel-b.yVel);

        if (Math.sqrt(dx*dx+dy*dy)<=DIAMETER){
            if (!special&&!b.special) {
                xVel ^= b.xVel;
                b.xVel ^= xVel;
                xVel ^= b.xVel;

                yVel ^= b.yVel;
                b.yVel ^= yVel;
                yVel ^= b.yVel;
            }
            else if(special&&!b.special) {
                b.xVel = -b.xVel;
                b.yVel = -b.yVel;
            }
            else if (!special) {
                xVel = -xVel;
                yVel = -yVel;
            }
        }
    }

    public void paint(Graphics2D g){
        g.setColor(new Color((int)(Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
        g.fillOval(x+26, y-10, 20, 20);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x, y, 70, 30);
        if (special){
            g.setColor(Color.RED);
            g.fill3DRect(this.x, this.y, 20, 10, true);
        }
        if (beam&&special){
            g.setColor(Color.YELLOW);
            g.fillRect(this.x+25, this.y+5,20, 1200);
        }
        else if (!beam && special){
            if (Car.getY()>=250&&Car.getRight()){
                Car.setxVel(5);
                Car.setyVel(0);
            }
            else if (Car.getY()>=250){
                Car.setxVel(-5);
                Car.setyVel(0);
            }
            else {
                Car.setyVel(5);
            }
        }
    }
}
