package uno;

import uno.cartes.Carte;
import uno.cartes.Plateau;
import uno.joueurs.Joueur;
import uno.joueurs.JoueurHumain;
import uno.joueurs.JoueurObserver;
import uno.joueurs.JoueurRobot;

import java.util.List;
import java.util.ArrayList;

public class Partie implements JoueurObserver {

    private ArrayList<Joueur> joueurs; // liste des joueurs
    private boolean estTerminee; // indique si la partie est terminée
    private Integer joueurCourant = 0; // index du joueur courant
    private boolean sensRotationHoraire = true; // sens de rotation des joueurs
    static private Plateau plateau; // représente le plateau de jeu contenant les cartes

    private String couleurCourante; // couleur de la carte couleur courante

    static public Carte getCarte() {
        return plateau.getCarte();
    }

    public Partie(Integer nombreJoueurs, String nomJoueur) {
        // initialise la partie avec le nombre de joueurs donné en paramètre
        System.out.println("Création de la partie");

        if (nombreJoueurs < 2) {
            throw new IllegalArgumentException("Il faut au moins 2 joueurs");
        }

        plateau = new Plateau(this);

        joueurs = new ArrayList<>();

        // création des joueurs
        for (int i = 0; i < nombreJoueurs; i++) {
            if (i == 0)
                joueurs.add(new JoueurHumain(nomJoueur ));
            else
                joueurs.add(new JoueurRobot("Robot " + (i + 1)));

            // subscribe les joueurs à la partie en cours
            joueurs.get(i).rejoindrePartie(this);

            // main de départ des joueurs
            for (int j = 0; j < 7; j++) {
                joueurs.get(i).piocher();
            }
        }
    }

    // lance la partie
    public void run() {
        while (!estTerminee) {
            joueurs.get(joueurCourant).jouerCarte();
            setJoueurSuivant();
        }
    }

    @Override
    public void update() {
        // termine la partie si un joueur a gagné -> sa main est vide

        estTerminee = true;
        System.out.println("Partie terminée !");
        for (Joueur joueur : joueurs) {
            if (joueur.getDeck().isEmpty()) {
                System.out.println("Le joueur " + joueur.getNom() + " a gagné !");
            }
        }
    }

    public void setCarteCourante(Carte carte) {
        // set la carte courante placer sur le plateau
        plateau.setCarteCourante(carte);
    }

    public Joueur getJoueurSuivant() {
        // retourne le joueur suivant en fonction du sens de rotation
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
        // inverse le sens de rotation des joueurs
        sensRotationHoraire = !sensRotationHoraire;
    }

    public void setJoueurSuivant() {
        // set le joueur suivant en fonction du sens de rotation
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
        // retourne la carte courante du plateau
        return plateau.getCarteCourante();
    }

    // utilisé pour les tests
    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    // utilisé pour les tests
    public Joueur getJoueurCourant() {
        return joueurs.get(joueurCourant);
    }

    // utilisé pour les tests
    public Plateau getPlateau() {
        return plateau;
    }

    // use for testing purposes
    public boolean isEstTerminee() {
        return estTerminee;
    }

    public void setCouleurCourante(String couleur) {
        // couleur peux être "rouge", "bleue", "jaune", "vert"
        if (!couleur.equals("rouge") && !couleur.equals("bleu") && !couleur.equals("jaune") && !couleur.equals("vert")) {
            throw new IllegalArgumentException("La couleur doit être rouge, bleu, jaune ou vert");
        }
        couleurCourante = couleur;
    }

    public String getCouleurCourante() {
        return couleurCourante;
    }
}
