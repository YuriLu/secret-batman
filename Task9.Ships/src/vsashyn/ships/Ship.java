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
public class Ship  implements Runnable{
    
    final int MAX_COUNT_CONTAINERS = 25;
    Port p;
    Cargo cargo;

    public Ship(Port p, int countContainers) {
        this.p = p;
        this.cargo = new Cargo(countContainers);
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10000);                 // Ship floats in sea
            } catch (InterruptedException ex) {
            }
            p.addCargoTime(this);
    }
    
    }      
}
