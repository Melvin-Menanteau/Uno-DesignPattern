package uno.comportement;

import uno.cartes.Carte;

public interface ComportementCarte {
    public void jouerCarte(); // Permet de jouer une carte

    public Carte.Action getType(); // Permet de récupérer le type de la carte
}
