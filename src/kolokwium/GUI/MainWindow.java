package kolokwium.GUI;

import kolokwium.Signal.RectSignal;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static int WIDTH = 900;
    public static int HEIGHT = 900;

    private DrawingPanelBase drganie1, drganie2, drganie3;


    public MainWindow(){
        initUI();
    }


    private void initUI(){
        setTitle("Rectangle signal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(MainWindow.WIDTH, MainWindow.HEIGHT));
        setLayout(new GridLayout(1, 3));
        setLocationRelativeTo(null);

        RectSignal rectSignal1 = new RectSignal(3, 30,Color.RED, "Worker1");
        drganie1 = new DrawingPanelBase(rectSignal1, "Worker1");
        add(drganie1);
       RectSignal rectSignal2 = new RectSignal(15, 20,Color.GREEN, "Worker2");
        drganie2 = new DrawingPanelBase(rectSignal2, "Worker2");
        add(drganie2);
        RectSignal rectSignal3 = new RectSignal(18,50, Color.MAGENTA, "Worker3");
        drganie3 = new DrawingPanelBase(rectSignal3, "Worker3");
        add(drganie3);

        setVisible(true);
    }
}
