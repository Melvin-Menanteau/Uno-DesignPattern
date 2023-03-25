package uno.cartes;

public interface CarteBuilderInterface {
    public void reset();
    public CarteBuilder setCouleur(Carte.Couleur couleur);
    public CarteBuilder setValeur(Integer valeur);
    public CarteBuilder setComportement(Carte.Action action);
    public Carte build();
}
