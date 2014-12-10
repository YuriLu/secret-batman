/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.violinist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vsashyn.semaphore.*;
/**
 *
 * @author vsa
 */
public class Violinist extends Thread {
    
    Violin violin;
    Bow bow;
    Game game;
    Semaphore semaphore;
    
    Violinist(Game game){
        this.game = game;
        this.semaphore = game.semaphore;
    }
    
    public void run(){
        while(true){
        semaphore.acquire();
        violin = game.violins.poll();
        bow = game.bows.poll();
        System.out.println("Violinist are playing: " 
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        game.violins.add(violin);
        game.bows.add(bow);
            try {
                semaphore.release();
            } catch (Exception ex) {
                Logger.getLogger(Violinist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    

