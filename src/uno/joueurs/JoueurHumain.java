package uno.joueurs;

import uno.cartes.Carte;
import java.util.ArrayList;
import uno.Partie;

public class JoueurHumain extends Joueur{
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
        deck.get(0).jouerCarte();
        deck.remove(0);
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
