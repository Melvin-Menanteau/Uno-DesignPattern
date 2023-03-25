package cartes;

import comportement.ComportementCarte;



public class Carte {
    enum Couleur {
        ROUGE, BLEU, VERT, JAUNE, NOIR
    }
    private Couleur couleur;
    private Integer valeur;

    private ComportementCarte comportementCarte;

    public Carte(Couleur couleur, Integer valeur, ComportementCarte comportementCarte) {
        this.couleur = couleur;
        this.valeur = valeur;
        this.comportementCarte = comportementCarte;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Integer getValeur() {
        return valeur;
    }
    public ComportementCarte getComportement() {
        return comportementCarte;
    }
}
