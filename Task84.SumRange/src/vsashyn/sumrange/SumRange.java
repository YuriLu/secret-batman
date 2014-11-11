/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.sumrange;

import java.util.Date;
/**
 *
 * @author vsa
 */
public class SumRange {
    
    static int end=10;
    static int countThreads=0;        //Step for Counter
    static Counter[] arrayCounters;
    static Thread[]  arrayThreads;
    int result=0;

    
    
    public SumRange(int countThreads) {
        SumRange.countThreads =countThreads;
        arrayCounters = new Counter[countThreads];
        arrayThreads = new Thread[countThreads];
   
    }
    
    public int count() throws InterruptedException{
        long startTime=System.nanoTime();
        long estimatedTime;
        System.out.println("Begin counting, countThreads=" + countThreads
                + " time: " + startTime);
        for(int thread=0; thread<countThreads; thread++){
            arrayCounters[thread] = new Counter(thread);
            arrayThreads[thread] = new Thread(arrayCounters[thread]);
            arrayThreads[thread].start();
           }
        for(int thread=0 ;thread<countThreads;thread++){
            arrayThreads[thread].join();
        }
        for(int counter=0 ;counter<countThreads;counter++){
            result+=arrayCounters[counter].getResult();
                }
        estimatedTime = System.nanoTime()-startTime;
        System.out.println("End counting. estimated time: " + estimatedTime);
        
        return result;
    }
    
        
    static class Counter implements Runnable{
        
        int preliminaryResult=0;    //предварительный
        int threadNumber;
        
        public Counter(int number){
            threadNumber= number;
        }
        
        public int getResult(){
            return preliminaryResult;
        }
        
        @Override
        public void run() {
            for(int iter=threadNumber; 
                    iter<=SumRange.end;
                    iter+=SumRange.countThreads){
                        preliminaryResult+=iter;
            }
        }
        
    }
}
    
    
    
    
    
    

