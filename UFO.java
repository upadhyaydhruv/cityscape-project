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
    public boolean beam = false;


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
            if (y <= 0) yVel = -yVel;
            if (x >= panel.getWidth() - 75) xVel = -xVel;
            if (y >= yThreshold - 10) yVel = -yVel;
            x += xVel;
            y += yVel;
        }

        if (special&&beam){
            if (Car.getX()<=this.x-10||Car.getX()>=this.x+10){
                Car.setxVel(0);
                Car.setyVel(-3);
                if (Car.getY()<=this.y){
                    Car.setyVel(0);
                }
            }
        }

        else {
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
            else if (!special && b.special) {
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
        g.setColor(Color.YELLOW);
        if (beam&&special){
            g.fillRect(this.x+25, this.y+5,20, 1200);
        }
    }
}
