package uno.comportement;

public class ComportementCarteBloqueFactory implements ComportementCarteFactory {
    @Override
    public ComportementCarte createComportementCarte() {
        return new ComportementCarteBloque();
    }
}