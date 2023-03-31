package uno.cartes;

public interface CarteBuilderInterface {
    public void reset(); // valeur par défaut des attributs de la carte
    public CarteBuilder setCouleur(Carte.Couleur couleur); // set la couleur de la carte
    public CarteBuilder setValeur(Integer valeur); // set la valeur de la carte
    public CarteBuilder setComportement(Carte.Action action); // set le comportement de la carte
    public Carte build(); // construit la carte
}
