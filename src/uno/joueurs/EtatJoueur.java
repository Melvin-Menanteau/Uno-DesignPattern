package joueurs;

public interface EtatJoueur {
    public void rejoindrePartie(JoueurObserver observer);
    public void quitterPartie(JoueurObserver observer);
    public void notifyParties();
}
