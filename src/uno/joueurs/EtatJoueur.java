package joueurs;

public interface EtatJoueur {
    public void addObserver(JoueurObserver observer);
    public void removeObserver(JoueurObserver observer);
    public void notifyObservers();
}
