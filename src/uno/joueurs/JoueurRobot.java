package uno.joueurs;

import uno.Partie;
import uno.cartes.Carte;
import java.util.ArrayList;
import java.util.List;

public class JoueurRobot extends Joueur{

    // liste des parties auxquelles le joueur est inscrit
    private List<JoueurObserver> observers = new ArrayList<>();

    public JoueurRobot(String nom) {
        System.out.println("Création joueur robot " + nom);

        this.nom = nom;
        this.deck = new ArrayList<Carte>();
    }

    @Override
    public void piocher() {
        System.out.println("Joueur " + nom + " pioche");
        deck.add(Partie.getCarte());
    }

    // comportement du robot
    @Override
    public void jouerCarte() {

        boolean carteJouee = false;
        // le robot joue la première carte qu'il peut jouer
        for (Carte carte : deck) {
            if (carte.isCarteJouable()) {
                // jouer la carte
                carte.jouerCarte();
                deck.remove(carte);
                // afficher la carte jouée
                System.out.println("Joueur " + nom + " joue : " );
                carte.drawCarte();
                System.out.println(deck.size() + " cartes restantes");
                carteJouee = true;
                break;
            }
        }
        // le robot n'a pas pu jouer de cartes
        if (!carteJouee) {
            piocher();
        }

        // le robot a gagné
        if (deck.size() == 0) notifyParties();
    }

    public String getNom() {
        return nom;
    }

    //for test
    public List<JoueurObserver> getObservers() {
        return observers;
    }

    @Override
    public void rejoindrePartie(JoueurObserver observer) {
        observers.add(observer);
    }

    @Override
    public void quitterPartie(JoueurObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyParties() {
        observers.forEach(observer -> observer.update());
    }
}
