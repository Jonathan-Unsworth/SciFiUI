package ie.tudublin;

import processing.core.PVector;

public class PieChart implements Renderable {
    UI ui;
    private PVector pos;
    private float w, h;

    public PieChart(UI ui, float x, float y, float w, float h) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = h;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}