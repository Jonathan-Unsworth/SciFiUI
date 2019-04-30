package ie.tudublin;

import java.util.List;
import java.util.ArrayList;
import processing.core.PVector;
import processing.data.Table;
import processing.data.TableRow;

public class Graph implements Renderable {
    // Fields
    private UI ui;
    private PVector pos;
    private float w, h;
    private String path;
    private List<Dot> nodes;

    // Constructor
    public Graph(UI ui, float x, float y, float w, float h, String path) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = h;
        this.path = path;

        // Allocating memory for nodes ArrayList
        nodes = new ArrayList<>();

        // Loads table from file
        Table table = ui.loadTable(path, "header");
    
        // Assigns values from table to corresponding fields
        for(TableRow row : table.rows()) {
            float xCord = row.getFloat("x");
            float yCord = row.getFloat("y");
            float width = row.getFloat("w");
            float height = row.getFloat("h");

            // adds a Dot object to the node ArrayList with values taken from file
            nodes.add(new Dot(ui, xCord, yCord, width, height));
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        for(int i = 0; i < nodes.size(); i++)
        {
            ui.stroke(255, 0, 0);
            if(i + 1 == nodes.size()) {
                ui.noStroke();
                nodes.get(i).render();
                break;
            }
            ui.line(nodes.get(i).getX(), nodes.get(i).getY(), nodes.get(i + 1).getX(), nodes.get(i + 1).getY());
            ui.noStroke();
            nodes.get(i).render();
        }
    }
}