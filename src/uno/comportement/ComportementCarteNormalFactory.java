package uno.comportement;

public class ComportementCarteNormalFactory implements ComportementCarteFactory {
    @Override
    public ComportementCarte createComportementCarte() {
        return new ComportementCarteNormal();
    }
}

