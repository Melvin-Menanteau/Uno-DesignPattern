package joueurs;

import java.util.ArrayList;

public class JoueurRobot implements Joueur{
    private String nom;
    private ArrayList<Carte> main;

    public JoueurRobot(String nom) {
        this.nom = nom;
        this.main = new ArrayList<Carte>();
    }

    @Override
    public void piocher(Carte carte) {

    }

    @Override
    public void jouerCarte(Carte carte) {

    }
}
