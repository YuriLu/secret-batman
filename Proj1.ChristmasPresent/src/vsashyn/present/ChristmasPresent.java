/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.present;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vsa
 */
public class ChristmasPresent {
    
    List<Confection> present;
    //int weight;
    
    public ChristmasPresent(){
        present = new ArrayList<>();
        
    }
    
    public void add(Confection confection){
        present.add(confection);
        }
    
    public void remove(Confection confection){
        present.remove(confection);
        } 
    
    /**
     * 
     * @return Sum of confections weights witch are in present
     */
    public int countWeight(){
        int weight =0;
        for(Confection confection: present){
            weight+=confection.getWeight();
        }   
        return weight;
    }
    
    /**
     * Sorting by calories value of Confection. 
     * Used overridden method compareTo of  Confection.
     */
    public void sort(){
        Collections.sort(present);
    }
    
    /**
     * Showing confection in present.
     */
    public void showItems(){
        System.out.println("Next item's are in present: \n");
        for(Confection confection: present){
            System.out.println(confection.getName() +"\tWeight: " 
                    + confection.getWeight() + "\tCalories: " 
                    + confection.getCalories());
        }
        System.out.println();
    }
   
    /**
     * Returns elements in which amount of sugar 
     * is included in the predetermined range.
     * @param minValue
     * @param maxValue
     * @return List elements, that has sugar value in assigned range
     */
    public List<Confection> findSugarRange(int minValue, int maxValue){
       List<Confection> result = new ArrayList<>();
        for(Confection confection: present){
            if (confection.getAmountSugar()>minValue 
                    && confection.getAmountSugar()<maxValue){
                        result.add(confection);
            }
        }
        return result;
    }
    
}
