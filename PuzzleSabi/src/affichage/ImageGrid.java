
package affichage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import listener.Listener;
import modele.Partie;

public class ImageGrid extends JPanel{
     Partie partie ;
    
     MyFrame myframe;
     
    BufferedImage image;
    int rows;
    int cols;
    BufferedImage[] imagePieces;

    int selectedPieceIndex = -1;

    int nombre_de_coup = 0;
    
    

    public int getSelectedPieceIndex() {
        return selectedPieceIndex;
    } 
  
    public void setSelectedPieceIndex(int selectedPieceIndex) {
        this.selectedPieceIndex = selectedPieceIndex;
    }

    public int getNombre_de_coup() {
        return nombre_de_coup;
    }

    public void setNombre_de_coup(int nombre_de_coup) {
        this.nombre_de_coup = nombre_de_coup;
    }
    
    public void incrementeCoup(){
        this.nombre_de_coup= this.nombre_de_coup+1;
    }

    public MyFrame getMyframe() {
        return myframe;
    }

    public void setMyframe(MyFrame myframe) {
        this.myframe = myframe;
    }
    
    
    public ImageGrid(File file,Partie partie,MyFrame myframe) throws IOException{
      this.partie = partie;
      this.myframe = myframe;
       image = ImageIO.read(file);
        this.cols = this.partie.getNb_colonne();
        this.rows = this.partie.getNb_ligne();
            // Découper l'image en morceaux
            imagePieces = new BufferedImage[rows * cols];
            int pieceWidth = image.getWidth() / cols;
            int pieceHeight = image.getHeight() / rows;
            int count = 0;
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    imagePieces[count] = image.getSubimage(x * pieceWidth, y * pieceHeight, pieceWidth, pieceHeight);
                    count++;
                }
            }
//            this.addMouseListener(new Listener(this,this.getPartie()));
            this.addMouseListener(new Listener(this));
            this.removeMouseListener(this.getMouseListeners()[0]);
            
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int vgap = 10;
        int hgap= 10;
        if (image != null) {
            int pieceWidth = getWidth() / this.partie.getNb_colonne();
            int pieceHeight = getHeight() / this.partie.getNb_ligne();
            int count = 0;
           
         
            for (int y = 0; y < this.partie.getNb_ligne(); y++) {
                for (int x = 0; x < this.partie.getNb_colonne(); x++) {
                    if (selectedPieceIndex==count) {
                    // Dessiner l'image avec une bordure rouge si elle est sélectionnée
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(3)); // Épaisseur de la bordure
                    g2d.drawRect(x * pieceWidth+vgap, y * pieceHeight+hgap, pieceWidth - 1, pieceHeight - 1);
                    g2d.dispose();
                } 
                    g.drawImage(imagePieces[this.partie.getMatrice()[y][x]-1], x * pieceWidth+vgap, y * pieceHeight+hgap, pieceWidth, pieceHeight, null);
                    vgap ++;
                    if(x==(this.partie.getNb_colonne()-1)){
                        vgap = 10;
                        hgap++;
                    }
                    count++;
                }
            }
        }
        //this.repaint();
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public int getRows() {
        return this.partie.getNb_ligne();
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return this.partie.getNb_colonne();
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public BufferedImage[] getImagePieces() {
        return imagePieces;
    }

    public void setImagePieces(BufferedImage[] imagePieces) {
        this.imagePieces = imagePieces;
    }

    public boolean  checkTheOrder(){
        int c = 1;
          for (int i = 0; i <this.partie.getNb_ligne(); i++) {
                for (int j = 0; j < this.partie.getNb_colonne(); j++) {
                    if(this.partie.getMatrice()[this.partie.getNb_ligne()][this.partie.getNb_colonne()]!=c){
                        return false;
                    }
                    c++;
                    
                }
         }
        return true;
    }
    
}
    
    
    
    
