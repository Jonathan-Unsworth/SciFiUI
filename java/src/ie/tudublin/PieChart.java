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

        ui.fill(255, 0, 0);
        ui.arc(w / 2, h / 2, w - 500, h - 100, ui.PI + ui.QUARTER_PI, ui.TWO_PI);
        ui.fill(255, 0, 255);
        ui.arc(w / 2, h / 2, w - 500, h - 100, ui.PI, ui.PI + ui.QUARTER_PI);
        ui.fill(0, 255, 255);
        ui.arc(w / 2, h / 2, w - 500, h - 100, ui.HALF_PI, ui.PI);
        ui.fill(255, 255, 0);
        ui.arc(w / 2, h / 2, w - 500, h - 100, 0, ui.HALF_PI);
    }
}