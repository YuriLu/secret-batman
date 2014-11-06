/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.hashmapd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author vsa
 */
public class HMapd {
    
    static HMapd.Node[]  table;
    
    public HMapd(){
        table = new HMapd.Node[11];
        }
    
    static class Node{
        int key;
        final int hash;
        Node next;
        String value;
        
    
        Node(int key, String value){
            this.key=key;
            this.value=value;
            this.hash = hashCode(key);
            this.next = null;
        }
             
        public static int hashCode(int h){
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }
     }
    
   /**
    * Show index value in array for entered hash.
    * @param hash
    * @param length
    * @return index in array for element
    */
       private int indexFor(int hash, int length){
          return hash%length;
      } 
    /**
     * Put element to HMapd.
     * @param key
     * @param value 
     */
       public  void put(int key, String value){
          Node tmp = new Node(key, value);
          int index = indexFor(tmp.hash, table.length);
          if(table[index]==null) {
              table[index]=tmp;
          } else {
              tmp.next=table[index];
              table[index]=tmp;
          }
      }
       
       /**
        * 
        * @param key
        * @return 
        */
        public String get(int key){
            String value;
            Node tmp=null;
            int index=indexFor(HMapd.Node.hashCode(key),table.length);
            
            if(table[index]==null){
                return null;
            }
            return compareKeys(table[index],key);
            
        }
        
        /**
         * Check, if Node has next element in chain
         * @param tmp
         * @return 
         */
        boolean hasNext(Node tmp){
            return tmp.next==null?false:true;
        }
        
        /**
         * Compare keys in chain with target key.
         * @param tmp
         * @param key
         * @return String value, related of this key or null 
         */
        String compareKeys(Node tmp, int key){
            
            if(tmp.key!=key){
                if (hasNext(tmp)){
                    tmp=tmp.next;
                } else {
                    return null;
                }
            compareKeys(tmp,key);
            } else {
                return tmp.value;
            }
            return null;
        }
        
}
