package ie.tudublin;

import processing.core.PVector;

public class Button implements Renderable, Clickable {
    // Fields
    private UI ui;
    private PVector pos;
    private float w, h;
    private String text;
    private Renderable renderable;
    private boolean clicked = false;

    // Constructor
    public Button(UI ui) {
        this(ui, ui.width / 2, ui.height / 2, 100, 100, "Default", null);
    }

    // Parameterised Constructor
    public Button(UI ui, float x, float y, float w, float h, String text, Renderable renderable) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = h;
        this.text = text;
        this.renderable = renderable;
    }

    @Override
    public boolean isClicked() {
        // Button boundaries
        if(ui.mousePressed) {
            if(ui.mouseX > pos.x && ui.mouseX < pos.x + w &&
               ui.mouseY > pos.y && ui.mouseY < pos.y + h) {
                    clicked = !clicked;
               }    
        }
        return clicked;
    }

    /* 
        When a button is Clicked the renderable
        that was passed into the constructor has it's render and update method's called
    */
    @Override
    public void onClick() {
        renderable.update();
        renderable.render();
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        ui.fill(0, 150, 0);
        ui.rect(pos.x, pos.y, w, h);
        ui.fill(255);
        ui.textAlign(ui.CENTER, ui.CENTER);
        ui.text(text, pos.x + (w / 2), pos.y + (h / 2));

        if(clicked) {
            onClick();
        }
    }
    
}

