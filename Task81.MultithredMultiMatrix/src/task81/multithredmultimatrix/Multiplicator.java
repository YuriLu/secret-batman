/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task81.multithredmultimatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vsa
 */
public class Multiplicator {
    
    int countThreads;
    Matrix matrix1;
    Matrix matrix2;
    Matrix matrixResult;
    int length ;
    ArrayList<countingThread> listThreads = new ArrayList<>(length);

    public Multiplicator(int countThreads, Matrix matrix1, Matrix matrix2) {
        this.countThreads = countThreads;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        length = matrix1.numbers.length;
        matrixResult = new Matrix(length);
    }
    
    public void makeShedule() throws InterruptedException{
        int indexThread=0;
        
        for(int count=0;count<countThreads;count++){
            listThreads.add(new countingThread(matrix1, matrix2, matrixResult));
        }
        
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                indexThread++;
                listThreads.get(indexThread).addTask(new IndexElement(i,j));
                if (++indexThread==countThreads){
                    indexThread=0;
                }
            }
        }
        ArrayList<Thread> threadss = new ArrayList<>();
        for(int count=0;count<countThreads;count++){
            threadss.add(new Thread(listThreads.get(count)));
            threadss.get(count).start();
            threadss.get(count).join();
        }
        
    }
    
}
