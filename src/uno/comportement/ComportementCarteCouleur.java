package uno.comportement;

import uno.Partie;

public class ComportementCarteCouleur implements ComportementCarte {

    private Partie partie;

    public ComportementCarteCouleur(Partie partie) {
        this.partie = partie;
    }
    @Override
    public void jouerCarte() {
        // set the color of the next card
        System.out.println("Carte Couleur");
    };
}