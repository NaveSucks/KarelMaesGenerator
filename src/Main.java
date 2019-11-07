import processing.core.PApplet;
import processing.core.PVector;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;

public class Main extends PApplet {

    private PApplet processing;

    private ColorScheme colorScheme;
    private Triangle tri1;
    private Triangle tri2;
    private NestedCircle[] nestedCircles = new NestedCircle[9];
    private float xScaler;
    private float yScaler;
    private Parallelogram para1;
    private Slant slant1;
    private Slant slant2;
    private CheckerBoard checkerBoard;
    private int deg;
    private int clickCircleCounter;
    private int[] circleColors = new int[6];
    private boolean firstStart = true;
    private boolean unlocked = false;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(400, 700, "processing.opengl.PGraphics2D");
    }

    public void setup() {
        processing = this;              //für mehrere Klassen in IntelliJ
        surface.setResizable(true);
        noStroke();

        //Color Scheme Object

        if (firstStart) {
            colorScheme = new ColorScheme(processing);
            colorScheme.setTheme1();
            firstStart = false;
        }


        //checkerboard Background Object
        checkerBoard = new CheckerBoard(processing, colorScheme);

        //Circles Object

        for (int i = 0; i < 6; i++) {
            int r = 7;
            while (r == 7) {
                r = (int) processing.random(2, 7);
            }
            circleColors[i] = colorScheme.getColors()[r];
        }
        nestedCircles[0] = new NestedCircle(processing, circleColors, 44, 44);
        nestedCircles[1] = new NestedCircle(processing, circleColors, 20, 20);

        //Triangle Objects
        tri1 = new Triangle(processing, colorScheme.getColors()[2]);
        tri2 = new Triangle(processing, colorScheme.getColors()[4]);

        //Parallelogram Object
        para1 = new Parallelogram(processing, colorScheme.getColors()[6]);

        //Slant Objects
        slant1 = new Slant(processing, colorScheme.getColors()[5]);
        slant2 = new Slant(processing, colorScheme.getColors()[3]);
    }

    public void draw() {
        xScaler = width / 100.0f;
        yScaler = height / 100.0f;
        background(colorScheme.getColors()[0]);
        checkerBoard.draw(xScaler, yScaler);

        //draw all Parallelograms
        drawPara(para1, 60, 18, 40, 16);

        //draw all Slants
        drawSlant(slant1, 50, 35, 55, 33);
        drawSlant(slant2, 44, 52, 40, 55);

        //draw big circle
        pushMatrix();
        translate(57 * xScaler, 36 * yScaler);
        nestedCircles[0].draw(this);
        popMatrix();

        //draw Circles
        pushMatrix();
        translate(70 * xScaler, 21 * yScaler);
        nestedCircles[1].doArray(1, 1);
        nestedCircles[1].draw(this);
        popMatrix();

        //draw clickedCircles
        for (int i = 0; i < clickCircleCounter; i++) {
            nestedCircles[i + 2].draw(this);
        }

        //draw Squares
        fill(colorScheme.getColors()[5]);
        square(46 * xScaler, 65 * yScaler, 22 * xScaler);
        fill(colorScheme.getColors()[4]);
        square(66 * xScaler, 75 * yScaler, 38 * xScaler);

        //draw all Triangles
        drawTri(tri1, 35, 60, 15);

        pushMatrix();
        deg += 2;
        if (deg > 360) deg = 0;
        drawTri(tri2, 40, 35, 8);
        popMatrix();

        //draw extrusion
        if (unlocked) {

            float localXScaler = xScaler * 0.8f;
            float localYScaler = yScaler * 0.8f;

            pushMatrix();
            translate(10 * xScaler + 5 * localXScaler, 10 * yScaler + 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[7]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 5 * localXScaler, 10 * yScaler + 17 * 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[9]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 0 * localXScaler, 10 * yScaler + 10 * 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[9]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 13 * 5 * localXScaler, 10 * yScaler + 0 * localYScaler);
            extrudeTile(colorScheme.getColors()[8]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 19 * 5 * localXScaler, 10 * yScaler + 17 * 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[9]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 18 * 5 * localXScaler, 10 * yScaler + 12 * 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[7]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 18 * 5 * localXScaler, 10 * yScaler + 9 * 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[7]);
            popMatrix();

            pushMatrix();
            translate(10 * xScaler + 17 * 5 * localXScaler, 10 * yScaler + 9 * 5 * localYScaler);
            extrudeTile(colorScheme.getColors()[9]);
            popMatrix();
        }


    }

    public void drawTri(Triangle triangle, int xPos, int yPos, int size) {
        pushMatrix();
        translate(xPos * xScaler, yPos * yScaler);
        rotate(radians(deg));
        triangle.draw((int) (size * xScaler));
        popMatrix();
    }

    public void drawPara(Parallelogram parallelogram, int xPos, int yPos, int xSize, int ySize) {
        pushMatrix();
        translate(xPos * xScaler, yPos * yScaler);
        parallelogram.draw((int) (xSize * xScaler), (int) (ySize * yScaler));
        popMatrix();
    }

    public void drawSlant(Slant slant, int xPos, int yPos, int xSize, int ySize) {
        pushMatrix();
        translate(xPos * xScaler, yPos * yScaler);
        slant.draw(xSize * xScaler, ySize * yScaler);
        popMatrix();
    }

    public void mouseClicked() {
        if (clickCircleCounter < 3) {
            clickCircleCounter++;
            int size = (int) random(20, 50);
            nestedCircles[clickCircleCounter + 1] = new NestedCircle(processing, circleColors, mouseX, mouseY, size, size);
        }
    }

    public float getxScaler() {
        return xScaler;
    }

    public float getyScaler() {
        return yScaler;
    }

    private void extrudeTile(int color) {
        float localXScaler = xScaler * 0.8f;
        float localYScaler = yScaler * 0.8f;

        pushMatrix();
        beginShape();
        float mp = 5 * localYScaler;
        if (mouseY > height / 2) {
            mp = mouseY / 2 - height * 0.8f / 4;
        }
        // if(mouseY< 10 * yScaler + 5 * localYScaler) mp = (int)(10 * yScaler);
        fill(color);
        vertex(5 * localXScaler, 0);
        vertex(0, 0);
        vertex(0, 5 * localYScaler);
        vertex(mp * 0.6f - 5 * localXScaler, mp);
        vertex(mp * 0.6f, mp);
        vertex(mp * 0.6f, mp - 5 * localYScaler);
        endShape();
        popMatrix();
    }


    public void keyPressed() {
        if (keyPressed) {

            if (key == 'f') {
                for (int i = 0; i < clickCircleCounter; i++) {
                    nestedCircles[i + 2] = null;
                }
                clickCircleCounter = 0;
            }

            if (key == 'w') {
                setup();
            }

            if (key == '1') {
                colorScheme.setTheme1();
                setup();
            }

            if (key == '2') {
                colorScheme.setTheme2();
                setup();
            }

            if (key == '3') {
                colorScheme.setTheme3();
                setup();
            }

            if (key == '4') {
                colorScheme.setTheme4();
                setup();
            }

            if (key == '5') {
                colorScheme.setTheme5();
                setup();
            }

            if (key == 'l'){
                unlocked = !unlocked;
            }


        }
    }
}