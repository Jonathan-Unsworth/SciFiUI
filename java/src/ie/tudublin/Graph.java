package ie.tudublin;

import java.util.List;
import java.util.ArrayList;
import processing.core.PVector;
import processing.data.Table;
import processing.data.TableRow;

public class Graph implements Renderable {
    private UI ui;
    private PVector pos;
    private float w, h;
    String path;
    private List<Dot> nodes;

    public Graph(UI ui, float x, float y, float w, float h, String path) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = h;
        this.path = path;

        nodes = new ArrayList<>();
        Table table = ui.loadTable(path, "header");
    
        for(TableRow row : table.rows()) {
            float xCord = row.getFloat("x");
            float yCord = row.getFloat("y");
            float width = row.getFloat("w");
            float height = row.getFloat("h");

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