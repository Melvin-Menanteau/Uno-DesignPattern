package cartes;

import comportement.Comportement;

public class Carte {
    private String couleur;
    private String valeur;

    private Comportement comportement;

    public Carte(CarteBuilder carteBuilder) {
        this.couleur = carteBuilder.couleur;
        this.valeur = carteBuilder.valeur;
        this.comportement = carteBuilder.comportement;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getValeur() {
        return valeur;
    }
    public Comportement getComportement() {
        return comportement;
    }
}
