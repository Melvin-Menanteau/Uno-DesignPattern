package joueurs;


import cartes.Carte;

import java.util.ArrayList;

public class JoueurRobot implements Joueur{
    private String nom;
    private ArrayList<Carte> main;

    public JoueurRobot(String nom) {
        this.nom = nom;
        this.main = new ArrayList<Carte>();
    }

    @Override
    public void piocher(Carte carte) {
        main.add(carte);
    }

    @Override
    public void jouerCarte(Carte carte) {
        main.remove(carte);
    }

    public String getNom() {
        return nom;
    }


    @Override
    public void rejoindrePartie(JoueurObserver observer) {

    }

    @Override
    public void quitterPartie(JoueurObserver observer) {

    }

    @Override
    public void notifyParties() {

    }
}
