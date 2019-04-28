package ie.tudublin;

import processing.core.PApplet;

public class Cursor implements Renderable {
    private UI ui;
    private float velocity = 0.01f; 
    private float spin = 0; 
    private float size = 100;

    public Cursor(UI ui) {
        this.ui = ui;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        ui.fill(0, 255, 0);
        spin += velocity; 
        ui.pushMatrix(); 
        ui.translate(ui.mouseX, ui.mouseY); 
        ui.noStroke(); 
        ui.fill(0, 255, 0); 
        ui.rotate(spin); 
        ui.triangle(30, 75, 58, 20, 86, 75);
        ui.popMatrix(); 
    }
    
}