package uno;

import org.junit.jupiter.api.*;
import uno.cartes.Carte;
import uno.cartes.CarteBuilder;
import uno.joueurs.Joueur;

import static org.junit.jupiter.api.Assertions.*;

public class TestUno {

    @Test
    public void testCreationPartieWithManyPlayers() {
        // Test that a Partie object is created with the correct number of players
        Partie partie = new Partie(4);
        assertEquals(4, partie.getJoueurs().size());
    }

    @Test
    public void testCreationPartieWithNoPlayer() {
        // creer une partie avec 0 joueur
        assertThrows(IllegalArgumentException.class, () -> new Partie(0));
    }

    @Test
    public void testCreationPartieWithOnePlayer() {
        // creer une partie avec 1 joueur
        assertThrows(IllegalArgumentException.class, () -> new Partie(1));
    }

    @Test
    public void testSetCarteCourante() {
        // Test that setCarteCourante method sets the correct carteCourante
        Partie partie = new Partie(2);
        CarteBuilder carteBuilder = new CarteBuilder(partie);
        Carte carte = carteBuilder.setCouleur(Carte.Couleur.ROUGE).setValeur(5).build();
        partie.setCarteCourante(carte);
        assertEquals(carte, partie.getCarteCourante());
    }

    @Test
    public void testGetCarteCourante() {
        // Test that getCarteCourante method returns the correct carteCourante
        Partie partie = new Partie(2);
        CarteBuilder carteBuilder = new CarteBuilder(partie);
        Carte carte = carteBuilder.setCouleur(Carte.Couleur.ROUGE).setValeur(5).build();
        partie.setCarteCourante(carte);
        assertEquals(carte, partie.getCarteCourante());
    }

    @Test
    public void testGetJoueurSuivant() {
        // Test that getJoueurSuivant method returns the correct player based on the rotation direction
        Partie partie = new Partie(3);
        Joueur joueur1 = partie.getJoueurCourant();
        Joueur joueur2 = partie.getJoueurSuivant();
        // le joueur suivant devient le joueur 3
        partie.inverserSensRotation();
        Joueur joueur3 = partie.getJoueurSuivant();
        // La liste de joueur commence a 0
        assertEquals(partie.getJoueurs().get(1).getNom(), joueur2.getNom());
        assertEquals(partie.getJoueurs().get(2).getNom(), joueur3.getNom());
        assertEquals(joueur1.getNom(), partie.getJoueurCourant().getNom());
    }

    @Test
    public void testNombresDeCartesEnJeux() {
        // Test that the number of cards in play is correct
        Partie partie = new Partie(2);
        // aucune cartes n'a ete jouee
        assertEquals(0, partie.getPlateau().getCartesJouees().size());
        // la pioche contient toutes les cartes moins les mains des joueurs et la carte courante
        assertEquals(108 - 7 - 7 - 1, partie.getPlateau().getPioche().size());
    }

    @Test
    public void testConditionDeVictoire() {
        // Test that the win condition is met when a player has no cards left
        Partie partie = new Partie(2);
        Joueur joueur = partie.getJoueurCourant();
        // le joueur courant a 7 cartes -> main de depart
        assertEquals(7, joueur.getDeck().size());
        // le joueur courant joue toutes ses cartes
        for (int i = 0; i < 7; i++) {
            joueur.jouerCarte();
        }
        // le joueur courant a 0 cartes
        assertEquals(0, joueur.getDeck().size());
        // le joueur courant a gagne
        assertTrue(partie.isEstTerminee());
    }

    @Test
    public void testConditionDeVictoireFause() {
        // Test that the win condition is met when a player has no cards left
        Partie partie = new Partie(2);
        Joueur joueur = partie.getJoueurCourant();
        // le joueur courant a 7 cartes -> main de depart
        assertEquals(7, joueur.getDeck().size());
        // le joueur courant joue cinque de ses cartes
        for (int i = 0; i < 5; i++) {
            joueur.jouerCarte();
        }
        // le joueur courant a 2 cartes
        assertEquals(2, joueur.getDeck().size());
        // le joueur courant a gagne
        assertFalse(partie.isEstTerminee());
    }

    @Test
    public void testRejoindrePartie() {
        // Test quand le joueur rejoinds des parties
        Partie partie = new Partie(2);
        Joueur joueur = partie.getJoueurCourant();
        // 1 partie
        assertEquals(1, joueur.getObservers().size());
        Partie partie2 = new Partie(2);
        joueur.rejoindrePartie(partie2);
        assertEquals(2, joueur.getObservers().size());
    }

    @Test
    public void testQuitterPartie() {
        // Test quand le joueur quitte une partie
        Partie partie = new Partie(2);
        Joueur joueur = partie.getJoueurCourant();
        joueur.quitterPartie(partie);
        assertEquals(0, joueur.getObservers().size());
    }


}