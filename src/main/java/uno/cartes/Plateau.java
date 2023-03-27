package uno.cartes;

import java.util.Collections;
import java.util.ArrayList;
import uno.Partie;

public class Plateau {
    private CarteBuilder carteBuilder;
    // La pioche contenant les cartes encore disponible
    private ArrayList<Carte> pioche = new ArrayList<>();
    // La dernière carte qui a été jouée
    private Carte carteCourante;
    // La liste des cartes qui ont déjà été jouées.
    // Permet de remplir la pioche une fois que cette dernière est vide
    private ArrayList<Carte> cartesJouees = new ArrayList<>();

    public Plateau(Partie partie) {
        carteBuilder = new CarteBuilder(partie);

        // Création de l'ensemble des cartes du jeu

        // Création des cartes ayant une couleur
        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            if (couleur != Carte.Couleur.NOIR) {
                for (int i = 0; i < 10; i++) {
                    carteBuilder.reset();
                    carteBuilder.setCouleur(couleur);
                    carteBuilder.setValeur(i);
                    pioche.add(carteBuilder.build());

                    // Les cartes ayant une couleur et n'étant pas 0 sont présente deux fois dans le jeu
                    // il faut donc l'ajouter deux fois
                    if (i != 0) pioche.add(carteBuilder.build());
                }

                for (Carte.Action action : Carte.Action.values()) {
                    if (action == Carte.Action.PLUS4 || action == Carte.Action.COULEUR)
                        continue;

                    carteBuilder.reset();
                    carteBuilder.setCouleur(couleur);
                    carteBuilder.setComportement(action);
                    pioche.add(carteBuilder.build());
                    // De la même manière, ajouter deux fois la carte
                    pioche.add(carteBuilder.build());
                }
            }
        }

        // Création des cartes noires (plus4 / changement couleur)
        for (int i = 0; i < 4; i++) {
            carteBuilder.reset();
            carteBuilder.setComportement(Carte.Action.PLUS4);
            pioche.add(carteBuilder.build());

            carteBuilder.reset();
            carteBuilder.setComportement(Carte.Action.COULEUR);
            pioche.add(carteBuilder.build());
        }

        // Mélanger la liste de cartes
        Collections.shuffle(pioche);
    }

    // Changer la carte jouée, et ajouter la carte précedente à la liste de cartes déjà jouées
    public void setCarteCourante(Carte carte) {
        cartesJouees.add(carteCourante);
        carteCourante = carte;
    }

    // Obtenir la dernière carte jouée, permet de vérifier que la carte que l'on souhaite jouée est valide
    public Carte getCarteCourante() {
        return carteCourante;
    }

    // Permet de pioche une carte
    public Carte getCarte() {
        if (pioche.size() == 0) {
            pioche.addAll(cartesJouees);
            cartesJouees.clear();
            Collections.shuffle(pioche);
        }

        return pioche.remove(0);
    }

    // use for testing
    public ArrayList<Carte> getCartesJouees() {
        return cartesJouees;
    }

    // use for testing
    public ArrayList<Carte> getPioche() {
        return pioche;
    }
}
