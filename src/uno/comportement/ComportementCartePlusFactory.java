package uno.comportement;

public class ComportementCartePlusFactory implements ComportementCarteFactory {
    @Override
    public ComportementCarte createComportementCarte() {
        return new ComportementCartePlus();
    }
}