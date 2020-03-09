package com.company;

public class Plane {
    private int x;
    private int y;
    private int velocity;

    public Plane (int x, int y, int velocity){
        this.x=x;
        this.y=y;
        this.velocity = velocity;
    }

    public void move() {
        x += velocity;
    }
}
