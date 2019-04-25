package ie.tudublin;

import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;

public class UI extends PApplet
{
    private List<Renderable> renderables;

    public void settings()
    {
        size(600, 600);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(P3D); 
    }

    public void setup()
    {
        renderables = new ArrayList<>();
        renderables.add(new DotGrid(this));
        renderables.add(new Button(this));
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
}

