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

    public NestedCircle(PApplet processing, int[] localColors) {
        this.processing = processing;
        this.localColors = localColors;
        //innerOffsetX =  processing.random(1);
        //innerOffsetY =  processing.random(1);
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

    public void draw(float xSize, float ySize) {
        this.xSize = xSize;
        this.ySize = xSize;

        if (!isArray) {
            processing.fill(localColors[0]);
            processing.ellipse(0, 0, xSize, ySize);
            processing.fill(localInnerColors[1]);
            processing.ellipse(0, 0, xSize * innerScalePercent, ySize * innerScalePercent);
        } else {

            for (int i = 0; i < length; i++) {
                processing.pushMatrix();
                processing.fill(localColors[i]);
                processing.ellipse(0, 0, 100, 100);
                processing.fill(localInnerColors[length - i]);
                processing.ellipse(0, 0, xSize * innerScalePercent, ySize * innerScalePercent);
                processing.translate(xTrans * xSize, yTrans * ySize);
            }
            for (int i = 0; i < length; i++) {
                processing.popMatrix();
            }
        }
        //System.out.println(length);
        isArray = false;

    }

    public void doArray(int xPos, int yPos) {
        isArray = true;
        if (yPos < 50) yTrans = 1.5f;
        else if (yPos > 50) yTrans = -1;
    }
}
