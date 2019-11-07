import processing.core.PApplet;

public class CheckerBoard {
    //Todo
    PApplet processing;
    int color1;
    int color2;
    int color3;
    int[][] checkerColor = new int[20][20];
    int iterator = 1;
    int patternLength = 3;

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
    }

}
