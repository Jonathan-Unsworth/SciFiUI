package ie.tudublin;

import processing.core.PVector;

public class Button implements Renderable, Clickable {
    private UI ui;
    private PVector pos;
    private float w, h;
    private String text;

    public Button(UI ui) {
        this(ui, ui.width / 2, ui.height / 2, 100, 100, "Default");
    }

    public Button(UI ui, float x, float y, float w, float h, String text) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = h;
        this.text = text;
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
        ui.fill(255);
        ui.textAlign(ui.CENTER, ui.CENTER);
        ui.text(text, pos.x + (w / 2), pos.y + (h / 2));
    }
    
}

