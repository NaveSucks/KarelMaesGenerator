import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

import static processing.core.PApplet.radians;
import static processing.core.PConstants.CENTER;

public class Parallelogram {

    private PApplet processing;
    private ArrayList<PVector> triangle;
    private int size;
    private int color;

    public Parallelogram(PApplet processing, int color) {
        this.processing = processing;
        triangle = makeShape();
        this.color = color;
    }

    ArrayList<PVector> makeShape() {
        ArrayList<PVector> vertices = new ArrayList<PVector>();
        vertices.add(new PVector(0, 0));
        vertices.add(new PVector(-1, -1));
        vertices.add(new PVector(-1, 4));
        vertices.add(new PVector(0, 4 + 1));
        return vertices;
    }

    void renderShape(ArrayList<PVector> vertices, int fillColor) {
        // set fill and stroke
        processing.fill(fillColor);
        processing.noStroke();

        // draw a polygon
        processing.beginShape();
        for (PVector v : vertices) {
            processing.vertex(v.x, v.y);
        }
        processing.endShape(processing.CLOSE);
    }

    public void draw(int xSize, int ySize) {
        processing.pushMatrix();
        processing.shapeMode(CENTER);
        processing.scale(xSize, ySize);
        renderShape(triangle, color);
        processing.popMatrix();
    }
}

