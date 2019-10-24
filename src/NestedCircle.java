import processing.core.PApplet;

public class NestedCircle {
    private PApplet processing;
    private float scaler;
    private ColorScheme colorScheme;
    private int xPos;
    private int yPos;
    private int size;
    private float innerOffsetX;
    private float innerOffsetY;
    float innerScalePercent;
    int color1;
    int color2;

    public NestedCircle(PApplet processing, float scaler, ColorScheme colorScheme){
        this.processing = processing;
        this.scaler = scaler;
        this.colorScheme = colorScheme;


        size = (int)processing.random(20) + 15;
        xPos = (int) processing.random(100 - size) + size/2;
        yPos = (int) processing.random(100 - size) + size/2;
        System.out.println("size: "+ size + " " + (100-size) + " x" + xPos + " y" + yPos + "  " + xPos*scaler + " ree " + yPos*scaler);
        innerOffsetX =  processing.random(1);
        innerOffsetY =  processing.random(1);
        innerScalePercent = (processing.random(40) + 40)/100;
        //schwarz weiss vorerst
        color1 = colorScheme.getMonochrome();
        color2 = colorScheme.getMonochrome();
    }

    public void draw(){
        processing.pushMatrix();
        processing.noStroke();
        processing.translate(xPos*scaler,yPos*scaler);
        int position = processing.CENTER;
        processing.ellipseMode(position);  // Set ellipseMode to CENTER
        processing.fill(color1);  // Selects white or black
        //circles are 1/3rd to 1/8th of the canvas
        processing.ellipse(0, 0, scaler*size, scaler*size);

        processing.translate(scaler*innerOffsetX, scaler*innerOffsetY);
        processing.fill(color2);
        processing.ellipse(0, 0, scaler*size*innerScalePercent, scaler*size*innerScalePercent);
     /*   processing.stroke(255,0,0);
        processing.strokeWeight(40);
        processing.line(0,0,50,50);
        processing.noStroke();  */
        processing.popMatrix();
    }



}
