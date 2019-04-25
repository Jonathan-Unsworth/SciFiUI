package ie.tudublin;

import processing.core.PVector;

public class Button implements Renderable, Clickable {
    private UI ui;
    private PVector pos;
    private float w, h;

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

    }
    
}

