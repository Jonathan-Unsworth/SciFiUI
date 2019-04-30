package ie.tudublin;

import processing.core.PVector;

public class BarChart implements Renderable {
    // fields
    private UI ui;
    private PVector pos;
    private float w, h;

    // Parameterised Constructor
    public BarChart(UI ui, float x, float y, float w, float h) {
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
        ui.fill(0, 100, 0, 50);
        ui.rect(pos.x, pos.y, w, h);

        ui.noStroke();
        for(int i = (int)pos.x; i < w; i += w / 50) {
            float rand = ui.random(5, 500);
            ui.fill(255, 0, 0);
            ui.rect(i, h, 10, -rand);
        }

    }
}