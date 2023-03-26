package uno.cartes;

import uno.comportement.*;
import uno.Partie;

public class CarteBuilder implements CarteBuilderInterface {
    private Partie partie;
    private Carte.Couleur couleur;
    private Integer valeur;
    private ComportementCarte comportementCarte;

    public CarteBuilder(Partie partie) {
        this.partie = partie;
        this.reset();
    }

    public Carte build() {
        return new Carte(this.partie, this.couleur, this.valeur, this.comportementCarte);
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
        switch (action) {
            case INVERSION:
                this.comportementCarte = new ComportementCarteInversion(partie);
                break;
            case COULEUR:
                this.comportementCarte = new ComportementCarteCouleur(partie);
                break;
            case BLOQUE:
                this.comportementCarte = new ComportementCarteBloque(partie);
                break;
            case PLUS2:
                this.comportementCarte = new ComportementCartePlus(2,partie);
                break;
            case PLUS4:
                this.comportementCarte = new ComportementCartePlus(4,partie);
                break;
            default:
                this.comportementCarte = null;
                break;
        }
        return this;
    }
}
