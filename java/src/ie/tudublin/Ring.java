package ie.tudublin;

import processing.core.PVector;

public class Ring implements Renderable {
    private UI ui;
    private PVector pos;
    private float innerRadius;
    private float outsideRadius;

    public Ring(UI ui, float x, float y, float innerRadius, float outsideRadius) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.innerRadius = innerRadius;
        this.outsideRadius = outsideRadius;
    }

    public void update() {
        
    }

    public void render() {
        float numPoints = ui.map(ui.mouseX, 0, ui.width, 6, 60);
        float angle = 0;
        float angleStep = 200 / numPoints;
        
        ui.fill(255, 0, 255);
        ui.beginShape(ui.TRIANGLE_STRIP); 
        for (int i = 0; i <= numPoints; i++) {
            float px = pos.x + ui.cos(ui.radians(angle)) * outsideRadius;
            float py = pos.y + ui.sin(ui.radians(angle)) * outsideRadius;
            angle += angleStep;
            ui.vertex(px, py);
            px = pos.x + ui.cos(ui.radians(angle)) * innerRadius;
            py = pos.y + ui.sin(ui.radians(angle)) * innerRadius;
            ui.vertex(px, py); 
            angle += angleStep;
        }
        ui.endShape();
    }

}