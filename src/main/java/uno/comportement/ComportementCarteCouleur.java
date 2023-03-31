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
            System.out.println("La couleur de la prochaine carte est : " + color);
            partie.setCouleurCourante(color);
        } else {
            Scanner sc = new Scanner(System.in);
            String couleur = "";
            // tant que l'utilisateur n'a pas entré une couleur valide
            while(!couleur.equals("jaune") && !couleur.equals("bleu") && !couleur.equals("vert") && !couleur.equals("rouge")) {
                System.out.print("Entrez une couleur (jaune, bleu, vert ou rouge) : ");
                couleur = sc.nextLine();
            }
            System.out.println("La couleur de la prochaine carte est : " + couleur);
            partie.setCouleurCourante(couleur);
        }

    }

    @Override
    public Carte.Action getType() {
        return Carte.Action.COULEUR;
    }

    ;
}