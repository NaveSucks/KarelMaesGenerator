import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import static processing.core.PApplet.radians;
import static processing.core.PConstants.CENTER;

public class Triangle {

    PApplet processing;
    ArrayList<PVector> triangle;
    int size;
    int color;

    public Triangle(PApplet processing, int color){
        this.processing =  processing;
        triangle = makeShape();
        this.color = color;
    }

    ArrayList<PVector> makeShape() {
        ArrayList<PVector> vertices = new ArrayList<PVector>();
        vertices.add(new PVector(0.732f, 0));
        vertices.add(new PVector(-1, -1));
        vertices.add(new PVector(-1, 1));
        return vertices;
    }

   public void renderShape(ArrayList<PVector> vertices, int fillColor) {
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

    public void draw(int size) {
        processing.pushMatrix();
        processing.shapeMode(CENTER);
        processing.rotate(radians(-90));
        processing.scale(size,size);
        renderShape(triangle,color);
        processing.popMatrix();
    }
}
