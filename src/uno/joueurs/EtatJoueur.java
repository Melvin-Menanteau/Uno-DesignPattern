package uno.joueurs;

public interface EtatJoueur {
    public void rejoindrePartie(JoueurObserver observer); // Permet de rejoindre une partie
    public void quitterPartie(JoueurObserver observer); // Permet de quitter une partie
    public void notifyParties(); // Notifie les parties quand le joueur a gagné
}
