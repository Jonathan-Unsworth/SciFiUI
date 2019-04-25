package ie.tudublin;

import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;

public class UI extends PApplet
{
    private List<Renderable> renderables;
    private List<Clickable> clickables;

    public void settings()
    {
        size(1000, 600);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        frameRate(60);

        renderables = new ArrayList<>();
        clickables = new ArrayList<>();

        Button btnBarChart = new Button(this, (width / 2) - 50, height - 70, 100, 50, "Bar Chart");

        renderables.add(new DotGrid(this));
        renderables.add(btnBarChart);

        clickables.add(btnBarChart);
    }

    public void draw()
    {
        background(0);
        
        // Render Phase
        for(Renderable renderable : renderables) {
            renderable.update();
            renderable.render();
        }
    }

    public void mouseClicked() {
        for(Clickable clickable : clickables) {
            if(clickable.isClicked()) {
                clickable.onClick();
            }
        }
    }
}

