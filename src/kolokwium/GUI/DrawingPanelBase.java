package kolokwium.GUI;

import kolokwium.Signal.RectSignal;

import javax.swing.*;
import java.awt.*;

public class DrawingPanelBase extends JPanel {
    private RectSignal rectSignal1, rectSignal2;
    private int delay = 1000;


    public DrawingPanelBase(){
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);

        Thread firstSignal = new Thread(() -> {
            rectSignal1 = new RectSignal(20, 10, Color.BLUE);
            while(true) {
                rectSignal1.updatePanel();
                repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        firstSignal.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        rectSignal1.draw(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, MainWindow.HEIGHT/2, MainWindow.WIDTH, MainWindow.HEIGHT/2);
    }

}
