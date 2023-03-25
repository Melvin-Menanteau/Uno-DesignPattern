package joueurs;

import uno.Carte;

public class JoueurHumain implements Joueur{
    private String nom;
    private ArrayList<Carte> main;

    public JoueurHumain(String nom) {
        this.nom = nom;
        this.main = new ArrayList<Carte>();
    }

    @Override
    public void piocher(Carte carte) {

    }

    @Override
    public void jouerCarte(Carte carte) {

    }
}
