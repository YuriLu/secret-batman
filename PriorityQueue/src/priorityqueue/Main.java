/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author vsa
 */
public class Main {
    
        static public void showArray(int[] array){
            for(int i:array){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    public static void main(String[] args){
       
        int[] mas={66,33,44,77,98,1,2,45,55,11,33};
        PriorityQueue pq = new PriorityQueue(mas);
        System.out.println("Initial array:");
        showArray(pq.heap);
        
        pq.buildMaxHeap();
        System.out.println("Decreasing heap: ");
        showArray(pq.heap);
        
        System.out.println("HeapSort:");
        showArray(pq.heapSort());
    }
}
