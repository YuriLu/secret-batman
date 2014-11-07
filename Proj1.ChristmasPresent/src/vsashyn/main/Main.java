/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.main;

import java.util.List;
import vsashyn.present.*;

/**
 *
 * @author vsa
 */
public class Main { 
    
    public static void main(String args[]){
        
        Chocolates chocolate_milkiway = new Chocolates();
        Chocolates chocolate_camomile = 
                new Chocolates("Camomile", 25, 210, 0, 200);
        
        ChristmasPresent present = new ChristmasPresent();
        
        present.add(chocolate_milkiway);
        present.add(chocolate_camomile);
        present.add(new Wafer());
        
        System.out.println("Weight of present:" + present.countWeight()+"\n");
        //optional: present.showItems();
        
        //Sorting elements using calories value 
        present.sort();
        present.showItems();
        
        List<Confection> confectionWithSugarInRange 
                = present.findSugarRange(0,200);
        System.out.println("Confection with amount "
                + "of sugar from predetermined range: ");
        for(Confection sweentess : confectionWithSugarInRange){
            System.out.println(sweentess.getName());
        }
        

        
 }
}
