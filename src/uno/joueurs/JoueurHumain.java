package uno.joueurs;

import uno.Partie;
import uno.cartes.Carte;
import java.util.ArrayList;
import java.util.List;

public class JoueurHumain extends Joueur{

    // liste des parties auxquelles le joueur est inscrit
    private List<JoueurObserver> observers = new ArrayList<>();

    public JoueurHumain(String nom) {
        System.out.println("Création joueur humain " + nom);

        this.nom = nom;
        this.deck = new ArrayList<Carte>();
    }

    @Override
    public void piocher() {
        deck.add(Partie.getCarte());
    }

    @Override
    public void jouerCarte() {
        // Methode tres basique pour tester le comportement des cartes
        System.out.println("Joueur " + nom + " joue " + deck.get(0));
        deck.get(0).jouerCarte();
        deck.remove(0);
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
