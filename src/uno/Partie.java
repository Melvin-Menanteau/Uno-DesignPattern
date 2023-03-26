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
    private boolean sensRotationHoraire = true;
    static private Plateau plateau;

    static public Carte getCarte() {
        return plateau.getCarte();
    }

    public Partie(Integer nombreJoueurs) {
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

            joueurs.get(i).rejoindrePartie(this);

            // main de départ
            for (int j = 0; j < 7; j++) {
                joueurs.get(i).piocher();
            }
        }

        while (!estTerminee) {
            joueurs.get(joueurCourant).jouerCarte();
            setJoueurSuivant();
        }
    }

    @Override
    public void update() {
        System.out.println("Le joueur " + joueurs.get(joueurCourant).getNom() + " a gagné");
        // termine la partie si un joueur a gagné
        estTerminee = true;
    }

    public void setCarteCourante(Carte carte) {
        plateau.setCarteCourante(carte);
    }

    public Joueur getJoueurSuivant() {
        Integer joueurSuivant;

        if (sensRotationHoraire) {
            joueurSuivant = (joueurCourant + 1);
            if (joueurSuivant >= joueurs.size()) joueurSuivant = 0;
        } else {
            joueurSuivant = (joueurCourant - 1);
            if (joueurSuivant < 0) joueurSuivant = (joueurs.size() - 1);
        }

        return joueurs.get(joueurSuivant);
    }

    public void inverserSensRotation() {
        sensRotationHoraire = !sensRotationHoraire;
    }

    public void setJoueurSuivant() {
        if (sensRotationHoraire) {
            joueurCourant++;
            if (joueurCourant >= joueurs.size()) joueurCourant = 0;
        }
        else {
            joueurCourant--;
            if (joueurCourant < 0) joueurCourant = joueurs.size() - 1;
        }
    }

    public Carte getCarteCourante() {
        return plateau.getCarteCourante();
    }
}
