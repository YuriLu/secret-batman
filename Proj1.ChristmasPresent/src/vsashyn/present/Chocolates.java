/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.present;

/**
 *
 * @author vsa
 */
public class Chocolates extends Confection{
    
    public Chocolates(){
        this.setName("MilkiWay");
        this.setAmountFlour(0);
        this.setAmountSugar(250);
        this.setCalories(300);
        this.setWeight(35);
        
        }
    
    public Chocolates(String name, int weight, int calories, int amountFlour
            ,int amountSugar){
        super(name, weight, calories, amountFlour, amountSugar);
    }
    
    
}
