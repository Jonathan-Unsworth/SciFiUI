package ie.tudublin;

import java.util.List;
import java.util.ArrayList;

public class DotGrid implements Renderable {
    // Fields
    private UI ui;
    private List<Dot> dots;

    // Constructor
    public DotGrid(UI ui) {
        this.ui = ui;

        // Allocating memory for Dot ArrayList
        dots = new ArrayList<>();

        // Adds Dots accross the screen
        for(int i = 10; i < ui.width; i += 10) {
            for(int j = 10; j < ui.height; j += 10) {
                dots.add(new Dot(ui, i, j));
            }
        }
    }

    @Override
    public void update() {
        for(Dot dot : dots) {
            dot.update();
        }
    }

    @Override
    public void render() {
        for(Dot dot : dots) {
            dot.render();
        }
    }
    
}