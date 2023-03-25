import joueurs.Joueur;
import joueurs.JoueurObserver;

public class PartieUno implements JoueurObserver {

    private Joueur[] joueurs;
    private boolean partieTerminee;

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void update() {
        // termine la partie si un joueur a gagné
    }
}
