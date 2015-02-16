/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.dihotomia;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vsa
 */
public class Function implements Runnable {
    
    LinkedList<Thread> threadList;
    int segmentA;
    int segmentB;
    int x;
    int middle ;
    
    Function(int segA, int segB){
        threadList = new LinkedList<>();
        this.segmentA = segA;
        this.segmentB = segB;
        middle =(segmentA+segmentB)/2;
    }
    
    public int countFunc(int x){
        return 3*x;                   //Here must be a function
    }
    
    public int findZeroFunction() throws InterruptedException{
        middle=(segmentA+segmentB)/2;
        System.out.println("middle = " + middle);
        threadList.add(new Thread(this));
        if(countFunc(middle)!=0){
            System.out.println("Count function = " + countFunc(middle));
            System.out.println("This is one run" 
                    + Thread.currentThread().getName());
            threadList.peekLast().start();
            threadList.peekLast().join();
            findZeroFunction();
        } else { 
        return middle;
        }
        return 0;
    }
       
    @Override
    public void run() {
        System.out.println("Run run"+ Thread.currentThread().getName());
        if(middle*segmentA<0){
            this.segmentB=middle;
            
        } else {
            this.segmentA=middle;
        }
    }
    
}
