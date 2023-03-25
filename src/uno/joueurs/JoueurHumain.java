package uno.joueurs;


import uno.cartes.Carte;

import java.util.ArrayList;

public class JoueurHumain implements Joueur{
    private String nom;
    private ArrayList<Carte> deck;



    public JoueurHumain(String nom) {
        System.out.println("Création joueur humain " + nom);

        this.nom = nom;
        this.deck = new ArrayList<Carte>();
    }

    @Override
    public void piocher(Carte carte) {
        deck.add(carte);
    }

    @Override
    public void jouerCarte(Carte carte) {
        carte.jouerCarte();
        deck.remove(carte);
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void rejoindrePartie(JoueurObserver observer) {

    }

    @Override
    public void quitterPartie(JoueurObserver observer) {

    }

    @Override
    public void notifyParties() {

    }
}
