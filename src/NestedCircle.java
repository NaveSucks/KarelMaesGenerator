import processing.core.PApplet;

public class NestedCircle {
    private PApplet processing;
    private float innerOffsetX;
    private float innerOffsetY;
    private float innerScalePercent;
    private int[] localColors;
    private int[] localInnerColors = new int[6];
    private boolean isArray = false;
    private float xSize;
    private float ySize;
    private int length;
    private float xTrans;
    private float yTrans;
    private int posX;
    private int posY;

    public NestedCircle(PApplet processing, int[] localColors, float xSize, float ySize) {
        setup(processing, localColors, xSize, ySize);
    }

    public NestedCircle(PApplet processing, int[] localColors, int posX, int posY, float xSize, float ySize) {
        setup(processing, localColors, xSize, ySize);
        this.posX = posX;
        this.posY = posY;
    }

    private void setup(PApplet processing, int[] localColors, float xSize, float ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.processing = processing;
        this.localColors = localColors;
        innerScalePercent = (processing.random(20) + 60) / 100;
        length = (int) processing.random(2) + 3;

        for (int i = 1; i < 6; i++) {
            int r = 5;
            while (r == 5) {
                r = (int) processing.random(5);
            }
            localInnerColors[i] = localColors[r];
        }
    }


    public void draw(Main main) {


        if (!isArray) {
            processing.fill(localColors[0]);
            processing.ellipse(0 + posX, 0 + posY, xSize * main.getxScaler(), ySize * main.getxScaler());
            processing.fill(localInnerColors[1]);
            processing.ellipse(0 + posX, 0 + posY, xSize * innerScalePercent * main.getxScaler(), ySize * innerScalePercent * main.getxScaler());
        } else {

            for (int i = 0; i < length; i++) {
                processing.pushMatrix();
                processing.fill(localColors[i]);
                processing.ellipse(0, 0, 100, 100);
                processing.fill(localInnerColors[length - i]);
                processing.ellipse(0, 0, xSize * innerScalePercent * main.getxScaler(), ySize * innerScalePercent * main.getxScaler());
                processing.translate(xTrans * xSize * main.getxScaler(), yTrans * ySize * main.getxScaler());
            }
            for (int i = 0; i < length; i++) {
                processing.popMatrix();
            }
        }
        isArray = false;
    }

    public void doArray(int xPos, int yPos) {
        isArray = true;
        if (yPos < 50) yTrans = 1.55f;
        else if (yPos > 50) yTrans = -1;
    }
}
