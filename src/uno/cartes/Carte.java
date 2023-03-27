package uno.cartes;

import uno.comportement.ComportementCarte;
import uno.Partie;

public class Carte {
    public enum Couleur {
        // liste des couleurs possibles pour une carte
        ROUGE, BLEU, VERT, JAUNE, NOIR
    }

    public enum Action {
        // liste des actions possibles pour une carte
        INVERSION, BLOQUE, PLUS2, PLUS4, COULEUR, NORMAL
    }

    private Partie partie; // partie associée à la carte
    private Couleur couleur; // couleur de la carte
    private Integer valeur; // valeur de la carte
    private ComportementCarte comportementCarte; // comportement de la carte

    public Carte(Partie partie, Couleur couleur, Integer valeur, ComportementCarte comportementCarte) {
        // constructeur de la carte
        this.partie = partie;
        this.couleur = couleur;
        this.valeur = valeur;
        this.comportementCarte = comportementCarte;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public static String getCouleurString(Couleur couleur) {
        // retourne la couleur en string pour l'affichage
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
        // joue la carte
        partie.setCarteCourante(this);
        comportementCarte.jouerCarte();
    }

    @Override
    public String toString() {
        return "Carte [couleur=" + couleur + ", valeur=" + valeur + ", action=" + comportementCarte + "]";
    }

    public boolean isCarteJouable() {
        // vérifie si la carte est jouable
        return (
                partie.getCarteCourante().getCouleur() == this.getCouleur()
                        || partie.getCarteCourante().getValeur() == this.getValeur()
                        || partie.getCarteCourante().getCouleur() == Couleur.NOIR
        );
    }
}
