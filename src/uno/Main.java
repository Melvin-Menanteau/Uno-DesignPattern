package uno;

import uno.ui.MainWindow;
public class Main {
    public static void main(String[] args) {
        // Creer la partie et la lance
        Partie partie = new Partie(2);
        partie.run();
    }
}