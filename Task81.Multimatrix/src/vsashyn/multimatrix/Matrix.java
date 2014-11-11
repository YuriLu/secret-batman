/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.multimatrix;

/**
 *
 * @author vsa
 */
public class Matrix {
    
    int[][] matrix = {{1,2},{2,3},{2,3}};
    int[][] matrix2 ={{1,2},{3,4}};
         

    public int findElement(int row, int table){
        int c=0;
        for(int i=0;i<matrix2.length;i++){
            c+=matrix[row][i]*matrix2[i][table];
        }
        return c;
        
    }
    
    public int[][] multiple(){
        int result[][]= new int[matrix.length][matrix2.length];
        
        if(matrix[0].length!=matrix2.length){
            System.out.println("Matrix are not agreed");
            return null;
        }
        
        for(int rows=0;rows<matrix.length;rows++){
            for(int tables=0;tables<matrix2.length;tables++){
                result[rows][tables]=findElement(rows,tables);
            }
    }
        return result;
    
    }
}
