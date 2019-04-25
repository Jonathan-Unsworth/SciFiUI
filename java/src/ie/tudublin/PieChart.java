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
        ui.fill(0, 0, 100, 50);
        ui.rect(pos.x, pos.y, w, h);

        
        ui.ellipse(w / 2, h / 2, w - 100, h - 100);
    }
}