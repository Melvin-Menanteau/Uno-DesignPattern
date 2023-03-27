package uno.comportement;

import uno.Partie;
import uno.cartes.Carte;

public class ComportementCarteNormal implements ComportementCarte {
    @Override
    public void jouerCarte() {
        // Aucun effet pour cette carte
    }

    @Override
    public Carte.Action getType() {
        return Carte.Action.NORMAL;
    }

    ;
}