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
public class Main {
    
    
    public static void main(String args[]){
        
    Matrix mxs = new Matrix();
    
    int[][] g = mxs.multiple();
    for(int i=0;i<g.length;i++){
        for (int j=0;j<g[i].length;j++){
            System.out.println(g[i][j]);
        }
    }
    
    
    
    }
    
    
}
