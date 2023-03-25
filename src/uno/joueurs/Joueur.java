package uno.joueurs;

import java.util.ArrayList;
import uno.cartes.Carte;

public abstract class Joueur implements EtatJoueur {
    protected String nom;
    // J'ai renomme main en deck pour eviter la confusion avec la classe/fonction Main
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
    @Override
    public String toString() {
        return nom + " possede " + deck.size() + " cartes";
    }
}
