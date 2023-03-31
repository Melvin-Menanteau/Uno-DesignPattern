package uno.Ui;

import uno.cartes.Carte;
import uno.joueurs.Joueur;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class RobotDeck extends JPanel {

    private Joueur robot;
    private ArrayList<Carte> robotDeck;

    private boolean isIncline = false; // si on affiche la carte inclinée ou non

    public RobotDeck(Joueur robot, boolean isIncline) throws IOException {
        this.robot = robot;
        this.robotDeck = robot.getDeck();
        this.isIncline = isIncline;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        if (isIncline) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        for (Carte carte : robotDeck) {
            CarteVersoPanel cartePanel = new CarteVersoPanel(isIncline);
            System.out.println(carte);
            add(cartePanel);
        }

    }
}
