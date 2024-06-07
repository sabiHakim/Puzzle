
package main;
//import java.awt.GridLayout;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
import modele.Partie;
public class Main {
                      public static void main(String[] args) throws Exception {
//                JFrame frame = new JFrame("Découper une image en 3x3");
//                frame.setSize(600, 600);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                // Charger l'image
//                BufferedImage image = null;
//                try {
//                    image = javax.imageio.ImageIO.read(new File("C:\\1.jpg")); // Spécifiez le chemin de votre image
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                // Découper l'image en 3x3
//                int tileSizeX = image.getWidth() / 3;
//                int tileSizeY = image.getHeight() / 3;
//
//                // Afficher les morceaux découpés
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        BufferedImage subImage = image.getSubimage(j * tileSizeX, i * tileSizeY, tileSizeX, tileSizeY);
//                        ImageIcon icon = new ImageIcon(subImage);
//                        JLabel label = new JLabel(icon);
//                        frame.add(label);
//                    }
//                }
//
//                frame.setLayout(new GridLayout(3, 3));
//                frame.setVisible(true);
                Partie partie = new Partie(3,5);
//
//
//                double angle = Math.PI / 2;            
               int[][] matriceAleatoire = Partie.rotateMatrix(partie.getMatrice(),90);
                    //partie.echangerPlace(0, 0, 2, 2);
//                // Affichage de la matrice pivotée
                Partie.afficherMatrice(partie.getMatrice());
                Partie.afficherMatrice(matriceAleatoire);
//                Connection c = Connexion.getConnection();
//                System.out.println(c);
            }  
            
            
            
}
