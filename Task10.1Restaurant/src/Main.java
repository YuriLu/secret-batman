/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vsa
 */
public class Main {
    
    
    public static void main(String[] args){
            Restaurant r = new Restaurant();
        
        Client c1 = new Client(r);
        Client c2 = new Client(r);
                        r.start();

        c1.start();
        c2.start();

    }
}
