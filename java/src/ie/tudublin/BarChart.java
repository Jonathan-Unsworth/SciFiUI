package ie.tudublin;

import processing.core.PVector;

public class BarChart implements Renderable {
    private UI ui;
    private PVector pos;
    private float w, h;

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
        ui.fill(255, 255, 0);
        ui.rect(50, h, 150, -100);

        ui.fill(0, 100, 255);
        ui.rect(200, h, 150, -400);

        ui.fill(0, 255, 0);
        ui.rect(350, h, 150, -200);

        ui.fill(255, 255, 0);
        ui.rect(500, h, 150, -300);

        ui.fill(255, 0, 0);
        ui.rect(650, h, 150, -h + 20);

        ui.fill(255, 100, 0);
        ui.rect(800, h, 150, -350);

    }
}