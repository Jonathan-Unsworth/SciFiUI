package ie.tudublin;

import processing.core.PVector;

public class Button implements Renderable, Clickable {
    private UI ui;
    private PVector pos;
    private float w, h;

    public Button(UI ui) {
        this(ui, ui.width / 2, ui.height / 2, 100, 100);
    }

    public Button(UI ui, float x, float y, float w, float h) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = y;
    }

    @Override
    public boolean isClicked() {
        return false;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        ui.fill(0, 255, 0);
        ui.rect(pos.x, pos.y, w, h);
    }
    
}

