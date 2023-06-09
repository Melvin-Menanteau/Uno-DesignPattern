package uno.comportement;

import uno.Partie;
import uno.cartes.Carte;
import uno.joueurs.Joueur;

public class ComportementCartePlus implements ComportementCarte {
    private int nbCartePlus;
    private Partie partie;

    public ComportementCartePlus(int nbCartePlus, Partie partie) {
        this.nbCartePlus = nbCartePlus;
        this.partie = partie;
    }

    public int getNbCartePlus() {
        return nbCartePlus;
    }

    @Override
    public void jouerCarte() {
        // Fais piocher le joueur suivant
        Joueur joueurSuivant = partie.getJoueurSuivant();

        for (int i = 0; i < nbCartePlus; i++) {
            joueurSuivant.piocher();
        }
    }

    @Override
    public Carte.Action getType() {
        return Carte.Action.PLUS2;
    }
}