package uno;


import uno.cartes.Carte;
import uno.cartes.Plateau;
import uno.joueurs.Joueur;
import uno.joueurs.JoueurHumain;
import uno.joueurs.JoueurObserver;
import uno.joueurs.JoueurRobot;

import java.util.ArrayList;

public class Partie implements JoueurObserver {

    private ArrayList<Joueur> joueurs;
    private boolean estTerminee;
    private Integer joueurCourant = 0;
    static private Plateau plateau;

    static public Carte getCarte() {
        return plateau.getCarte();
    }

    public  Partie(Integer nombreJoueurs) {
        System.out.println("Création de la partie");

        if (nombreJoueurs < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 joueurs");
        }

        plateau = new Plateau(this);

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

            // main de départ
            for (int j = 0; j < 7; j++) {
                joueurs.get(i).piocher();
            }
        }

        joueurs.forEach(joueur -> {
            System.out.println(joueur);
            joueur.rejoindrePartie(this);

            while (joueur.getNombreCartes() > 0 && !estTerminee)
                joueur.jouerCarte();
        });
    }

    @Override
    public void update() {
        // termine la partie si un joueur a gagné
        estTerminee = true;
    }
}
