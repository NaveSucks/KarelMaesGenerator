import processing.core.PApplet;

public class ColorScheme {
    /*
    Scheme1:

     156,    175,    182
     82,     110,    88
     114,    46,     37
     189,    125,    52
     148,    151,    113
     72,     39,     28
     40,     76,     90

     checker:
     179,    58,     52
     99,     36,     33
     19,     24,     16
    _____________________

    Scheme2:

   Todo

     */
    private int[] colors = new int[10];

    PApplet processing;

    public ColorScheme(PApplet processing) {
        this.processing = processing;
    }

    public int getMonochrome(){
        float i = processing.random(1);
        if(i<0.5)
            return 0;
        else
            return 255;
    }

    public void setTheme1(){
        colors[0] = processing.color(156,    175,    182);
        colors[1] = processing.color( 82,    110,     88);
        colors[2] = processing.color(114,     46,     37);
        colors[3] = processing.color(189,    125,     52);
        colors[4] = processing.color(148,    151,    113);
        colors[5] = processing.color( 72,     39,     28);
        colors[6] = processing.color( 40,     76,     90);
        colors[7] = processing.color(179,     58,     52);
        colors[8] = processing.color( 99,     36,     33);
        colors[9] = processing.color( 19,     24,     16);
    }

    public int[] getColors() {
        return colors;
    }
}