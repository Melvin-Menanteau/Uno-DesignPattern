package uno.cartes;

import uno.comportement.*;
import uno.Partie;

public class Carte {
    // pour colorer les cartes dans la console
    public enum AsciiColours {
        ROUGE("\u001B[31m"),
        VERT("\u001B[32m"),
        JAUNE("\u001B[33m"),
        BLEU("\u001B[34m"),

        RESET("\u001B[0m"); // le code pour réinitialiser la couleur

        private final String code;

        AsciiColours(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }


    }

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
                return "rouge";
            case BLEU:
                return "bleu";
            case VERT:
                return "vert";
            case JAUNE:
                return "jaune";
            case NOIR:
                return "noir";
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
        return "Carte [valeur=" + valeur + ", couleur=" + couleur + ", action=" + comportementCarte.toString() + "]";
    }

    public void drawCarte() {
        String[] dessin = null;
        switch (comportementCarte.getType()) {
            case NORMAL:
                dessin = new String[]{
                        "+-------+",
                        "| " + valeur + "     |",
                        "|       |",
                        "|       |",
                        "|       |",
                        "|     " + valeur + " |",
                        "+-------+"
                };
                break;
            case COULEUR:
                dessin = new String[]{
                        "+-------+",
                        "|       |",
                        "| COLOR |",
                        "|       |",
                        "| CARD  |",
                        "|       |",
                        "+-------+"
                };
                break;
            case BLOQUE:
                dessin = new String[]{
                        "+-------+",
                        "|       |",
                        "| BLOCK |",
                        "|       |",
                        "| CARD  |",
                        "|       |",
                        "+-------+"
                };
                break;
            case INVERSION:
                dessin = new String[]{
                        "+-------+",
                        "|       |",
                        "| SWITCH|",
                        "|       |",
                        "| CARD  |",
                        "|       |",
                        "+-------+"
                };
                break;
            case PLUS2:
            case PLUS4:
                int nbPlus = ((ComportementCartePlus) comportementCarte).getNbCartePlus();
                dessin = new String[]{
                        "+-------+",
                        "|       |",
                        "| PLUS  |",
                        "|  " + nbPlus + "    |",
                        "| CARD  |",
                        "|       |",
                        "+-------+"
                };
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + comportementCarte.getType());
        }

        // couleur de la carte
        String colorCode = couleur == Couleur.ROUGE ? AsciiColours.ROUGE.getCode() :
                couleur == Couleur.BLEU ? AsciiColours.BLEU.getCode() :
                        couleur == Couleur.VERT ? AsciiColours.VERT.getCode() :
                                couleur == Couleur.JAUNE ? AsciiColours.JAUNE.getCode() :
                                        couleur == Couleur.NOIR ? AsciiColours.RESET.getCode() : AsciiColours.RESET.getCode();
        for (String ligne : dessin) {
            System.out.println(colorCode + ligne + AsciiColours.RESET.getCode());
        }
    }

    // vérifie si une carte est jouable
    public boolean isCarteJouable() {
        Couleur couleurCartePlateau = partie.getCarteCourante().getCouleur();
        // les cartes spéciale noires sont toujours jouables -> Plus 4 et carte couleur
        if (this.getCouleur() == Couleur.NOIR) {
            return true;
        }
        // cas particulier: quand la carte couleur est posé sur le board
        if (partie.getCarteCourante().comportementCarte instanceof ComportementCarteCouleur){
            return this.getCouleurString(this.getCouleur()) == partie.getCouleurCourante();
        }
        // cas particuliers des cartes bloque && carte inversion && carte plus 2
        if (this.getComportement() instanceof ComportementCarteBloque ||
                this.getComportement() instanceof ComportementCarteInversion ||
                this.getComportement() instanceof ComportementCartePlus) {
            return couleurCartePlateau == this.getCouleur() ||
                    partie.getCarteCourante().getComportement() == this.getComportement() ||
                    couleurCartePlateau == Couleur.NOIR;
        }
        // autres cas
        return (couleurCartePlateau == this.getCouleur() ||
                partie.getCarteCourante().getValeur() == this.getValeur() ||
                couleurCartePlateau == Couleur.NOIR);
    }
}
