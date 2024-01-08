package kolokwium.Signal;

import kolokwium.GUI.Main;
import kolokwium.GUI.MainWindow;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class RectSignal {
    private int freq;
    private int amplitude;
    private Color color;
    private ArrayList<Drganie> drgania;
    private int drganieLength;


    public RectSignal(int freq, int amplitude, Color color){
        this.freq = freq;
        this.amplitude = amplitude;
        this.color = color;
        drgania = new ArrayList<>();
        drganieLength = MainWindow.WIDTH / freq * 2;
        drgania.add(new Drganie(MainWindow.WIDTH - drganieLength, (MainWindow.HEIGHT - amplitude)/2, drganieLength/2, amplitude, color));
    }

    public void draw(Graphics g){
        for(Drganie drgania : drgania){
            drgania.draw(g);
        }
    }

    public void updatePanel(){
        for(Drganie drganie : drgania){
            drganie.updateDx();
        }

        Drganie lastDrganie = drgania.get(drgania.size() - 1);
        if(lastDrganie.getX() + drganieLength < MainWindow.WIDTH)
            drgania.add(new Drganie(lastDrganie.getX() + drganieLength, (MainWindow.WIDTH - amplitude)/2, drganieLength/2, amplitude, color));

        Drganie firstDrganie = drgania.get(0);
        if(firstDrganie.getX() + drganieLength < 0)
            drgania.remove(firstDrganie);
    }

}
