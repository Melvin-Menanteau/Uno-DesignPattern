import joueurs.Joueur;
import joueurs.JoueurObserver;

public class PartieUno implements JoueurObserver {

    private Joueur[] joueurs;
    private boolean partieTerminee;

    @Override
    public void update() {
        // termine la partie si un joueur a gagné
    }
}
