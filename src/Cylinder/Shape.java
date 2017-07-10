package Cylinder;

import processing.core.PApplet;

abstract class Shape {
    PApplet p;
    private float x;
    private float y;
    private float px;
    private float py;

    byte thing = 0x2;

    Shape(PApplet p, float x, float y) {
        this.p = p;
        this.x = x;
        this.y = y;
    }

    void setPrevious() {
        this.px = this.x;
        this.py = this.y;
    }

    void setY(float y) {
        this.y = y % (float)this.p.height;
    }

    void setX(float x) {
        if(x >= 0.0F) {
            this.x = x % (float)this.p.width;
        } else {
            this.x = x % (float)this.p.width + (float)this.p.width;
        }

    }

    float getX() {
        return this.x;
    }

    float getY() {
        return this.y;
    }

    float getPx() {
        return this.px;
    }

    float getPy() {
        return this.py;
    }
}