
package puzzle;

import affichage.MyFrame;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {
         try {
            // Charger le thème Nimbus
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // TODO code application logic here
        JFrame menu = new JFrame();
        menu.setSize(300, 300);
       menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       menu.setVisible(true);
        JButton validerB = new JButton("Valider");
        JTextField input1= new JTextField();
        JTextField input2= new JTextField();
        JLabel label = new JLabel("Format du puzzle :");
      
        menu.add(validerB);
        menu.add(input1);
        menu.add(input2);
        menu.add(label);
  
        int ypos = menu.getHeight()/2-50;
        label.setSize(150,20);
        label.setLocation(10,ypos);
        
        input1.setSize(50,20);
        input1.setLocation(150, ypos+20);
   
        
        input2.setSize(50,20);
        input2.setLocation(210, ypos+20);
        
        validerB.setSize(100,20);
        validerB.setLocation(140, ypos+50);
//        menu.setVisible(true);
        
       
        
        
//        validerB.addActionListener(e->{
//            menu.dispose();
//             int rows=Integer.parseInt(input2.getText()) ;
//        int cols = Integer.parseInt(input1.getText()) ;
                    int rows =5;
                    int cols =5;
                   MyFrame frame  = new MyFrame(cols,rows);
                
                   
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        int result = fileChooser.showOpenDialog(frame);
//        if (result == JFileChooser.APPROVE_OPTION) {
                       try {
                           frame.loadGame(new File("C:\\Users\\Hakim\\Documents\\NetBeansProjects\\PuzzleSabi\\src\\Bascket.jpg"));
                       } catch (IOException ex) {
                           Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
                       }
//        }
frame.setBackground(Color.BLACK);
        frame.setVisible(true);
//        });
        
        
        
        
        
        
        
       
       

//     
    }
    
}
