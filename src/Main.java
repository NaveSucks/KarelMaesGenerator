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

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(400, 700, "processing.opengl.PGraphics2D");
    }

    public void setup() {
        processing = this;              //für mehrere Klassen in IntelliJ
        surface.setResizable(true);
        System.out.println("width: " + width + " height: " + height);
        noStroke();

        //Color Scheme Object
        colorScheme = new ColorScheme(processing);
        colorScheme.setTheme1();

        //checkerboard Background Object
        checkerBoard =      new CheckerBoard(   processing,colorScheme);

        //Circles Object
        int[] circleColors = new int[6];
        for(int i = 0; i<6; i++){
            int r = 7;
            while(r == 7) {
                r = (int) processing.random(2,7);
            }
            System.out.println(r);
            circleColors[i]=colorScheme.getColors()[r];
        }
        nestedCircles[0]=   new NestedCircle(   processing,circleColors);

        //Triangle Objects
        tri1 =              new Triangle(       processing,colorScheme.getColors()[2]);
        tri2 =              new Triangle(       processing,colorScheme.getColors()[4]);

        //Parallelogram Object
        para1 =             new Parallelogram(  processing,colorScheme.getColors()[6]);

        //Slant Objects
        slant1 =            new Slant(          processing,colorScheme.getColors()[5]);
        slant2 =            new Slant(          processing,colorScheme.getColors()[3]);
    }

    public void draw() {
        xScaler = width / 100.0f;
        yScaler = height / 100.0f;
        background(colorScheme.getColors()[0]);
        checkerBoard.draw(xScaler,yScaler);

        //draw all Parallelograms
        drawPara(para1,     60,18,40, 16);

        //draw all Slants
        drawSlant(slant1,   50,35,55, 33);
        drawSlant(slant2,   44,52,40, 55);

        //draw big circle
        pushMatrix();
        translate(57*xScaler,36*yScaler);
        nestedCircles[0].draw(44*xScaler,44*xScaler);
        popMatrix();

        //draw all Triangles
        drawTri(tri1,       35,60,15);
        drawTri(tri2,       40,35,8);

        //draw Circles
        pushMatrix();
        translate(70*xScaler,21*yScaler);
        nestedCircles[0].doArray(1,1);
        nestedCircles[0].draw(20*xScaler,20*xScaler);
        popMatrix();

        //draw Squares
        fill(colorScheme.getColors()[5]);
        square(46*xScaler,65*yScaler,22*xScaler);
        fill(colorScheme.getColors()[4]);
        square(66*xScaler,75*yScaler,38*xScaler);


    }

    public void drawTri(Triangle triangle, int xPos, int yPos, int size){
        pushMatrix();
        translate(xPos*xScaler,yPos*yScaler);
        triangle.draw((int)(size*xScaler));
        popMatrix();
    }

    public void drawPara(Parallelogram parallelogram, int xPos, int yPos, int xSize, int ySize){
        pushMatrix();
        translate(xPos*xScaler,yPos*yScaler);
        parallelogram.draw((int)(xSize*xScaler), (int)(ySize*yScaler));
        popMatrix();
    }

    public void drawSlant(Slant slant, int xPos, int yPos, int xSize, int ySize){
        pushMatrix();
        translate(xPos*xScaler,yPos*yScaler);
        slant.draw(xSize*xScaler, ySize*yScaler);
        popMatrix();
    }

}