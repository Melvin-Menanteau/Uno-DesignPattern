package uno.cartes;

import java.util.Collections;
import java.util.ArrayList;
import uno.Partie;

public class Plateau {
    private CarteBuilder carteBuilder;
    private ArrayList<Carte> cartesDisponible = new ArrayList<>();
    private Carte carteCourante;
    private ArrayList<Carte> cartesJouees = new ArrayList<>();

    public Plateau(Partie partie) {
        carteBuilder = new CarteBuilder(partie);

        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            if (couleur != Carte.Couleur.NOIR) {
                for (int i = 0; i < 10; i++) {
                    carteBuilder.reset();
                    carteBuilder.setCouleur(couleur);
                    carteBuilder.setValeur(i);
                    cartesDisponible.add(carteBuilder.build());
                }

                for (Carte.Action action : Carte.Action.values()) {
                    if (action == Carte.Action.PLUS4 || action == Carte.Action.COULEUR)
                        continue;

                    carteBuilder.reset();
                    carteBuilder.setCouleur(couleur);
                    carteBuilder.setComportement(action);
                    cartesDisponible.add(carteBuilder.build());
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            carteBuilder.reset();
            carteBuilder.setComportement(Carte.Action.PLUS4);
            cartesDisponible.add(carteBuilder.build());

            carteBuilder.reset();
            carteBuilder.setComportement(Carte.Action.COULEUR);
            cartesDisponible.add(carteBuilder.build());
        }

        Collections.shuffle(cartesDisponible);
    }

    public void setCarteCourante(Carte carte) {
        cartesJouees.add(carteCourante);
        carteCourante = carte;
    }

    public Carte getCarte() {
        if (cartesDisponible.size() == 0) {
            cartesDisponible.addAll(cartesJouees);
            cartesJouees.clear();
            Collections.shuffle(cartesDisponible);
        }

        return cartesDisponible.remove(0);
    }

    public ArrayList<Carte> getCartes() {
        return cartesDisponible;
    }
}
