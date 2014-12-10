/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.semaphore;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class SimpleThread extends Thread {
    
    Semaphore semaphore;    
    
    SimpleThread(Semaphore semaphore){
        this.semaphore = semaphore;
        //Thread.currentThread().setName(null);
    }
    
    public void run(){
           // semaphore.acquire();

        
        System.out.println("[Simple Thread] run: "+ Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            semaphore.release();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
