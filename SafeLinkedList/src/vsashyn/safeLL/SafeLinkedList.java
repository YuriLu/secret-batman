/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.safeLL;
import java.util.List;
import java.util.LinkedList;
/**
 * Реализовать ограниченный по количеству элементов список (типа LinkedList), 
 * при этом код должен быть максимально безопасный
 * @author vsa
 */
public class SafeLinkedList {
    
    final private List<Integer> list;
    private int size;
    final int MAX_SIZE=10;
    
    SafeLinkedList(){
        list = new LinkedList<>();
    }
    
    /**
     * Добавление елемента. Вызывает исключение, 
     * если список достиг значения максимального размера.
     * @param item
     * @throws OutOfSizeException 
     */
    public void add(Integer item) throws OutOfSizeException{
            if(size+1>MAX_SIZE){
                throw new OutOfSizeException();
            }
            list.add(item);
            size++;
            }
    /**
     * Удаление елемента по индексу. Вызывает исключения, если список пуст,
     * а так же если индекс елемента больше максимального размера массива
     * @param index
     * @return  удаленный елемент
     * @throws EmptyListException
     * @throws OutOfSizeException 
     */
    public Integer remove(int index)throws EmptyListException
            ,OutOfSizeException
    {
        if (size-1<=-1) {
            throw new EmptyListException();
        }
        if (!checkElementIndex(index)) {
            throw new OutOfSizeException();
        }
        size--;
        return list.remove(index);
    }
    
    private boolean checkElementIndex(int index){
        return index<MAX_SIZE && index>=0;
        
    }
    
    
}
