
package affichage;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import listener.Listener;
import modele.Partie;


public class MyFrame extends JFrame{
    ImageGrid grid;
    JButton melangerB ;
     JTextField inputDegre ;
    JButton pivoterB ;
    
    JButton resetB ;
    JButton annuler;
    JLabel stat_label;
    int rows = 0;
    int cols=  0;
    public MyFrame(int cols,int rows){
        this.rows= rows;
        this.cols = cols;
    }
    
    public void loadGame(File file) throws IOException{
         this.grid = new ImageGrid(file,new Partie(this.cols,this.rows),this);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        melangerB = new JButton("Melanger");
//           JPanel j= new JPanel();
//           this.add(j);
//           j.setBackground(Color.red);
        this.inputDegre  = new JTextField(2);
        this.pivoterB = new JButton("Pivoter");
        
        this.stat_label  = new JLabel("Nombre de coup "+ this.grid.getNombre_de_coup());
        
        resetB = new JButton("Reset");
        annuler = new JButton("Annuler Coup");

        
    
         this.setSize(900, 900);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.add(this.grid);
         
         this.grid.setSize(600,600);
         
         this.add(melangerB);
         this.add(this.inputDegre);
         this.add(pivoterB);
         this.add(stat_label);
        this.add(resetB);
                this.add(annuler);

        
         
         this.stat_label.setSize(300,300);
         this.stat_label.setLocation(100,600);
         
         this.melangerB.setSize(100,20);
         this.melangerB.setLocation(700,100);
//         this.melangerB.addActionListener(e -> {
//            this.grid.partie.melangerMatrice();
//            this.grid.addMouseListener(new Listener(this.grid));
//            this.grid.repaint();
//        });
this.melangerB.addActionListener(e -> {
    this.grid.partie.melangerMatrice();
    this.grid.removeMouseListener(this.grid.getMouseListeners()[0]);
//    this.grid.addMouseListener(new Listener(this.grid,this.grid.getPartie()));
        this.grid.addMouseListener(new Listener(this.grid)); 

    this.grid.repaint();
});
             this.inputDegre.setSize(100,20);
         this.inputDegre.setLocation(700,180);
         
         this.pivoterB.setSize(100,20);
         this.pivoterB.setLocation(700,200);
         
         this.resetB.setSize(100,20);
         this.resetB.setLocation(700,400);
         this.resetB.addActionListener(e ->{
             this.grid.getPartie().resetMatrice();
             this.grid.repaint();
         });
//         
         this.annuler.setSize(100,20);
         this.annuler.setLocation(700,500);
         this.annuler.addActionListener(e->{
         
         });
         
//         
         
         this.pivoterB.addActionListener(e -> {
            String inputText = this.inputDegre.getText();
              try {
                    // Convertir le texte en radians
                int angleDegrees = Integer.parseInt(inputText);
                System.out.println(angleDegrees);

                // Utilisez la méthode rotatem90 pour une rotation de -90 degrés
               
                  // Assurez-vous que l'angle est compris entre 0 et 359 degrés
                      this.grid.partie.setMatrice(Partie.rotateMatrix(this.grid.partie.getMatrice(), angleDegrees));
                      cols = this.grid.partie.getNb_colonne();
                      rows = this.grid.partie.getNb_ligne();
        
            
            // Découper l'image en morceaux
            this.grid.imagePieces = new BufferedImage[rows * cols];
            int pieceWidth = this.grid.image.getWidth() / cols;
            int pieceHeight = this.grid.image.getHeight() / rows;
            int count = 0;
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    this.grid.imagePieces[count] = this.grid.image.getSubimage(x * pieceWidth, y * pieceHeight, pieceWidth, pieceHeight);
                    count++;
                }
            }         
//                     this.grid.addMouseListener(new Listener(this.grid));
                      this.grid.removeMouseListener(this.grid.getMouseListeners()[0]); // Retire le premier écouteur de souris
                     this.grid.addMouseListener(new Listener(this.grid)); // Ajoute un nouveau écouteur de souris
                    this.grid.repaint();
                  
                } catch (NumberFormatException ex) {
                    // Gérer les erreurs de conversion
                    JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide.");
                }
           
        });
        this.grid.addMouseListener(new Listener(this.grid));
//        this.grid.addMouseListener(new Listener(this.grid,this.grid.getPartie()));
         this.setLayout(null);
//         this.setVisible(true);
    }
 

    public ImageGrid getGrid() {
        return grid;
    }

    public void setGrid(ImageGrid grid) {
        this.grid = grid;
    }

    public JButton getMelangerB() {
        return melangerB;
    }

    public void setMelangerB(JButton melangerB) {
        this.melangerB = melangerB;
    }

    public JTextField getInputDegre() {
        return inputDegre;
    }

    public void setInputDegre(JTextField inputDegre) {
        this.inputDegre = inputDegre;
    }

    public JButton getPivoterB() {
        return pivoterB;
    }

    public void setPivoterB(JButton pivoterB) {
        this.pivoterB = pivoterB;
    }

    public JLabel getStat_label() {
        return stat_label;
    }

    public void setStat_label(JLabel stat_label) {
        this.stat_label = stat_label;
    }
    
}
