package uno.joueurs;

import java.util.ArrayList;
import java.util.List;

import uno.Partie;
import uno.cartes.Carte;

public abstract class Joueur implements EtatJoueur {
    private List<JoueurObserver> observers; // listes des parties auxquelles le joueur participe
    protected String nom; // nom du joueur
    protected ArrayList<Carte> deck; // main du joueur

    public void piocher() {
        deck.add(Partie.getCarte());
    } // Le joueur une carte

    public abstract void jouerCarte(); // Le joueur joue une carte

    //TODO: A supprimer, permet de tester le fonctionnement des cartes
    public Integer getNombreCartes() {
        return deck.size();
    } // Retourne le nombre de cartes du joueur

    public String getNom() {
        return nom;
    } // Retourne le nom du joueur

    public ArrayList<Carte> getDeck() {
    	return deck;
    } // Retourne la main du joueur

    @Override
    public String toString() {
        // Retourne le nom du joueur et le nombre de cartes qu'il possède
        return nom + " possede " + deck.size() + " cartes";
    }

    public List<JoueurObserver> getObservers() {
        // Retourne la liste des parties auxquelles le joueur participe
        return observers;
    }

    public boolean equals(Joueur joueur) {
        // Retourne true si le joueur est le même que celui passé en paramètre, les noms sont uniques
    	return this.nom.equals(joueur.getNom());
    }
}
