package kolokwium.GUI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        initUI();
    }


    private void initUI(){
        setTitle("Rectangle signal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);

        JPanel sliderPanel = new JPanel();
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JSlider freqSlider = new JSlider(0, 1000000,0);
        JSlider amplitudeSlider = new JSlider(0, 150000, 0);
        JSlider wypSlider = new JSlider(0, 150000, 0);
        JLabel freqLabel = new JLabel("Freq: ");
        JLabel amplitLabel = new JLabel("Amplituda: ");
        JLabel wypLabel = new JLabel("Wypelnienie: ");

        controlPanel.setLayout(new GridLayout(2, 4));
        sliderPanel.setLayout(new GridLayout(3, 2));
        sliderPanel.add(freqLabel);
        sliderPanel.add(freqSlider);
        sliderPanel.add(amplitLabel);
        sliderPanel.add(amplitudeSlider);
        sliderPanel.add(wypLabel);
        sliderPanel.add(wypSlider);
        controlPanel.add(sliderPanel);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
