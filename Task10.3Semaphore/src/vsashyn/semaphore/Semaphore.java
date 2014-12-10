/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.semaphore;;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class Semaphore {
    
    int count=3;
    LinkedList<Thread> queueWaiting = new LinkedList<>();
    LinkedList<Thread> queueRunning = new LinkedList<>();
    
    public Semaphore(){
        
    }
    public Semaphore(int count){
        this.count = count;
    }
    
    
    public synchronized void acquire() {
        if (!queueWaiting.contains(Thread.currentThread())){
            queueWaiting.add(Thread.currentThread());
        }
        while(count==0 || Thread.currentThread() != queueWaiting.peek()){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaphore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        count--;
        queueRunning.add(Thread.currentThread());
        queueWaiting.poll();
    }
    
    public synchronized void release() throws Exception{
        if(queueRunning.contains(Thread.currentThread())){
            count++;
            this.notifyAll();
            queueRunning.remove(Thread.currentThread());
        } else {
            throw new Exception();
        }
            
    }
}
