package com.company;

import javax.swing.*;
import java.awt.*;

public class JPanelExample extends JPanel {
    private Building b1 = new Building(100, 240, 3, 10);
    private Building b2 = new Building(200, 200, 4, 12);
    private Building b3 = new Building(320, 280, 2, 8);
    private Building b4 = new Building(400, 160, 3, 14);
    private Building b5 = new Building(500, 220, 2, 11);

    private UFO[] list = new UFO[5];

    public JPanelExample(){
        for (int i=0; i<list.length; i++){
            list[i] = new UFO((i+1)*50, (i+1)*20, (int) (Math.random()*5)+1, (int) (Math.random()*5)+1, this);
        }
    }

    private void move(){
        for (int i=0; i<list.length; i++)
            for(int j=i+1; j<list.length; j++)
                list[i].collision(list[j]);
        for (UFO ufo:list) ufo.move();
    }


    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0,0,153));
        g2d.fillRect(0,0,1020, 600);
        b1.paint(g2d);
        b2.paint(g2d);
        b3.paint(g2d);
        b4.paint(g2d);
        b5.paint(g2d);
        for (UFO ufo:list) ufo.paint(g2d);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 441, 1020, 600);
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
