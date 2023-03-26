package uno.comportement;

import uno.Partie;
import uno.joueurs.Joueur;

public class ComportementCartePlus implements ComportementCarte {
    private int nbCartePlus;
    private Partie partie;

    public ComportementCartePlus(int nbCartePlus, Partie partie) {
        this.nbCartePlus = nbCartePlus;
        this.partie = partie;
    }


    @Override
    public void jouerCarte() {
        System.out.println("Carte Plus");
        for (int i = 0; i < nbCartePlus; i++) {
            partie.getJoueurSuivant().piocher();
        }
    }
}