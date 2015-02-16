
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
class Ran implements Runnable{
    
    NonBlockingQueueList list;
    
    Ran(NonBlockingQueueList list){
        this.list = list;
    }
    
    @Override
    public void run(){
       
    }
}
public class Main {
    
    public static void main(String args[]){
       NonBlockingQueueList list = new NonBlockingQueueList();
       
       Thread th1 = new Thread(new Ran(list){
          @Override
          public void run(){
                  while(true){
                  list.offer(new Object());
                  System.out.println("Added");
              }
          }
       });
       
       Thread th2 = new Thread(new Ran(list){
          @Override
          public void run(){
              
              while(true){
                 try {
                      list.pop();
                      System.out.println("Added");
                  } catch (QueueIsEmptyException ex) {
                      System.err.println(ex);
                  }
              }
          }
       });
       th1.start();
       th2.start();
    }
}
