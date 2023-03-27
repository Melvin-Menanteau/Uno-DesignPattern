package uno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu UNO !");
        System.out.println("Veuillez entrer le nombre de joueurs :");
        
        Scanner scanner = new Scanner(System.in);

        int nbJoueurs = scanner.nextInt();

        System.out.println("Entrer votre nom :");

        String nom = scanner.next();
        scanner.close();

        // Creer la partie et la lance
        Partie partie = new Partie(nbJoueurs,nom);
        partie.run();
    }
}