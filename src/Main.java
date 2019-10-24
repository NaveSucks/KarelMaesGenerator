import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {

    private PApplet processing;
    ColorScheme colorScheme;
    //Triangle triangle;
    NestedCircle[] nestedCircles = new NestedCircle[9];
    // scalable unit
    float scaler;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    void renderShape(ArrayList<PVector> vertices, int fillColor) {
        //set fill and stroke
        fill(fillColor);
        noStroke();

        //draw a polygon
        beginShape();
        for (PVector v : vertices) {
            vertex(v.x, v.y);
        }
        endShape(CLOSE);

    }

    public void setup() {
        processing = this;              //für mehrere Klassen in IntelliJ
        colorScheme = new ColorScheme(processing);
        //triangle = new Triangle(processing, colorScheme);
        surface.setResizable(true);
        System.out.println("width: " + width + " height: " + height);
    }

    public PApplet getProcessing() {
        return processing;
    }


    public void settings() {
        size(400, 400, "processing.opengl.PGraphics2D");
    }

    public void draw() {
        // scaler equals 1% of the smallest window dimesion
        scaler = min(width, height) / 100.0f;
        rotate(radians(20));
       // triangle.draw(scaler);
        drawNestedCircle();
    }

    private void drawTriangles(){

    }

    private void drawCheckerBoard(){

    }

    private void drawStripes(){

    }

    private void drawHalfCircles(){

    }

    private void drawHybridPoly(){

    }

    private void drawNestedCircle(){
        //there are 3 to 9 circles in an image
        if(nestedCircles[0]== null) {
            int count = (int) (random(6) + 3); //später wieder 6 statt 1
            for (int i = 0; i < count; i++) {
                nestedCircles[i] = new NestedCircle(processing, scaler, colorScheme);
                System.out.println("" + i + "nests");
            }
        }
        else {
            int j = 0;
            while(nestedCircles[j] != null){
                nestedCircles[j].draw();
                j++;
            }
        }
    }
}