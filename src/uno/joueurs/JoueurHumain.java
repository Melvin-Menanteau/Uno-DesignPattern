package joueurs;


import cartes.Carte;

import java.util.ArrayList;

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
