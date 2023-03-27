package uno.cartes;

import uno.comportement.*;
import uno.Partie;

public class CarteBuilder implements CarteBuilderInterface {
    private Partie partie; // partie associée à la carte
    private Carte.Couleur couleur; // couleur de la carte
    private Integer valeur; // valeur de la carte
    private ComportementCarte comportementCarte; // comportement de la carte

    public CarteBuilder(Partie partie) {
        this.partie = partie;
        this.reset();
    }

    // construit la carte
    public Carte build() {
        return new Carte(this.partie, this.couleur, this.valeur, this.comportementCarte);
    }

    public void reset() {
        // reset les valeurs par défaut
        this.couleur = Carte.Couleur.NOIR;
        this.valeur = 0;
        this.comportementCarte = new ComportementCarteNormal();
    }

    public CarteBuilder setCouleur(Carte.Couleur couleur) {
        // set la couleur de la carte
        this.couleur = couleur;
        return this;
    }

    public CarteBuilder setValeur(Integer valeur) {
        // set la valeur de la carte
        this.valeur = valeur;
        return this;
    }

    public CarteBuilder setComportement(Carte.Action action) {
        // set le comportement de la carte selon l'action passée en paramètre
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
                this.comportementCarte = new ComportementCarteNormal();
                break;
        }
        return this;
    }
}
