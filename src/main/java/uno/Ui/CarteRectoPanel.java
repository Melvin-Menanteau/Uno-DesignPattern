package uno.Ui;

import uno.cartes.Carte;

import javax.swing.*;

public class CarteRectoPanel extends JPanel {
    private Carte carte;

    public CarteRectoPanel(Carte carte) {
        this.carte = carte;
        ImageIcon imageIcon = new ImageIcon(carte.getImagePath());
        JLabel label = new JLabel(imageIcon);
        add(label);
    }
}
