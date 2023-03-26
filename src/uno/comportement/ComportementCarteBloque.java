package uno.comportement;

import uno.Partie;

public class ComportementCarteBloque implements ComportementCarte {

    private Partie partie;

    public ComportementCarteBloque(Partie partie) {
        this.partie = partie;
    }

    @Override
    public void jouerCarte() {
        partie.setJoueurSuivant();
    };
}