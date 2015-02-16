
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
 class MyThread implements Runnable{
     NonBlockingQueue<Integer> queue;
     int param;
     MyThread(NonBlockingQueue queue, int param){
         this.queue = queue;
         this.param = param;
     }
     
     @Override
     public void run(){
         while(true){
             try {
                 queue.offer(param);
                 System.out.println("added");
             } catch (QueueIsFullException ex) {
                 System.err.println("Queue is full");
             }
         }
     }
 }
class MyThread1 implements Runnable{
     NonBlockingQueue<Integer> queue;
     
     MyThread1(NonBlockingQueue queue){
         this.queue = queue;
         
     }
     
     @Override
     public void run(){
         while(true){
             try {
                 System.out.println(queue.pop());
             } catch (QueueIsEmptyException ex) {
                 System.err.println("Queue is empty");
             }
         }
     }
 }
public class Main {
    
    
    public static void main(String args[]){
        
        NonBlockingQueue queue = new NonBlockingQueue (10);
        new Thread(new MyThread(queue, 10)).start();
       // new Thread(new MyThread(queue, 20)).start();
        new Thread(new MyThread1(queue)).start();
    }
}
