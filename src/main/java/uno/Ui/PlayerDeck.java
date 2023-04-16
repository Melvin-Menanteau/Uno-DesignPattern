package uno.Ui;

import uno.cartes.Carte;
import uno.joueurs.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerDeck extends JPanel {

    private Joueur player;
    private ArrayList<Carte> playerDeck;

    public PlayerDeck(Joueur player) {
        this.player = player;
        this.playerDeck = player.getDeck();

        setLayout(new FlowLayout(FlowLayout.LEFT));
        for (Carte carte : playerDeck) {
            CarteRectoPanel cartePanel = new CarteRectoPanel(carte);

            add(cartePanel);
        }

    }
}