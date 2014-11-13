/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task81.multithredmultimatrix;

/**
 *
 * @author vsa
 */
public class Matrix {
    Integer numbers[][];

    public Matrix(Integer[][] numbers) {
        this.numbers = numbers;
    }
    
    public Matrix(int size){
        numbers = new Integer[size][size]; 
    }
}
