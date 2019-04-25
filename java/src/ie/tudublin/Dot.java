package ie.tudublin;

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

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

}