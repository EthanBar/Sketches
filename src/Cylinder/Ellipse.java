package Cylinder;

import processing.core.PApplet;

class Ellipse extends Shape {
    Ellipse(PApplet p, float x, float y) {
        super(p, x, y);
    }

    void drawer(float x, float y, float size) {
        p.ellipse(x, y, size, size);
    }
}
