package uno.comportement;

import uno.Partie;

public class ComportementCarteBloque implements ComportementCarte {

    private Partie partie;

    public ComportementCarteBloque(Partie partie) {
        this.partie = partie;
    }

    @Override
    public void jouerCarte() {
        // bloque le tour du joueur suivant
        System.out.println("Carte Bloque");
        partie.setJoueurSuivant();
    };
}