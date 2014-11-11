/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

/**
 *
 * @author vsa
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Sort with insertions
        int key;
        int i;
        int massive[] = {5,4,3,7,6,2};
        for(int j=1;j<massive.length;j++){
            key= massive[j];
            i=j-1;
            while((i!=-1)&&( key<massive[i])){
            massive[i+1]=massive[i];
            i-=1;
            
        }massive[i+1]=key;
        }
        for(int ii=0; ii<massive.length;ii++)
        System.out.print(massive[ii]);
    }
    
}
