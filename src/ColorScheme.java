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

    private int color0;
    private int color1;
    private int color2;
    private int color3;
    private int color4;
    private int color5;
    private int color6;
    private int color7;
    private int color8;
    private int color9;

    PApplet processing;

    public ColorScheme(PApplet processing) {

        color0 = processing.color(0);
        color1 = processing.color(255);

        this.processing = processing;
    }

    public int getColor0() {
        return color0;
    }

    public int getColor1() {
        return color1;
    }

    public int getColor2() {
        return color2;
    }

    public int getColor3() {
        return color3;
    }

    public int getColor4() {
        return color4;
    }

    public int getColor5() {
        return color5;
    }

    public int getColor6() {
        return color6;
    }

    public int getColor7() {
        return color7;
    }

    public int getColor8() {
        return color8;
    }

    public int getColor9() {
        return color9;
    }

    public int getMonochrome(){
        float i = processing.random(1);
        if(i<0.5)
            return 0;
        else
            return 255;
    }

}