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
    private List<Dot> graphNodes;

    public Graph(UI ui, float x, float y, float w, float h, String path) {
        this.ui = ui;
        pos = new PVector(x, y);
        this.w = w;
        this.h = h;
        this.path = path;

        graphNodes = new ArrayList<>();
        Table table = ui.loadTable(path, "header");
    
        for(TableRow row : table.rows()) {
            float xCord = row.getFloat("x");
            float yCord = row.getFloat("y");
            graphNodes.add(new Dot(ui, xCord, yCord));
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
    
}