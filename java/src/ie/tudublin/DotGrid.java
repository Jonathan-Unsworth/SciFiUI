package ie.tudublin;

import processing.core.PVector;

public class DotGrid implements Renderable {
    private UI ui;
    private PVector pos;

    public DotGrid(UI ui) {
        this.ui = ui;
        pos = new PVector();
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        ui.fill(255, 0, 0);
        for(pos.x = 10; pos.x < ui.width; pos.x += 10) {
            for(pos.y = 10; pos.y < ui.height; pos.y += 10) {
                ui.ellipse(pos.x, pos.y, 2, 2);
            }
        }
    }
    
}