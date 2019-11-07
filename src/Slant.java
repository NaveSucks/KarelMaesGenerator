import processing.core.PApplet;

public class Slant {

    PApplet processing;
    int color;

    public Slant(PApplet processing, int color){
        this.processing =  processing;
        this.color = color;
    }

    public void draw(float xSize, float ySize) {
        processing.pushMatrix();
        processing.rectMode(processing.CENTER);
        processing.rotate(PApplet.radians(30));
        processing.fill(color);
        processing.rect(0,0,xSize,ySize);
        processing.popMatrix();
    }
}
