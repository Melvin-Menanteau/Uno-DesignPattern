package uno.comportement;

import uno.Partie;
import uno.cartes.Carte;

public class ComportementCarteBloque implements ComportementCarte {

    private Partie partie;

    public ComportementCarteBloque(Partie partie) {
        this.partie = partie;
    }

    @Override
    public void jouerCarte() {
        // bloque le tour du joueur suivant
        partie.setJoueurSuivant();
    }

    @Override
    public Carte.Action getType() {
        return Carte.Action.BLOQUE;
    }

    ;
}