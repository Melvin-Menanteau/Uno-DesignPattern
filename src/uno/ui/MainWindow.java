package uno.ui;

import javax.swing.*;
public class MainWindow {
    static JFrame frame = new JFrame("UNO-DesignPattern");
    public static void MainWindow(Integer hauteur, Integer largeur) {
        frame.setSize(hauteur, largeur);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
