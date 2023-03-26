package uno.cartes;

import uno.comportement.ComportementCarte;

public class Carte {
    enum Couleur {
        ROUGE, BLEU, VERT, JAUNE, NOIR
    }

    enum Action {
        INVERSION, BLOQUE, PLUS2, PLUS4, COULEUR, NORMAL
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

    public void jouerCarte() {
        comportementCarte.jouerCarte();
    }

    @Override
    public String toString() {
        return "Carte [couleur=" + couleur + ", valeur=" + valeur + ", action=" + comportementCarte + "]";
    }
}
