/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.present;

/**
 *
 * @author vsa
 * Wafer. Only one type of Wafers we were initialized.
 */
public class Wafer  extends Confection{
   
    public Wafer(){
        this.setName("Artek");
        this.setAmountFlour(100);
        this.setCalories(100);
        this.setWeight(25);
        this.setAmountSugar(150);
    }
    
    Wafer(String name, int weight, int calories, int amountFlour
            ,int amountSugar){
        super(name, weight, calories, amountFlour, amountSugar);
    }
}
