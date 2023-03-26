package uno.comportement;

public class ComportementCarteInversionFactory implements ComportementCarteFactory {
    @Override
    public ComportementCarte createComportementCarte() {
        return new ComportementCarteInversion();
    }
}