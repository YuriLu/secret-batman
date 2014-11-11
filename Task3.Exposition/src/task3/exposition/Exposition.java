/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.exposition;

import java.util.ArrayList;

/**
 *
 * @author vsa
 */
public class Exposition {
    
    private String data;
    private ArrayList<Picture> pictures;
    
    Exposition(String data){
        pictures = new ArrayList();
        this.data = data;
         }
        
    public void add(String name, String author){
            pictures.add(getPicture(name, author));}
        
        public void remove(Picture p){
            pictures.remove(p);
        }
    
    
    public static Picture getPicture(String name, String author){
        return new Picture(name, author);
    }
    
    static class Picture{
        String author;
        String name;
        
        public Picture(String name, String author){
            this.name = name;
            this.author = author;
            }
       
        }
    
public static void main(String[] args){
    
    Exposition ex = new Exposition("11/12/2014");
    ex.add("VanGog", "Sneg");
    ex.add("Da VInci", "Monna Liza");
    
    Exposition.getPicture("MAn", "BIgman");
    
    for (int i=0; i<ex.pictures.size();i++){
        System.out.println(ex.pictures.get(i).author +" "+ ex.pictures.get(i).name);
    }
    
}

}
    
    
    

