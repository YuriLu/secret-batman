/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */
public class Client implements Runnable{
    
    Socket clientSocket;
    int port = 9898;
    String name;
    volatile boolean stoped = false;
    
    public class Receiver implements Runnable{

        BufferedReader in;
        
       
        @Override
        public void run() {
            try {
                in = new BufferedReader (
                        new InputStreamReader(clientSocket.getInputStream()));
              
                System.out.println("I'm listening how will be write.... ");
                String getMessage="";
                while(!stoped){
                    getMessage=in.readLine();
                    System.out.println(getMessage);
                }
            } catch (IOException ex) {
                System.err.println("Exception in readline from socket!");
            }
            finally{
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
        }
        
    }
    
    public static void main(String args[]){
        Thread threadclient = new Thread(new Client());
        threadclient.start();
    }
    
    @Override
    public void run() {
        PrintWriter outSock = null;
        
        try {
            clientSocket = new Socket("localhost", 9898);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("I'm connected");
            
        try { 
            outSock =
                    new PrintWriter (clientSocket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            BufferedReader keyboard = 
                    new BufferedReader (new InputStreamReader(System.in));
            
            System.out.println("Please, enter you name: ");
        try {
            name = keyboard.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
            outSock.println(name);
            
            Thread listenThread = new Thread(new Receiver());
            listenThread.start();
            
            System.out.println("Type message: ");
            String message= "";
            /*
            Правильно обрабатывать выход! (Удаление из очереди)
            */
            try {
                while( !message.equals("exit") ){
                    message = keyboard.readLine();
                    outSock.println(message);
                }
                this.stoped=true;
            } catch (IOException ex) {
                System.err.println("Exception in readline from keyboard!");
            } finally {
            try {
                outSock.close();
                clientSocket.close();
            } catch (IOException ex) {
                System.err.println("Exception in close method!");
            }
            }
            
        
    }
    
      
}
