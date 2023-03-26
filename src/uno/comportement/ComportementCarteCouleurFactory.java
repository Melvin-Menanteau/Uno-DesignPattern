package uno.comportement;

public class ComportementCarteCouleurFactory implements ComportementCarteFactory {
    @Override
    public ComportementCarte createComportementCarte() {
        return new ComportementCarteCouleur();
    }
}