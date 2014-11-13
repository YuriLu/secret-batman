/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task81.multithredmultimatrix;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class Main {
    
    
    public static void main(String args[]){
        
        Integer[][] mas1 = {{1,2},{2,3}};
        Integer[][] mas2 = {{1,2},{2,3}};
        
        
        Matrix m1 = new Matrix(mas1);
        Matrix m2 = new Matrix(mas2);
        
        Multiplicator mp = new Multiplicator(2, m1, m2);
        try {
            mp.makeShedule();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int a =0;a<mp.matrixResult.numbers.length;a++){
            for(int b=0;b<mp.matrixResult.numbers[0].length;b++){
                System.out.println(mp.matrixResult.numbers[a][b]);
            }
        }
    
    }
}
