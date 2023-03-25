package uno;

import java.util.ArrayList;
import uno.joueurs.*;
import uno.cartes.Paquet;
import uno.cartes.Carte;

public class Partie implements JoueurObserver {

    private ArrayList<Joueur> joueurs;
    private boolean estTerminee;
    static private Paquet paquet;

    static public Carte getCarte() {
        return paquet.getCarte();
    }

    public  Partie(Integer nombreJoueurs) {
        System.out.println("Création de la partie");

        if (nombreJoueurs < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 joueurs");
        }

        paquet = new Paquet();

        /*
        paquet.getCartes().forEach(carte -> {
            System.out.println(carte);
        });
        */

        joueurs = new ArrayList<Joueur>();

        for (int i = 0; i < nombreJoueurs; i++) {
            if (i == 0)
                joueurs.add(new JoueurHumain("Joueur " + (i + 1)));
            else
                joueurs.add(new JoueurRobot("Robot " + (i + 1)));

            for (int j = 0; j < 7; j++) {
                joueurs.get(i).piocher();
            }
        }

        joueurs.forEach(joueur -> {
            System.out.println(joueur);

            while (joueur.getNombreCartes() > 0)
                joueur.jouerCarte();
        });
    }

    @Override
    public void update() {
        // termine la partie si un joueur a gagné
    }
}
