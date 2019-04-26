package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Dot implements Renderable {
    private UI ui;
    private PVector pos;
    private float w, h;

    public Dot(UI ui) {
        this(ui, 10, 10);
    }

    public Dot(UI ui, float x, float y) {
        this.ui = ui;
        pos = new PVector(x, y);
    }

    public Dot(UI ui, float x, float y, float w, float h) {
        this.ui = ui;
        pos = new PVector(x, y);
        this. w = w;
        this.h = h;
    }

    @Override
    public void update() {
        w = PApplet.dist(pos.x, pos.y, ui.mouseX, ui.mouseY);
        h = PApplet.dist(pos.x, pos.y, ui.mouseX, ui.mouseY);

        if(w > 100 && h > 100) {
            w = 1;
            h = 1;
        } else if(w > 80 && h > 80) {
            w = 2;
            h = 2;
        } else if(w > 60 && h > 60) {
            w = 3;
            h = 3;
        }  else if(w > 40 && h > 40) {
            w = 4;
            h = 4;
        } else if(w > 20 && h > 20) {
            w = 5;
            h = 5;
        } else {
            w = 6;
            h = 6;
        }
    }

    @Override
    public void render() {
        ui.fill(255);
        ui.ellipse(pos.x, pos.y, w, h);
    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }

}