/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.cyclicbarrier;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class CyclicBarrier {
    
    int maxCountThreads;
    AchivementThread achivementThread;
    Generation generation;
    
    private static class Generation{
        int countThreads;
       
       Generation(int count){
           countThreads = count;
       }
    }

    CyclicBarrier(int count, AchivementThread achivementThread){
        this.maxCountThreads = count;
        this.achivementThread = achivementThread;
        generation = new Generation(maxCountThreads);
    }
    
    public void await() throws InterruptedException{
        synchronized(generation){
            generation.countThreads--;
            if(generation.countThreads==0){
                new Thread(achivementThread).start();
                generation.notifyAll();
            }
            while(generation.countThreads!=0){
                generation.wait();
            }
        }
    }
    
    /**
     * This method refresh cyclic barrier to use it one more time.
     */
    public void  reset(){
        generation =  new Generation(maxCountThreads);
    }
            
}
