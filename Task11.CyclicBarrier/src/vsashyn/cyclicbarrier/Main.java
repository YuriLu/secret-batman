/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.cyclicbarrier;

import java.util.LinkedList;

/**
 *
 * @author vsa
 */
public class Main {
    public static void main(String args[]) throws InterruptedException{
        AchivementThread ath = new AchivementThread();
        CyclicBarrier cb = new CyclicBarrier(3, ath);
        
        LinkedList<Thread> threadList = new LinkedList<>();
        
        for(int i =0;i<3;i++){
        threadList.add(new SimpleThread(cb));
        threadList.poll().start();
        Thread.sleep(1000);
        }
        
        
       cb.reset();
       for(int i =0;i<3;i++){
        threadList.add(new SimpleThread(cb));
        threadList.poll().start();
        Thread.sleep(1000);
        }
        
    }
}
