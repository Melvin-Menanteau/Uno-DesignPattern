package uno.comportement;

import uno.Partie;
import uno.cartes.Carte;

public class ComportementCarteInversion implements ComportementCarte {
    private Partie partie;

    public ComportementCarteInversion(Partie partie) {
        this.partie = partie;
    }
    @Override
    public void jouerCarte() {
        // inverse le sens de rotation des joueurs avec 2 joueurs cette carte n'a aucun effet
        partie.inverserSensRotation();
    }

    @Override
    public Carte.Action getType() {
        return Carte.Action.INVERSION;
    }

    ;
}