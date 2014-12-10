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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsa
 */


public class Server implements Runnable {
    
    static final int PORT=9898;
    static final List<Connection> connections = new ArrayList<>();
    
    public class Connection extends Thread{
        String name;
        Socket cs;
        BufferedReader in;
        PrintWriter out;
        
        Connection(Socket cs){
            this.cs = cs;
            try {
                
                in = new BufferedReader(
                        new InputStreamReader(cs.getInputStream()));
                out = new PrintWriter (cs.getOutputStream(), true);
            } catch (IOException ex) {
                System.err.println("in out readers in constructor");
                ex.printStackTrace();
            }
        }
        
        @Override
        public void run(){
            
            try {
                name = in.readLine();
            } catch (IOException ex) {
            }
                synchronized(connections) {
                    Iterator<Connection> iter = connections.iterator();
                    while(iter.hasNext()) {
			((Connection) iter.next()).out.println(name + " вошел в чат.");
			}
		}
                String message = "";
                while(true){
                    
                    try {
                        message = in.readLine();
                    } catch (IOException ex) {
                        System.err.println("Message readliene exception");
                    }
                    
                    if( message.equals("exit") ){
                        synchronized(connections){
                            
                            ListIterator<Connection> iter = connections.listIterator();
                                while(iter.hasNext()){                  /* Notofication about leave client from chat*/
                                    Connection connection = iter.next();
                                    if(connection.name.equals(this.name)){
                                        for(Connection c: connections){
                                            c.out.println(connection.name + " вышел из чата");
                                        }
                                        try {
                                        connection.in.close();
                                        connection.out.close();
                                        connection.cs.close();
                                        } catch (IOException ex) {
                                            System.err.println("Exception in close connection.");
                                        }
                                    break;
                                    }
                                }
                        }
                        break;
                    } else {
                    synchronized(connections){          //Send all recipients this message
                        ListIterator<Connection> iter = connections.listIterator();
                        while(iter.hasNext()){
                            Connection con = iter.next();
                            if(!con.name.equalsIgnoreCase(name)){
                                con.out.println(name + ":" + message);
                            }
                        }
                    }
                    }
                }
          
        }
    }
       
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("Server started!");
            while(true){
                Socket sc = ss.accept();
                Connection client = new Connection(sc);
                synchronized(connections){
                    connections.add(client);
                    
                }
                
                client.start();
                
            }
        } catch (IOException ex) {
        }
    }
        
        
        
//        try {
//            while(true){
//                Socket ac = ss.accept();
//                InputStream in = ac.getInputStream();
//                OutputStream out = ac.getOutputStream();
//                DataInputStream din = new DataInputStream(in);
//                DataOutputStream dout = new DataOutputStream(out);
//                
//                byte[] info = new byte[1024];
//                din.read(info);
//                System.out.println(info);
//                String response = "this is response";
//                dout.writeChars(response);
//                din.close();
//                dout.close();
//            }
//        } catch (IOException ex) {
//        }
//        
    public static void main(String args[]){
        Thread thread = new Thread(new Server());
        thread.start();
    }
    }

