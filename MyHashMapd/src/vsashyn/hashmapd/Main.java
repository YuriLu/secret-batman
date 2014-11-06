/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.hashmapd;

import java.util.HashMap;

/**
 *
 * @author vsa
 */
public class Main {
    
    
    public static void main(String[] args){
        
        HMapd hm = new HMapd();
        
        hm.put(22, "String");
        hm.put(44, "2cond");
        hm.put(55, "3thd");
        
        /*
        HashMap hmap = new HashMap();
        hmap.put(22, "geg");
        System.out.println(hmap.get(0)); //Output: null
        */
        
       System.out.println(hm.get(22));
              System.out.println(hm.get(44));
                            System.out.println(hm.get(55));
                                          System.out.println(hm.get(23));
        hm.put(23, "4thd");
        System.out.println(hm.get(23));



    }
}
