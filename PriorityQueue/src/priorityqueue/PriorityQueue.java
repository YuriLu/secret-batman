/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

import java.util.Arrays;

/**
 * 
 * @author vsa
 */
public class PriorityQueue {
    
    int[] heap;
    PriorityQueue(int[] array){
        heap=array;
    }
    
    /**
     * Build decreasing heap. If child is bigger to parent, 
     * perform their exchange.
     * @param index 
     */
    void maxHeapify(int index){
        int left=2*index+1;
        int right=2*index+2;
        int indexBigItem;
        
        if ((left<=heap.length-1)
                &&(left>=0)
                &&(heap[left]>heap[index])) {
            indexBigItem = left;
        } else {
            indexBigItem = index;
        }
        if ((right<=heap.length-1)
                &&(right>=0)
                &&(heap[right]>heap[indexBigItem])) {
            indexBigItem=right;
        }
        if (indexBigItem!=index) {
            int tmp=heap[index];
            heap[index]=heap[indexBigItem];
            heap[indexBigItem]=tmp;
            maxHeapify(indexBigItem);
        }
    }
    
    /**
     * Transformation array to decreasing heap.
     * @return 
     */
    int[] buildMaxHeap(){
            for(int i=heap.length/2-1;i>=0;i--){
                maxHeapify(i);
                }
        return heap;
    }
    
    /**
     * HeapSort. Root switch with last element. Root go to the sortedHeap,
     * then do maxHeapify with new root.
     * @return sorted array
     */
    int[] heapSort(){
        int[] sortedHeap = new int[heap.length];
        int iter=0;
        
        for(int i=heap.length-1;i>-1;i--){
            int tmp = heap[0];
            heap[0] = heap[i];
            heap[i]=tmp;
            sortedHeap[iter]=heap[i];
            iter++;
            this.heap=Arrays.copyOfRange(this.heap, 0, this.heap.length-1);
            maxHeapify(0);
            
        }
        return sortedHeap;
    }
    
}
