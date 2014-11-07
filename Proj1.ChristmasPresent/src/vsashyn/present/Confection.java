/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.present;

/**
 *
 * @author vsa
 * Class "Сладости"
 * 
 */
abstract public class Confection implements Comparable<Confection>{
    
    private String name;
    private int weight;
    private int calories;
    private int amountFlour;
    private int amountSugar;
    
    Confection(){
        
    }
    
    Confection(String name, int weight, int calories, int amountFlour
            ,int amountSugar){
        this.name= name;
        this.weight = weight;
        this.calories = calories;
        this.amountFlour = amountFlour;
        this.amountSugar = amountSugar;
        
    };
    
    /**
     * Compare confections with they calories value. 
     * @param confection
     * @return 
     */
    public int compareTo(Confection confection){
        
        
        if (this.getCalories() > confection.getCalories()){
            //Tekyshee bolshe poluchenogo
            return 1;
        }else if (this.getCalories()<confection.getCalories()){
            return -1;
        }else {
            return 0;
            
        }
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public int getAmountFlour() {
        return amountFlour;
    }

    public void setAmountFlour(int amountFlour) {
        this.amountFlour = amountFlour;
    }

    public int getAmountSugar() {
        return amountSugar;
    }

    public void setAmountSugar(int amountSugar) {
        this.amountSugar = amountSugar;
    }
    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    
    
    
}
