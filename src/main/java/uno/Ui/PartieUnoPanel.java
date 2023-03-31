package uno.Ui;

import uno.Partie;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class PartieUnoPanel extends JPanel {
    private Partie partie;
    private JPanel playerDeckPanel;
    private JPanel robotDeckPanel1;
    private JPanel robotDeckPanel2;
    private JPanel robotDeckPanel3;
    private JPanel centerPanel;
    private JPanel lastCardPanel;
    private JButton pickDeckButton;

    public PartieUnoPanel(Partie partie) throws IOException {
        this.partie = partie;

        setLayout(new BorderLayout());

        // Create the player deck panel and add it to the bottom
        playerDeckPanel = new PlayerDeck(partie.getJoueurs().get(0));
        // Ajouter le JPanel à un JScrollPane
        JScrollPane scrollPane1 = new JScrollPane(playerDeckPanel);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setPreferredSize(new Dimension(200, 225)); // Définir une taille maximale pour le JScrollPane
        // Create a titled border with the desired title
        Border titledBorder = BorderFactory.createTitledBorder(partie.getJoueurs().get(0).getNom());

        // Set the titled border on the JScrollPane
        scrollPane1.setBorder(titledBorder);
        add(scrollPane1, BorderLayout.SOUTH);

        // Create the robot deck panels and add them to the appropriate positions
        if (partie.getJoueurs().size() >= 2) {
            robotDeckPanel1 = new RobotDeck(partie.getJoueurs().get(1),false);
            // Ajouter le JPanel à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(robotDeckPanel1);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setPreferredSize(new Dimension(200, 225)); // Définir une taille maximale pour le JScrollPane
            // Create a titled border with the desired title
            Border titledBorder2 = BorderFactory.createTitledBorder(partie.getJoueurs().get(1).getNom());

            // Set the titled border on the JScrollPane
            scrollPane.setBorder(titledBorder2);
            add(scrollPane, BorderLayout.NORTH);
        }
        if (partie.getJoueurs().size() >= 3) {
            robotDeckPanel2 = new RobotDeck(partie.getJoueurs().get(2),true);
            JScrollPane scrollPane = new JScrollPane(robotDeckPanel2);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setPreferredSize(new Dimension(225, 200)); // Définir une taille maximale pour le JScrollPane
            // Create a titled border with the desired title
            Border titledBorder2 = BorderFactory.createTitledBorder(partie.getJoueurs().get(2).getNom());

            // Set the titled border on the JScrollPane
            scrollPane.setBorder(titledBorder2);
            add(scrollPane, BorderLayout.EAST);
        }
        if (partie.getJoueurs().size() == 4) {
            robotDeckPanel3 = new RobotDeck(partie.getJoueurs().get(3),true);
            JScrollPane scrollPane = new JScrollPane(robotDeckPanel3);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setPreferredSize(new Dimension(225, 200)); // Définir une taille maximale pour le JScrollPane
            // Create a titled border with the desired title
            Border titledBorder2 = BorderFactory.createTitledBorder(partie.getJoueurs().get(3).getNom());

            // Set the titled border on the JScrollPane
            scrollPane.setBorder(titledBorder2);
            add(scrollPane, BorderLayout.WEST);
        }

        // Create the center panel and add the last card label and pick deck button
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        lastCardPanel = new CarteRectoPanel(partie.getCarteCourante());
        ImageIcon imageIcon = new ImageIcon("src/main/resources/uno/cartes/reverseCard.png");
        JPanel pioche = new JPanel();
        JLabel label = new JLabel(imageIcon);
        pioche.add(label);
        pickDeckButton = new JButton("pioche");
        centerPanel.add(lastCardPanel);
        centerPanel.add(pioche);
        centerPanel.add(pickDeckButton);
        add(centerPanel, BorderLayout.CENTER);
    }
}
