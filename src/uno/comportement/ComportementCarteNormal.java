package uno.comportement;

import uno.Partie;

public class ComportementCarteNormal implements ComportementCarte {
    @Override
    public void jouerCarte() {
        // Aucun effet pour cette carte
        System.out.println("Carte Normal");
    };
}