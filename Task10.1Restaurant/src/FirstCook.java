
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vsa
 */
public class FirstCook extends Thread{
    
    Restaurant r;
    
    FirstCook(Restaurant r){
        this.r = r;
    }
    
    public Object createFirst() throws InterruptedException{
        sleep(1000);
        return new Object();
    }
    
    public void run(){
        while(true){
            try {
                r.addFirstDish();
            } catch (InterruptedException ex) {
            }
        }
    }
}
