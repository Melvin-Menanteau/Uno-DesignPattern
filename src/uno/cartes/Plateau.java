package uno.cartes;

import java.util.Collections;
import java.util.ArrayList;
import uno.Partie;

public class Plateau {
    private CarteBuilder carteBuilder;
    private ArrayList<Carte> cartesDisponible = new ArrayList<>();

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

    public Carte getCarte() {
        //TODO: Gerer le cas ou il n'y a plus de carte a piocher (creer une liste avec toutes les cartes deja jouees, puis les melangees et les reutilisees?)
        if (cartesDisponible.size() > 0)
            return cartesDisponible.remove(0);

        return null;
    }

    public ArrayList<Carte> getCartes() {
        return cartesDisponible;
    }
}
