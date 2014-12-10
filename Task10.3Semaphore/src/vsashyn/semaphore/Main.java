/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.semaphore;

/**
 *
 * @author vsa
 */
public class Main {
    
    
    public static void main(String args[]) throws InterruptedException{
        Semaphore s = new Semaphore();
        
        for(int i=0;i<7;i++){
            Thread.sleep(1000);
            new SimpleThread(s).start();
        }
        Thread test = new SimpleThread(s);
        test.start();
        
   }
}
