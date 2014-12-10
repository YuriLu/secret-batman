/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.violinist;

import java.util.LinkedList;
import vsashyn.semaphore.Semaphore;

/**
 *
 * @author vsa
 */
public class Game {
    
    LinkedList<Violin> violins;
    LinkedList<Bow> bows;
    Semaphore semaphore;
    
    public Game(){
        bows = new LinkedList(){{
            add(new Bow());
            add(new Bow());
            add (new Bow());
        }};
        
        violins = new LinkedList(){{
            add(new Violin());
            add(new Violin());
        }};
        semaphore = new Semaphore(bows.size()>violins.size()?violins.size():bows.size());
    }
}
