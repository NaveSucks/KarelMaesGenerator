import processing.core.PApplet;

public class CheckerBoard {
    //Todo
    private PApplet processing;
    private int color1;
    private int color2;
    private int color3;
    private int[][] checkerColor = new int[20][20];
    private int iterator = 1;
    private int lastMouseX;
    private int lastMouseY;
    private int offsetX;
    private int offsetY;
    private int maxDistort = 10;

    public CheckerBoard(PApplet processing, ColorScheme colorScheme) {

        this.processing = processing;
        color1 = colorScheme.getColors()[7];
        color2 = colorScheme.getColors()[8];
        color3 = colorScheme.getColors()[9];

        for (int i = 0; i < checkerColor.length; i++) {
            for (int j = 0; j < checkerColor[0].length; j++) {
                if (iterator == 1) {
                    checkerColor[i][j] = color1;
                    iterator++;
                } else if (iterator < 3) {
                    checkerColor[i][j] = color2;
                    iterator++;
                } else {
                    checkerColor[i][j] = color3;
                    iterator = 1;
                }
            }
            //iterator++;
        }
    }

    public void draw(float xScaler, float yScaler) {

        processing.pushMatrix(); //start
        processing.translate(10 * xScaler, 10 * yScaler);
        float innerXScaler = xScaler * 0.8f;
        float innerYScaler = yScaler * 0.8f;

        for (int i = 0; i < checkerColor.length; i++) {
            for (int j = 0; j < checkerColor[0].length; j++) {

                processing.rectMode(processing.CORNER);
                processing.fill(checkerColor[i][j]);
                processing.rect(0, 0, innerXScaler * 5, innerYScaler * 5);
                processing.pushMatrix();                            //gets pushed 20 times
                processing.translate(innerXScaler * 5, 0);
            }
            for (int k = 0; k < checkerColor[0].length; k++) {
                processing.popMatrix();                             //gets popped 20 times
            }
            processing.translate(0, innerYScaler * 5);
        }

        processing.popMatrix(); //stop
/*
        int mouseX = processing.mouseX;
        offsetX -= (lastMouseX - mouseX);
        lastMouseX = mouseX;

        int mouseY = processing.mouseY;
        offsetY -= (lastMouseY - mouseY);
        lastMouseY = mouseY;

        if(offsetX>10) offsetX=20;
        else if(offsetX<-10) offsetX=-20;
        if(offsetY>10) offsetY=20;
        else if(offsetY<-10) offsetY=-20;

        processing.pushMatrix();
        processing.translate(10 * xScaler, 10 * yScaler);

        for (int i = 0; i < checkerColor.length; i+=3) {
            for (int j = 0; j < checkerColor[0].length; j+=3) {
                processing.fill(checkerColor[i][j]);

                //for(int l=0; l<Math.abs(offsetX); l+=4) {
                //    for (int m = 0; m < Math.abs(offsetY); m+=4) {
                //        if(offsetX<0) l = -l;
                //        if(offsetY<0) m = -m;
                        processing.rect(offsetX / 10.0f, offsetY / 10.0f, (innerXScaler * 5), innerYScaler * 5);
                //    }

                processing.pushMatrix();                            //gets pushed 20 times
                processing.translate(innerXScaler * 15, 0);
            }
            for (int k = 0; k < checkerColor[0].length; k+=3) {
                processing.popMatrix();                             //gets popped 20 times
            }
            processing.translate(0, innerYScaler * 15);
        }
        processing.popMatrix(); //stop */
    }

}
