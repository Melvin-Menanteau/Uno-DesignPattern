package uno.Ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CarteVersoPanel extends JPanel {

    private boolean isIncline = false; // si on affiche la carte inclinée ou non
    public CarteVersoPanel(boolean isIncline) throws IOException {
        this.isIncline = isIncline;

        ImageIcon imageIcon;
        if (isIncline) {
            // Load the original image
            Image originalImage = ImageIO.read(new File("src/main/resources/uno/cartes/reverseCard.png"));

            // Rotate the image 90 degrees
            AffineTransform tx = new AffineTransform();
            tx.rotate(Math.toRadians(90),  originalImage.getWidth(null) / 2, originalImage.getHeight(null) / 2);

            // Create a new, rotated image
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            Image rotatedImage = op.filter((BufferedImage) originalImage, null);

            // Create an ImageIcon with the rotated image
            imageIcon = new ImageIcon(rotatedImage);

        } else {
            imageIcon = new ImageIcon("src/main/resources/uno/cartes/reverseCard.png");
        }
        JLabel label = new JLabel(imageIcon);
        add(label);
    }
}