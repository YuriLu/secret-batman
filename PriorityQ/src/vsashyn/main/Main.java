/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.main;

import java.util.Arrays;

/**
*   Приоритетная очередь упорядочена по возрастанию: 
*   числа с наименьшим значением имеют наибольший приоритет и извлекаються
*   в первую очередь.
*   
*   @author vsa
*/
class PriorityQ{
    
    final static int MAX_ITEMS=10;
    int a[] = new int[MAX_ITEMS];
    int elementCount=0;
    
    public void insert(int new_element){
        int item;
        if (elementCount==0){
            a[elementCount++]=new_element;
        } else {
            if(elementCount==MAX_ITEMS){
                System.out.println("Queue is full!");
            }else{
                for( item=elementCount-1;item>=0;item--){
                    if(a[item]<=new_element){
                        a[item+1]=a[item];
                    }else{
                        break;
                     }
                    }
                a[item+1]=new_element;
                elementCount++;
                }
            }   
        }
    public int remove(){
        System.out.println("Removing element");
        if (elementCount==MAX_ITEMS){
            return a[--elementCount]; 
        }else{
            return  a[elementCount--];
        }
    }
    
    public void showItems(){
       System.out.println("Queue: ");
        for(int i=0; i<elementCount;i++){
            System.out.println(a[i]);
        }
    }
}
public class Main {
   
    public static void main(String args[]){
     PriorityQ pq = new PriorityQ();
     pq.insert(2);
     pq.showItems();
     
    for(int jel=15;jel>1;jel--){
     
        pq.insert(jel);
    }
     pq.showItems();
     
     pq.remove();
     pq.remove();    
     pq.remove();
     pq.remove();
     pq.remove();

     pq.showItems();
    }
}
