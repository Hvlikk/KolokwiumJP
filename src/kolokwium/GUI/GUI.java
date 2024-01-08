package kolokwium.GUI;

import javax.swing.*;

public class GUI {

    public void runApp(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
            }
        });
    }
}
