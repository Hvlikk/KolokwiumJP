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
    private String threadNumber;


    public RectSignal(int freq, int amplitude, Color color, String threadNumber){
        this.freq = freq;
        this.amplitude = amplitude;
        this.color = color;
        this.threadNumber = threadNumber;
        drgania = new ArrayList<>();
        drganieLength = MainWindow.WIDTH / 30;
        drgania.add(new Drganie(MainWindow.WIDTH - drganieLength, (MainWindow.HEIGHT - amplitude)/2, drganieLength/2, amplitude, color));
    }

    public void draw(Graphics g){
        for(Drganie drganie : drgania){
            drganie.draw(g);
        }
    }

    public void updatePanel(){
        for(Drganie drganie : drgania){
            drganie.updateDx();
        }

        Drganie lastDrganie = drgania.get(drgania.size() - 1);
        drgania.add(new Drganie(lastDrganie.getX() + drganieLength, (MainWindow.WIDTH - amplitude)/2, drganieLength/2, amplitude, color));
        System.out.println(threadNumber + " added new part! :)");
        Drganie firstDrganie = drgania.get(0);
        if(firstDrganie.getX() + drganieLength < 0)
            drgania.remove(firstDrganie);
    }

}
