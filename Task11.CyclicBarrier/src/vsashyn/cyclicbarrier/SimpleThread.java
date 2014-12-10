/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.cyclicbarrier;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class SimpleThread  extends Thread{
    
    CyclicBarrier barrier;
    
    SimpleThread(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    
    public void run(){
        try {
            barrier.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("[Thread running] " 
                + Thread.currentThread().getName());
        
    }
}
