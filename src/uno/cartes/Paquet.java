package uno.cartes;

import java.util.ArrayList;

public class Paquet {
    private CarteBuilder carteBuilder = new CarteBuilder();
    private ArrayList<Carte> cartes = new ArrayList<Carte>();

    public Paquet() {
        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            if (couleur != Carte.Couleur.NOIR) {
                for (int i = 0; i < 10; i++) {
                    carteBuilder.reset();
                    carteBuilder.setCouleur(couleur);
                    carteBuilder.setValeur(i);
                    cartes.add(carteBuilder.build());
                }

                for (Carte.Action action : Carte.Action.values()) {
                    if (action == Carte.Action.PLUS4 || action == Carte.Action.COULEUR)
                        continue;

                    carteBuilder.reset();
                    carteBuilder.setCouleur(couleur);
                    carteBuilder.setComportement(action);
                    cartes.add(carteBuilder.build());
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            carteBuilder.reset();
            carteBuilder.setComportement(Carte.Action.PLUS4);
            cartes.add(carteBuilder.build());

            carteBuilder.reset();
            carteBuilder.setComportement(Carte.Action.COULEUR);
            cartes.add(carteBuilder.build());
        }
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
}
