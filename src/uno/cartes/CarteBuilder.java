package uno.cartes;

import uno.comportement.*;

public class CarteBuilder implements CarteBuilderInterface {
    private Carte carte;
    private Carte.Couleur couleur;
    private Integer valeur;
    private ComportementCarte comportementCarte;

    public CarteBuilder() {
        this.reset();
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
        switch (action) {
            case INVERSION:
                this.comportementCarte = new ComportementCarteInversion();
                break;
            case COULEUR:
                this.comportementCarte = new ComportementCarteCouleur();
                break;
            case BLOQUE:
                this.comportementCarte = new ComportementCarteBloque();
                break;
            case PLUS2:
            case PLUS4:
                //TODO: Nombre de carte a piocher en parametre?
                this.comportementCarte = new ComportementCartePlus();
                break;
            default:
                this.comportementCarte = null;
                break;
        }
        return this;
    }
}
