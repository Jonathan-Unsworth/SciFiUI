package ie.tudublin;

public class DotGrid implements Renderable {
    private UI ui;

    public DotGrid(UI ui) {
        this.ui = ui;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        ui.fill(0, 0, 255);
        for(int i = 10; i < ui.width; i += 10) {
            for(int j = 10; j < ui.height; j += 10) {
                ui.ellipse(i, j, 3, 3);
            }
        }
    }
    
}