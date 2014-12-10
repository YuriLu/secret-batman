
import java.util.LinkedList;
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
public class Restaurant extends Thread{
    
    FirstCook firstCook;
    CakeCook cakeCook;
    Barman barman;
    
    LinkedList queueToFirstDish; // Orders queues
    LinkedList queueToCake;
    LinkedList queueToCoffee;
    
    LinkedList queueClients;
    
    LinkedList queueReadyFirstDish; //Ready dished qeues
    LinkedList queueReadyCake;
    LinkedList queueReadyCoffee;
    

    public Restaurant() {
        this.firstCook = new FirstCook(this);
        this.cakeCook = new CakeCook(this);
        this.barman = new Barman(this);
        this.queueToFirstDish = new LinkedList();
        this.queueToCake = new LinkedList();
        this.queueToCoffee = new LinkedList();
        this.queueClients = new LinkedList();
        this.queueReadyCake = new LinkedList();
        this.queueReadyCoffee = new LinkedList();
        this.queueReadyFirstDish = new LinkedList();
    }
    
    public void addClientToQueue(Client c){
        synchronized(queueClients){
        queueClients.add(c);
        System.out.println("Client addded him to queue: " 
                + Thread.currentThread().getName());
        queueClients.notifyAll();
        }
    }
   
    public void run(){
        firstCook.start();
        cakeCook.start();
        barman.start();
        while(true){
            synchronized(queueClients){
            while(queueClients.isEmpty()){
                try {
                    queueClients.wait();
                } catch (InterruptedException ex) {
                }
            }
            synchronized(queueToFirstDish){
                queueToFirstDish.add(queueClients.peek());
                queueToFirstDish.notifyAll();
            }
            synchronized(queueToCake){
                queueToCake.add(queueClients.peek());
                queueToCake.notifyAll();
            }
            synchronized(queueToCoffee){
                queueToCoffee.add(queueClients.poll());
                queueToCoffee.notifyAll();
            }
            queueClients.notifyAll();
            }
        }
    }
    
    
    void addFirstDish() throws InterruptedException{
        synchronized(queueToFirstDish){
            while(queueToFirstDish.isEmpty()){
                queueToFirstDish.wait();
            }
            queueToFirstDish.poll();
            System.out.println("Cook get first dish order");
            queueToFirstDish.notifyAll();
        }
        synchronized(queueReadyFirstDish){
            queueReadyFirstDish.add(firstCook.createFirst());
            System.out.println("Cook added ready first dish");
            queueReadyFirstDish.notifyAll();
        }
    }
    
    void addCake() throws InterruptedException{
        synchronized(queueToCake){
            while(queueToCake.isEmpty()){
                queueToCake.wait();
            }
            queueToCake.poll();
            System.out.println("Cook get cake order");
            queueToCake.notifyAll();
        }
        synchronized(queueReadyCake){
            queueReadyCake.add(cakeCook.createCake());
            System.out.println("Cook added ready cake ");
            queueReadyCake.notifyAll();
        }
       
    }
    
    void addCoffee() throws InterruptedException{
        synchronized(queueToCoffee){
            while(queueToCoffee.isEmpty()){
                queueToCoffee.wait();
            }
        queueToCoffee.poll();
        System.out.println("Cook get coffe order");
        queueToCoffee.notifyAll();
        }
        synchronized(queueReadyCoffee){
            queueReadyCoffee.add(barman.createCoffee());
            System.out.println("Cook added coffee");
            queueReadyCoffee.notifyAll();

        }
    }
    
    void eatFirst() throws InterruptedException{
        synchronized(queueReadyFirstDish){
            while(queueReadyFirstDish.isEmpty()){
                queueReadyFirstDish.wait();
            }
            queueReadyFirstDish.poll();
           // Thread.sleep(2000);
            System.out.println("Client eat first :" + Thread.currentThread().getName());
            queueReadyFirstDish.notifyAll();
        }
    }
    void eatCake() throws InterruptedException{
        synchronized(queueReadyCake){
        while(queueReadyCake.isEmpty()){
            queueReadyCake.wait();
        }
        queueReadyCake.poll();
       // Thread.sleep(2000);
        System.out.println("Client eat cake :" + Thread.currentThread().getName());
        queueReadyCake.notifyAll();
    }
    }
    void eatCoffee() throws InterruptedException{
        synchronized(queueReadyCoffee){
            while(queueReadyCoffee.isEmpty()){
                queueReadyCoffee.wait();
            }
        
        queueReadyCoffee.poll();
      //  Thread.sleep(2000);
        System.out.println("Client eat coffee :" + Thread.currentThread().getName());
        queueReadyCoffee.notifyAll();
    }
    }
    
}
