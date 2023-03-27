package uno;

import uno.ui.MainWindow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu UNO !");
        System.out.println("Veuillez entrer le nombre de joueurs :");
        int nbJoueurs = scanner.nextInt();
        System.out.println("Entrer votre nom :");
        String nom = scanner.next();
        // Creer la partie et la lance
        Partie partie = new Partie(nbJoueurs,nom);
        partie.run();
    }
}