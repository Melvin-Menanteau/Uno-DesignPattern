package uno.joueurs;

import uno.Partie;
import uno.cartes.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoueurHumain extends Joueur{
    private static Scanner scanner = new Scanner(System.in);

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
        afficherCartes();

        Integer indexCarte = null;

        do {
            System.out.println("Choisir une carte jouable : ");
            indexCarte = (scanner.nextInt() - 1);
        } while(!deck.get(indexCarte).isCarteJouable());

        // afficher la carte jouée
        System.out.println("Joueur " + nom + " joue : " );
        deck.get(indexCarte).drawCarte();

        // jouer la carte
        deck.get(indexCarte).jouerCarte();
        deck.remove(deck.get(indexCarte));


        System.out.println(deck.size() + " cartes restantes");


        if (deck.size() == 0) notifyParties();
    }

    private void afficherCartes() {
        System.out.println("Liste des cartes disponibles : ");
          int i = 1;
        for (Carte carte : deck) {
            System.out.println(i + " : " );
            carte.drawCarte();
            i++;
        }
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
