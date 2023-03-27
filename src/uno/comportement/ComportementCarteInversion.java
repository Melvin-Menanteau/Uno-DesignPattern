package uno.comportement;

import uno.Partie;

public class ComportementCarteInversion implements ComportementCarte {
    private Partie partie;

    public ComportementCarteInversion(Partie partie) {
        this.partie = partie;
    }
    @Override
    public void jouerCarte() {
        // inverse le sens de rotation des joueurs
        System.out.println("Carte Inversion");
        partie.inverserSensRotation();
    };
}