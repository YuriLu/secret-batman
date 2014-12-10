
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
public class CakeCook extends Thread {
    Restaurant r;
    
    CakeCook(Restaurant r){
        this.r = r;
    }
    
    public void run(){
        while(true){
            try {
                r.addCake();
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public Object createCake() throws InterruptedException{
        sleep(1000);
        return new Object();
    }
    
}
