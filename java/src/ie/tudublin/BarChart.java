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
}