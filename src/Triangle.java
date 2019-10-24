import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import static processing.core.PApplet.radians;

public class Triangle {

    PApplet processing;
    ColorScheme colorScheme;
    ArrayList<PVector> triangle;

    public Triangle(PApplet processing, ColorScheme colorScheme){
        this.processing =  processing;
        this.colorScheme =  colorScheme;
        triangle = makeShape();
    }

    ArrayList<PVector> makeShape() {
        ArrayList<PVector> vertices = new ArrayList<PVector>();
        vertices.add(new PVector(1, 0));
        vertices.add(new PVector(-1, -1));
        vertices.add(new PVector(-1, 1));
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

    public void draw(float scaler) {
        // scaler equals 1% of the smallest window dimesion
        processing.pushMatrix();
        // transform the airplane
        processing.translate(60 * scaler, 50 * scaler);
        processing.rotate(radians(10));
        processing.scale(60 * scaler);

        // draw the airplane
        int green = processing.color(0, 155, 0);
        renderShape(triangle,green);
        processing.popMatrix();
    }
}
