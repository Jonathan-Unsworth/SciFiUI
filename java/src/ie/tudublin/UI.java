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

        Button btnBarChart = new Button(this, (width / 2) - 50, height - 70, 100, 50, "Bar Chart",
                                        new BarChart(this, 10, 10, width - 20, height - 100));

        Button btnPieChart = new Button(this, (width / 3) - 50, height - 70, 100, 50, "Pie Chart",
                                        new PieChart(this, 10, 10, width -20, height - 100));

        Button btnGraph = new Button(this, (width / 6) - 50, height - 70, 100, 50, "Graph",
                          new Graph(this, 10, 10, width -20, height - 100, "./data/graph.csv"));

        renderables.add(new DotGrid(this));
        renderables.add(btnBarChart);
        renderables.add(btnPieChart);
        renderables.add(btnGraph);
        renderables.add(new Cursor(this));

        clickables.add(btnBarChart);
        clickables.add(btnPieChart);
        clickables.add(btnGraph);
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

    public void mousePressed() {
        for(Clickable clickable : clickables) {
            if(clickable.isClicked()) {
                clickable.onClick();
            }
        }
    }
}

