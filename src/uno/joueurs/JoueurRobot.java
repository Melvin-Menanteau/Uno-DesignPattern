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

    @Override
    public void jouerCarte() {
        boolean carteJouee = false;
        for (Carte carte : deck) {
            if (carte.isCarteJouable()) {
                carte.jouerCarte();
                deck.remove(carte);
                carteJouee = true;
                break;
            }
        }
        if (!carteJouee) {
            piocher();
        }
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
