/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task81.multithredmultimatrix;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vsa
 */
public class countingThread implements Runnable {
    
    LinkedList<IndexElement> taskList;
    Matrix matrix1;
    Matrix matrix2;
    Matrix result;

    public countingThread(Matrix matrix1, Matrix matrix2, Matrix matrixResult) {
        this.taskList = new LinkedList<>();
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = matrixResult;
        
    }
    
    public void addTask(IndexElement ie){
        taskList.add(ie);
    }
    
    
     public int findElement(IndexElement index){
        int c=0;
        for(int i=0;i<matrix2.numbers.length;i++){
            c+=matrix1.numbers[index.row][i]*matrix2.numbers[i][index.column];
        }
        return c;
        
    }
     
    @Override
    public void run() {
        while(taskList.size()!=0){
            System.out.println("Task list size: " + taskList.size());
            int row=taskList.peek().row;
            int column=taskList.peek().column;
        result.numbers[row][column]=findElement(taskList.poll());
        }
        
    }
    
}
