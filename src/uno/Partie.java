package uno;

import uno.joueurs.Joueur;
import uno.joueurs.JoueurObserver;

public class Partie implements JoueurObserver {

    private Joueur[] joueurs;
    private boolean estTerminee;

    @Override
    public void update() {
        // termine la partie si un joueur a gagné
    }
}
