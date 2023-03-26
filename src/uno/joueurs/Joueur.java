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

    public void jouerCarte() {
        // Methode tres basique pour tester le comportement des cartes
        System.out.println("Joueur " + nom + " joue " + deck.get(0));
        deck.get(0).jouerCarte();
        deck.remove(0);
        if (deck.size() == 0) notifyParties();
    }

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
