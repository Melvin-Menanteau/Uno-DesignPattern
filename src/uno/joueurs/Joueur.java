package uno.joueurs;

import java.util.ArrayList;

import uno.Partie;
import uno.cartes.Carte;

public abstract class Joueur implements EtatJoueur {
    protected String nom;
    protected ArrayList<Carte> deck;

    // Je ne sais pas si il faut passer une carte a cette fonction, je suis passe par une methode static pour obtenir
    // une carte depuis le paquet mais honetement je ne sais pas si c'est la bonne facon de faire
    public void piocher() {
        deck.add(Partie.getCarte());
    }

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
