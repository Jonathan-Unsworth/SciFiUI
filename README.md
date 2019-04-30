# SciFi UI Project

Name: Jonathan Unsworth

Student Number: C17718415

class: DT228 - 2

# Description of the assignment
The aim of this assignment is to development a visual interface for a SciFi user interface.
To achieve this goal the Java programming language and the processing environment are in used in tandem.
OOP Paradigms such as inheritence and polymorphism are used to create the interface.

I decided that my version of this assignment would be an interface that would relay visual information through a graph, a barchart and a piechart. My aim was to develop something you would expect to find on a ship like on Star Trek.

# Instructions
When the program begins the user is presented with three buttons which can pressed.
Each button is labelled with it's functionality, one for a barchart, another for a piechart and yet another for a graph.
Pressing said button will have it appear on the screen. Presseing it again will make it disappear.

# How it works
Simply put, I relied heavily on polymorphism to realise my goals in this assignment.
I created two interfaces, Renderable and Clickable, as their names suggest they are responsible for rendering objects and clicking on objects respectively.

```Java
public interface Renderable {
    void update();
    void render();
}
```

```Java
public interface Clickable {
    boolean isClicked();
    void onClick();
}
```

This allowed me use 2 ArrayLists, one for renderables and another for clickables, to store each respectively. This way I could just cycle through each list with a foreach loop to render everything to screen, and apply functionality to certain objects on screen with the mousePressed method.

```Java
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
```
I decided I wanted the background to be visually composed of white circles which changes size based on their distance to the mouse cusor, closer circles are bigger. To achieve this I used 2 classes, dot and dotGrid. Dot is used, as it name suggests, to compose a dot as seen in the code snippet below.

```Java
@Override
    public void update() {
        w = PApplet.dist(pos.x, pos.y, ui.mouseX, ui.mouseY);
        h = PApplet.dist(pos.x, pos.y, ui.mouseX, ui.mouseY);

        if(w > 100 && h > 100) {
            w = 1;
            h = 1;
        } else if(w > 80 && h > 80) {
            w = 2;
            h = 2;
        } else if(w > 60 && h > 60) {
            w = 3;
            h = 3;
        }  else if(w > 40 && h > 40) {
            w = 4;
            h = 4;
        } else if(w > 20 && h > 20) {
            w = 5;
            h = 5;
        } else {
            w = 6;
            h = 6;
        }
    }

    @Override
    public void render() {
        ui.fill(255);
        ui.ellipse(pos.x, pos.y, w, h);
    }
``` 

DotGrid renders the dots across the whole screen. To do this it takes in an ArrayList of Dots and simply calls the render method of the dot.

```Java
public DotGrid(UI ui) {
        this.ui = ui;
        dots = new ArrayList<>();

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
```

For the Graph class I read in the coordinates of the nodes from a .csv file and then assigned the coordinates to a dot class, in the constructor, and used dots to represent nodes.

```Java
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
```
Rendering the Barchart and Piechart were simple affairs I simply had them implement the renderable interface and then gave each their own implementation of renderable.

[![YouTube](http://img.youtube.com/vi/zFhd9rYkuPo/0.jpg)](https://www.youtube.com/watch?v=zFhd9rYkuPo&feature=youtu.be)

# What I am most proud of in the assignment
I am very proud of my personal growth in this assignment. I feel my understanding of OOP concepts, such as inheritence and polymorphism really grew throughout the course of this project. I really liked how I used 2 ArrayList to provide render and functionality for buttons. I'm glad I learned to use git over the course of the project as I know it will benefit in the future.

I feel this project made me think about coding in a different way than I'm use to because I was drawing stuff to a screen. This meant I had to think at a more critical level. I think I'm most proud of the developmeant of my critical thinking over the course of the assignment.
