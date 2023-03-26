package uno.cartes;


import uno.comportement.*;

import java.util.HashMap;
import java.util.Map;

public class CarteBuilder implements CarteBuilderInterface {
    private Carte carte;
    private Carte.Couleur couleur;
    private Integer valeur;
    private ComportementCarte comportementCarte;

    // factory to create comportementCarte
    private Map<Carte.Action, ComportementCarteFactory> comportementCarteFactories;

    public CarteBuilder() {
        this.reset();
        // Initialize the map of ComportementCarte factories
        comportementCarteFactories = new HashMap<>();
        comportementCarteFactories.put(Carte.Action.NORMAL, new ComportementCarteNormalFactory());
        comportementCarteFactories.put(Carte.Action.INVERSION, new ComportementCarteInversionFactory());
        comportementCarteFactories.put(Carte.Action.COULEUR, new ComportementCarteCouleurFactory());
        comportementCarteFactories.put(Carte.Action.BLOQUE, new ComportementCarteBloqueFactory());
        comportementCarteFactories.put(Carte.Action.PLUS2, new ComportementCartePlusFactory());
        comportementCarteFactories.put(Carte.Action.PLUS4, new ComportementCartePlusFactory());
    }

    public Carte build() {
        return new Carte(this.couleur, this.valeur, this.comportementCarte);
    }

    public void reset() {
        this.couleur = Carte.Couleur.NOIR;
        this.valeur = 0;
        this.comportementCarte = new ComportementCarteNormal();
    }

    public CarteBuilder setCouleur(Carte.Couleur couleur) {
        this.couleur = couleur;
        return this;
    }

    public CarteBuilder setValeur(Integer valeur) {
        this.valeur = valeur;
        return this;
    }

    public CarteBuilder setComportement(Carte.Action action) {
        this.comportementCarte = comportementCarteFactories.get(action).createComportementCarte();
        return this;
    }
}
