package Cylinder;

import processing.core.PApplet;

class Rectangle extends Shape {
    Rectangle(PApplet p, float x, float y) {
        super(p, x, y);
    }

    void drawer(float x, float y, float size) {
        p.rect(x, y, size, size);
    }
}