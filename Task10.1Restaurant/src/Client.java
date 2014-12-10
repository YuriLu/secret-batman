
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
public class Client extends Thread {
    
    Restaurant r;
    static int index=1;
    
    Client(Restaurant r){
        this.r = r;
    }
    public void run(){
       
            Thread.currentThread().setName("Client-"+index);
            index++;
            r.addClientToQueue(this);
            try {
                r.eatFirst();
                r.eatCake();
                r.eatCoffee();
            } catch (InterruptedException ex) {
                }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                }
           
            r.addClientToQueue(this);
            System.out.println("Client added him to queue second time" 
                    + Thread.currentThread().getName());
            try{
                r.eatFirst();
                r.eatCake();
                r.eatCoffee();
        } catch (InterruptedException ex) {
            }
    }
}