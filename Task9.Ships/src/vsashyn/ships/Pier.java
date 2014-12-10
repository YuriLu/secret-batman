/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.ships;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class Pier extends Thread {
    
    Port port;
    
    Pier(Port port){
        this.port = port;
    }
    
    @Override
    public void run() {
        System.out.println("Start Pier " + Thread.currentThread().getName());
        while(true){
            try {
                port.removeCargoTime();
            } catch (InterruptedException ex) {
            }
    }
    }
   
}
