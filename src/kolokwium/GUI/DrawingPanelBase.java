package kolokwium.GUI;

import kolokwium.Signal.RectSignal;

import javax.swing.*;
import java.awt.*;

public class DrawingPanelBase extends JPanel {
    private RectSignal rectSignal;
    private int delay = 400;
    private String threadName;

    public DrawingPanelBase(RectSignal rectSignal, String threadName){
        this.rectSignal = rectSignal;
        this.threadName = threadName;
        setSize(MainWindow.WIDTH / 3, MainWindow.HEIGHT);
        threadStart();
    }


    private void threadStart(){
        Thread firstSignal = new Thread(() -> {
            while(true) {
                try {
              //  System.out.println(threadName + " is currently working!");
                rectSignal.updatePanel();
                repaint();
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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, MainWindow.WIDTH, MainWindow.HEIGHT);
        rectSignal.draw(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, MainWindow.HEIGHT/2, MainWindow.WIDTH, MainWindow.HEIGHT/2);
    }

}
