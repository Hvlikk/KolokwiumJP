package kolokwium.Signal;

import java.awt.*;

public class Drganie {
    private int x;
    private int y;
    private int length;
    private int amplitude;
    private static int dx; //
    private Color color;

    public Drganie(int x, int y, int length, int amplitude, Color color){
        this.x = x;
        this.y = y;
        this.length = length;
        this.amplitude = amplitude;
        this.color = color;
        dx = 10;
    }

    public int getX() {
        return x;
    }


    public void draw(Graphics g){
        int x = this.x;
        int y = this.y;
        g.setColor(color);
        g.drawLine(x, y, x + length, y);
        x += length;
        g.drawLine(x, y, x, y + amplitude);
        y += amplitude;
        g.drawLine(x, y, x + length, y);
        x += length;
        g.drawLine(x, y, x, y - amplitude);
        y -= amplitude;
    }

    public void updateDx(){
        x -= length;
    }
}
