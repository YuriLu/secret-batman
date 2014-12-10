/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.ships;

/**
 * 1. Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число 
* контейнеров, находящихся в текущий момент в порту и на корабле, должно быть
* неотрицательным и превышающим заданную грузоподъемность суд-
* на и вместимость порта. В порту работает несколько причалов. У одного 
* причала может стоять один корабль. Корабль может загружаться у причала, 
* разгружаться или выполнять оба действия.
 * @author vsa
 */
public class Main {
    
    
    
    public static void main(String[] args){
        
        Port p = new Port();            //Create a port
        Ship sh1 = new Ship(p, 0);
        Ship sh2 = new Ship(p, 25);     //Creating 2 ships

        p.startPort();                  //Start a port
        Thread threadShip2 = new Thread(sh2);
        Thread threadShip = new Thread(sh1);
        threadShip.start();
        threadShip2.start();
        
        
    }
}
