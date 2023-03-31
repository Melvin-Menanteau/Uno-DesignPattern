package uno.Ui;
import uno.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUno extends JFrame {
    private JLabel titleLabel;
    private JLabel joueurNameLabel;
    private JTextField joueurNameTextField;
    private JLabel nombreRobotLabel;
    private JComboBox<Integer> robotComboBox;

    public MenuUno() {
        // Création de la fenêtre
        super("Uno");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer un panneau principal avec un BorderLayout
        JPanel menuPanel = new JPanel(new BorderLayout());
        super.add(menuPanel);

        // Ajouter le titre centré en haut du panneau principal
        JLabel titleLabel = new JLabel("Menu Uno", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        menuPanel.add(titleLabel, BorderLayout.NORTH);

        // Ajouter une bordure vide de 10 pixels en haut du titre
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        // Ajouter un panneau pour les labels et les champs de texte
        JPanel formPanel = new JPanel(new GridBagLayout());
        menuPanel.add(formPanel, BorderLayout.CENTER);

        // Ajouter les labels et les champs de texte avec un GridBagConstraints personnalisé
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);
        JLabel nomJoueur = new JLabel("Nom de joueur:");
        nomJoueur.setFont(new Font("Serif", Font.BOLD, 18));
        formPanel.add(nomJoueur, gbc);


        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField nameField = new JTextField(10);
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel nbRobot = new JLabel("Nombre de joueur Robot :");
        nbRobot.setFont(new Font("Serif", Font.BOLD, 18));
        formPanel.add(nbRobot, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        // Ajouter un JComboBox pour le choix du nombre de robots adversaires
        JComboBox<Integer> robotComboBox = new JComboBox<>(new Integer[]{1, 2, 3});
        robotComboBox.setSelectedIndex(0); // Définir la sélection initiale sur 1
        robotComboBox.setMaximumRowCount(3); // Définir le nombre maximal d'éléments à afficher à la fois
        formPanel.add(robotComboBox, gbc);
        // Définir une dimension personnalisée pour la JComboBox
        robotComboBox.setPreferredSize(new Dimension(113, robotComboBox.getPreferredSize().height));

        // Ajouter un bouton "Valider" pour confirmer les choix de l'utilisateur
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        JButton submitButton = new JButton("Valider");
        submitButton.setPreferredSize(new Dimension(113, robotComboBox.getPreferredSize().height));
        formPanel.add(submitButton, gbc);

        // afficher fenêtre
        this.setVisible(true);

        // Ajouter un ActionListener pour le bouton "Valider"
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String playerName = nameField.getText();
                int robotCount = (Integer) robotComboBox.getSelectedItem();

                // Check if the name field is empty
                if (playerName.trim().isEmpty()) {
                    // Show an error message and return
                    JOptionPane.showMessageDialog(menuPanel,
                            "Veuillez entrer un nom de joueur.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Partie partie = new Partie(robotCount + 1,playerName);
                
                // Instantiate a new JFrame for the Partie Uno view
                JFrame partieUnoFrame = new JFrame("Partie Uno");
                // Set the size and position of the frame
                partieUnoFrame.setSize(1000, 800);
                partieUnoFrame.setLocationRelativeTo(null);
                // Set the content pane of the frame to the PartieUnoPanel
                partieUnoFrame.setContentPane(new PartieUnoPanel(partie));
                // Make the frame visible
                partieUnoFrame.setVisible(true);

                // Hide the current frame
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new MenuUno();
    }
}