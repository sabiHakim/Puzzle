package modele;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;


public class Partie {

    int [][] matrice;
    int nb_colonne;
    int nb_ligne;
    public Partie(int c , int l){
        this.nb_colonne=c;
        this.nb_ligne = l;
        this.matrice = new int[nb_ligne][nb_colonne];
        int count = 1;
        for (int i=0;i<nb_ligne;i++){
            for (int j=0;j<nb_colonne;j++){
                this.matrice[i][j]=count;
                count++;
            }
        }

    }
    
    public boolean  checkIsOrder(){
        int count= 1 ;
         for (int i=0;i<getNb_ligne();i++){
            for (int j=0;j<getNb_colonne();j++){
               if(this.matrice[i][j]==count){
                   count++;
               }else return false;
                
            }
        }
         return true;
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }
//
//    public static int[][] rotateMatrix(int[][] matrix, double angleDegrees) {
//        // Convertir l'angle en radians
//        double angleRadians = Math.toRadians(angleDegrees);
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        int[][] rotatedMatrix = new int[cols][rows];
//
//        // Calculer le centre de rotation pour les matrices 2x2
//        double centerX = (cols - 1) / 2.0;
//        double centerY = (rows - 1) / 2.0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                // Translater les coordonnées pour que le centre de la matrice soit à l'origine
//                double translatedX = j - centerX;
//                double translatedY = i - centerY;
//
//                // Appliquer la rotation
//                double rotatedX = translatedX * Math.cos(angleRadians) - translatedY * Math.sin(angleRadians);
//                double rotatedY = translatedX * Math.sin(angleRadians) + translatedY * Math.cos(angleRadians);
//
//                // Retranslater les coordonnées au centre d'origine
//                int originalX = (int) Math.round(rotatedX + centerX);
//                int originalY = (int) Math.round(rotatedY + centerY);
//
//                // Remplir la matrice pivotée
//                if (originalY >= 0 && originalY < rows && originalX >= 0 && originalX < cols) {
//                    rotatedMatrix[originalY][originalX] = matrix[i][j];
//                }
//            }
//        }
//
//        return rotatedMatrix;
//    }
//    
public static int[][] rotateMatrix(int[][] matrix, int angle) {
    int n = matrix.length;
    int m = matrix[0].length;

    int[][] rotatedMatrix;

    // Normaliser l'angle dans la plage de 0 à 360 degrés
    angle = (angle % 360 + 360) % 360;

    // Calculer le nombre de rotations nécessaires en fonction de l'angle
    int rotations = angle / 90;

    switch (rotations) {
        case 0:
            rotatedMatrix = copyMatrix(matrix);
            break;
        case 1:
            rotatedMatrix = rotate90(matrix);
            break;
        case 2:
            rotatedMatrix = rotate180(matrix);
            break;
        case 3:
            rotatedMatrix = rotate270(matrix);
            break;
        default:
            rotatedMatrix = copyMatrix(matrix);
    }

    return rotatedMatrix;
}
    public static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] rotatedMatrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }
        public static int[][] rotate180(int[][] matrix) {
        return rotate90(rotate90(matrix));
    }

    public static int[][] rotate270(int[][] matrix) {
        return rotate90(rotate90(rotate90(matrix)));
    }

       public static int[][] copyMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, m);
        }

        return copy;
    }





    public int getNb_colonne() {
         
            return this.matrice[0].length;
    }

    public void setNb_colonne(int nb_colonne) {
        this.nb_colonne = nb_colonne;
    }

    public int getNb_ligne() {
        return this.matrice.length;
    }

    public void setNb_ligne(int nb_ligne) {
        this.nb_ligne = nb_ligne;
    }

    public  void melangerMatrice() {
        int nc = this.matrice[0].length;
        int nl = matrice.length;
        Random random = new Random();
        //int n = matrice.length;
        // Parcourir chaque élément de la matrice
        for (int i = 0; i < nl; i++) {
            for (int j = 0; j < nc; j++) {
                // Générer des indices aléatoires
                int randomI = random.nextInt(nl);
                int randomJ = random.nextInt(nc);

                // Échanger les éléments aux indices actuels avec les éléments aux indices aléatoires
                int temp = matrice[i][j];
                matrice[i][j] = matrice[randomI][randomJ];
                matrice[randomI][randomJ] = temp;
            }
        }

       
    }
    
    public void echangerPlace(int x1,int y1,int x2,int y2){
           int valeur1  = this.matrice[x1][y1];
           int valeur2  = this.matrice[x2][y2];
           this.matrice[x1][y1]=valeur2;
           this.matrice[x2][y2] = valeur1;

    }
    
    public void resetMatrice (){
        int count = 1;
        for (int i=0;i<nb_ligne;i++){
            for (int j=0;j<nb_colonne;j++){
                this.matrice[i][j]=count;
                count++;
            }
        }
    
    
    }

    // Méthode pour afficher une matrice
    public static void afficherMatrice(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
 
          public static void SaveGame(int[][] matrice) {
        try {
            FileOutputStream fileOutputStream  = new FileOutputStream("game_save.dat");
          ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(matrice);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
