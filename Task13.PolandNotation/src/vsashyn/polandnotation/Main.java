/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.polandnotation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vsa
 */
public class Main {
    public static void main(String args[]){
        
        
          Expression ex = new Expression(" (12*3+10)*5+12*7");
          ex.createPolNot();
          ex.createTree();
          System.out.println("Result :"  + ex.countExpression());
        
    }
}
