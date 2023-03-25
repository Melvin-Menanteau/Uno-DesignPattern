package uno;

import java.util.ArrayList;
import uno.joueurs.*;
import uno.cartes.Paquet;

public class Partie implements JoueurObserver {

    private ArrayList joueurs;
    private boolean estTerminee;
    private Paquet paquet;

    public  Partie(Integer nombreJoueurs) {
        System.out.println("Création de la partie");

        if (nombreJoueurs < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 joueurs");
        }

        joueurs = new ArrayList<Joueur>();

        joueurs.add(new JoueurHumain("Joueur 1"));

        for (int i = 1; i < nombreJoueurs; i++) {
            joueurs.add(new JoueurRobot("Joueur " + (i + 1)));
        }

        paquet = new Paquet();

        paquet.getCartes().forEach(carte -> {
            System.out.println(carte);
        });
    }

    @Override
    public void update() {
        // termine la partie si un joueur a gagné
    }
}
