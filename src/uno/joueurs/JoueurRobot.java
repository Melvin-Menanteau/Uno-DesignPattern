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
        deck.add(Partie.getCarte());
    }

    // comportement du robot
    @Override
    public void jouerCarte() {
        System.out.println("Joueur " + nom + " joue " + deck.get(0) + " " + deck.size() + " cartes restantes");
        boolean carteJouee = false;
        // le robot joue la première carte qu'il peut jouer
        for (Carte carte : deck) {
            if (carte.isCarteJouable()) {
                carte.jouerCarte();
                deck.remove(carte);
                carteJouee = true;
                break;
            }
        }
        // le robot n'a pas pu jouer de carte
        if (!carteJouee) {
            piocher();
        }
        // le robot a gagné
        if (deck.size() == 0) notifyParties();
    }

    public String getNom() {
        return nom;
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
