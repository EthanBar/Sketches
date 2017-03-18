package Cylinder;

import java.util.Random;
import processing.core.PApplet;

public class Sketch extends PApplet {
    private int particleCount = 1000;
    private float yMaxSpeed = 0.08F;
    private float xMaxSpeed = 10.0F;
    private float maxSize = 10.0F;
    private float minSize = 5.0F;
    private boolean motionBlur = true;
    private float blurStrength = 40.0F;
    private boolean rainbowStyleX = true;
    private Ellipse[] obj;
    private Random ran;

    public Sketch() {
        obj = new Ellipse[particleCount];
        ran = new Random();
    }

    public void settings() {
        size(800, 800, "processing.opengl.PGraphics2D");
    }

    public void setup() {
        background(0);

        for(int i = 0; i < obj.length; ++i) {
            obj[i] = new Ellipse(this, (float)ran.nextInt(width), (float)ran.nextInt(height));
        }

        colorMode(3, 100.0F);
    }

    public void draw() {
        if(motionBlur) {
            fill(0.0F, 0.0F, 0.0F, blurStrength);
            rectMode(0);
            rect(0.0F, 0.0F, (float)width, (float)height);
        } else {
            background(0);
        }

        for(int i = 0; i < obj.length; ++i) {
            obj[i].setX(obj[i].getX() + map((float)mouseY, 0.0F, (float)height, -xMaxSpeed, xMaxSpeed));
            obj[i].setY(obj[i].getY() + map((float)mouseX, 0.0F, (float)width, -yMaxSpeed, yMaxSpeed));
            float tempy = sin(obj[i].getY()) * (float)height / 3.0F + (float)(height / 2);
            float ptempy = sin(obj[i].getPy()) * (float)height / 3.0F + (float)(height / 2);
            if(tempy - ptempy >= 0.0F) {
                if(mouseX > width / 2) {
                    rainbow(obj[i].getX(), tempy, 100);
                } else {
                    rainbow(obj[i].getX(), tempy, 50);
                }
            } else if(mouseX > width / 2) {
                rainbow(obj[i].getX(), tempy, 50);
            } else {
                rainbow(obj[i].getX(), tempy, 100);
            }

            rectMode(3);
            obj[i].drawer(tempy, obj[i].getX(), map(abs((float)(width / 2) - obj[i].getX()), 0.0F, (float)(width / 2), maxSize, minSize));
            obj[i].setPrevious();
        }

    }

    void rainbow(float x, float y, int alp) {
        if(rainbowStyleX) {
            fill(map(x, 0.0F, (float)height, 0.0F, 100.0F), 100.0F, 100.0F, (float)alp);
        } else {
            fill(map(y, (float)(height / 5), (float)(height / 5 * 4), 0.0F, 100.0F), 100.0F, 100.0F, (float)alp);
        }

    }
}
