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

    public void setTheme2(){
        colors[0] = processing.color(0);
        colors[1] = processing.color(255);
        colors[2] = processing.color(0);
        colors[3] = processing.color(255);
        colors[4] = processing.color(0);
        colors[5] = processing.color(255);
        colors[6] = processing.color(0);
        colors[7] = processing.color(255);
        colors[8] = processing.color(0);
        colors[9] = processing.color(255);
    }

    public void setTheme3(){
        colors[0] = processing.color(201,167,77);
        colors[1] = processing.color(93,96,26);
        colors[2] = processing.color(150,64,34);
        colors[3] = processing.color(92,53,46);
        colors[4] = processing.color(57,78,80);
        colors[5] = processing.color(54,123,47);
        colors[6] = processing.color(39,49,48);
        colors[7] = processing.color(55,87,99);
        colors[8] = processing.color(83,42,36);
        colors[9] = processing.color(161,109,23);
    }

    public void setTheme4(){
        colors[0] = processing.color(168,156,139);
        colors[1] = processing.color(218,151,66);
        colors[2] = processing.color(134,70,42);
        colors[3] = processing.color(70,41,38);
        colors[4] = processing.color(50,65,47);
        colors[5] = processing.color(111,136,133);
        colors[6] = processing.color(68,34,32);
        colors[7] = processing.color(247,238,202);
        colors[8] = processing.color(99,106,98);
        colors[9] = processing.color(28,28,28);
    }

    public void setTheme5(){
        colors[0] = processing.color(22,21,28);
        colors[1] = processing.color(252,251,247);
        colors[2] = processing.color(186,84,57);
        colors[3] = processing.color(6,3,24);
        colors[4] = processing.color(115,75,107);
        colors[5] = processing.color(58,74,108);
        colors[6] = processing.color(104,38,12);
        colors[7] = processing.color(220,176,122);
        colors[8] = processing.color(217,128,46);
        colors[9] = processing.color(110,35,11);
    }

    public int[] getColors() {
        return colors;
    }
}