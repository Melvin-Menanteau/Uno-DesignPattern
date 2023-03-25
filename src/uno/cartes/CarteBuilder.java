package cartes;

import comportement.Comportement;

public class CarteBuilder implements CarteSimple {
    String couleur;
    String valeur;
    Comportement comportement;

    public CarteBuilder couleur(String couleur) {
        this.couleur = couleur;
        return this;
    }

    public CarteBuilder valeur(String valeur) {
        this.valeur = valeur;
        return this;
    }

    public CarteBuilder comportement(Comportement comportement) {
        this.comportement = comportement;
        return this;
    }

    public Carte build() {
        return new Carte(this);
    }
}
