package uno.comportement;

import uno.Partie;
import uno.cartes.Carte;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ComportementCarteCouleur implements ComportementCarte {

    private Partie partie;

    public ComportementCarteCouleur(Partie partie) {
        this.partie = partie;
    }
    @Override
    public void jouerCarte() {
        // set the color of the next card
        if (partie.getJoueurCourant().getNom().contains("Robot")) {
            // genere une couleur aléatoirement parmis : rouge, bleu, jaune, vert
            List<String> colors = Arrays.asList("rouge", "bleu", "jaune", "vert");
            // genere un index aléatoire
            Random rand = new Random();
            int randomIndex = rand.nextInt(colors.size());
            // récupère la couleur correspondant à l'index
            String color = colors.get(randomIndex);
            partie.setCouleurCourante(color);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choisissez une couleur parmis : rouge , bleu , jaune , vert");
            String couleur = sc.nextLine();
            partie.setCouleurCourante(couleur);
        }

    }

    @Override
    public Carte.Action getType() {
        return Carte.Action.COULEUR;
    }

    ;
}