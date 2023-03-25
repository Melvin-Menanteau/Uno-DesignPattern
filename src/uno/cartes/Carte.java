package uno.cartes;

import uno.comportement.ComportementCarte;

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

    public static String getCouleurString(Couleur couleur) {
        switch (couleur) {
            case ROUGE:
                return "Rouge";
            case BLEU:
                return "Bleu";
            case VERT:
                return "Vert";
            case JAUNE:
                return "Jaune";
            case NOIR:
                return "Noir";
            default:
                return "Oupsi";
        }
    }

    public Integer getValeur() {
        return valeur;
    }
    public ComportementCarte getComportement() {
        return comportementCarte;
    }
}
