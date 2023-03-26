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
        // fais piocher au joueur suivant
        System.out.println("Carte Plus");
        Joueur joueurSuivant = partie.getJoueurSuivant();

        for (int i = 0; i < nbCartePlus; i++) {
            joueurSuivant.piocher();
        }
    }
}