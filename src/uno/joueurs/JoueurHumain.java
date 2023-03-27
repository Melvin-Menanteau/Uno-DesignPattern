package uno.joueurs;

import uno.Partie;
import uno.cartes.Carte;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("Joueur " + nom + " pioche");
        deck.add(Partie.getCarte());
    }

    @Override
    public void jouerCarte() {
        // Methode tres basique pour tester le comportement des cartes
        System.out.println("Voici vos cartes : ");
        for (Carte carte : deck) {
            System.out.println("Carte " + ( deck.indexOf(carte) + 1 ) + " :" + (carte));
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle carte voulez-vous jouer ? (1-" + deck.size() + ")");
        int choix = sc.nextInt();
        if ( deck.get(choix-1).isCarteJouable()) {
            System.out.println("Joueur " + nom + " joue " + deck.get(choix - 1) + " " + deck.size() + " cartes restantes");
            deck.get(choix-1).jouerCarte();
            deck.remove(choix-1);
        } else {
            System.out.println("Vous ne pouvez pas jouer cette carte");
        }

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
