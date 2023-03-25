package uno.cartes;

import uno.comportement.*;

public class CarteBuilder implements CarteSimple {
    private Carte carte;
    private Carte.Couleur couleur;
    private Integer valeur;
    private ComportementCarte comportementCarte;

    public Carte build() {
        return new Carte(this.couleur, this.valeur, this.comportementCarte);
    }

    public CarteBuilder setCouleur(Carte.Couleur couleur) {
        this.couleur = couleur;
        return this;
    }

    public CarteBuilder setValeur(Integer valeur) {
        this.valeur = valeur;
        return this;
    }

    public CarteBuilder setComportement(String action) {
        switch (action) {
            case "inversion":
                this.comportementCarte = new ComportementCarteInversion();
                break;
            case "couleur":
                this.comportementCarte = new ComportementCarteCouleur();
                break;
            case "bloque":
                this.comportementCarte = new ComportementCarteBloque();
                break;
            default:
                this.comportementCarte = null;
                break;
        }
        this.comportementCarte = comportementCarte;
        return this;
    }
}
