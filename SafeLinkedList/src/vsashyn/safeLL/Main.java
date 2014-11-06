/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.safeLL;

/**
 *
 * @author vsa
 */
public class Main {
    
    public static void main(String[] args) 
           
    {
        //Adding 11 elements
        SafeLinkedList sll = new SafeLinkedList(); 
        
        System.out.println("Try to add elements: ");
        
        try{
            for(int i=0;i<16;i++){
                sll.add(i);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        //Try to remove elements
        System.out.println("Try to remove elements: ");
        
        try{
            sll.remove(-2);
            
        } catch(EmptyListException ex) {
            System.err.println("Exception: ");
            System.err.println(ex);
            
        } catch(OutOfSizeException ex) {
            System.err.println(ex);
        }
       
    }
}
