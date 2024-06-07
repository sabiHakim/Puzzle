
package listener;

import affichage.ImageGrid;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modele.Partie;
public class Listener implements MouseListener{
    ImageGrid grid ;
//    Partie partie;
    int x1 =-1 ;
    int y1 = -1;
    int y2 = -1;
    int x2 = -1;
    int clickedCount = 0;
//    public Listener(ImageGrid grid,Partie partie){
//        this.grid = grid;
//         this.partie = partie;
//    }
      public Listener(ImageGrid grid){
        this.grid = grid;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        int pieceWidth = this.grid.getWidth() / grid.getCols();
                int pieceHeight = grid.getHeight() / grid.getRows();
                int colIndex = e.getX() / pieceWidth;
                int rowIndex = e.getY() / pieceHeight;
        System.out.println(colIndex + " "+ rowIndex);
        clickedCount++;
        if(clickedCount==1){
            this.grid.setSelectedPieceIndex(rowIndex * grid.getCols() + colIndex);
            this.x1 = rowIndex; 
            this.y1 = colIndex;
            this.grid.repaint();
        }
        else if(clickedCount==2){
            this.x2 = rowIndex; 
            this.y2 = colIndex;
            this.grid.getPartie().echangerPlace(x1, y1, x2, y2);
            this.clickedCount=0;
            this.grid.incrementeCoup();
            this.grid.getMyframe().getStat_label().setText("Nombre de coup : "+this.grid.getNombre_de_coup());
            this.grid.setSelectedPieceIndex(-1);
            this.grid.repaint();
            if(this.grid.getPartie().checkIsOrder()&&this.grid.getNombre_de_coup()!=0){
                JOptionPane.showMessageDialog(this.grid, "Vous avez reussi avec "+this.grid.getNombre_de_coup() + " coup");
            }
//            Partie.SaveGame(this.partie.getMatrice());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }
    
   
    
}
