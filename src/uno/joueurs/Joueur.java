package uno.joueurs;

import java.util.ArrayList;
import uno.cartes.Carte;

public abstract class Joueur implements EtatJoueur {
    protected String nom;
    protected ArrayList<Carte> deck;

    // Je ne sais pas si il faut passer une carte a cette fonction, je suis passe par une methode static pour obtenir
    // une carte depuis le paquet mais honetement je ne sais pas si c'est la bonne facon de faire
    public abstract void piocher();

    // jouerCarte() ne prend pas de parametre, c'est dans cette fonction qu'il faut justement trouver la carte a jouer
    public abstract void jouerCarte();

    //TODO: A supprimer, permet de tester le fonctionnement des cartes
    public Integer getNombreCartes() {
        return deck.size();
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + " possede " + deck.size() + " cartes";
    }
}
