import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author vsa
 */
class QueueIsEmptyException extends Exception{
   
}
public class NonBlockingQueueList <T> {
    AtomicInteger size;
    AtomicReference<Node> first;
    AtomicReference<Node> last;
    //LinkedList ll = new LinkedList();
    
    NonBlockingQueueList(){
        size  = new AtomicInteger(0);
        first = new AtomicReference<>(new Node(null,null,null));
        last  = new AtomicReference<>(new Node(null,null,null));
    }
    
    private class Node<T> {
        T item;
        AtomicReference<Node> next;
        AtomicReference<Node> prev;
        Node(T object, AtomicReference<Node> prev, AtomicReference<Node> next){
            this.item = object;
            this.prev = prev;
            this.next = next;
        }
    }
    
    public void offer(T elem){
        System.out.println("offer");
        Node<T> lastNode = last.get();
        AtomicReference lastNodeRef = new AtomicReference(lastNode);
        Node<T> newNode = new Node<T>(elem, lastNodeRef, null);
        AtomicReference<Node> newNodeRef = new AtomicReference<>(newNode);
        
        while(true){
            if(lastNodeRef.compareAndSet(last, newNode)){
               //lastNode.next  = new AtomicReference<>(newNode);
               if(lastNode == null) {
                    first = newNodeRef;
               } else { 
                lastNode.next = newNodeRef;
               }
               break;
            }
        }
        //while(!lastNode.compareAndSet(last, newNode));
        //last = newNodeRef;
//        if(lastNode == null) {
//            first = newNodeRef;
//        } else { 
//            lastNode.next = newNodeRef;
//        }
        size.getAndIncrement();
        //last = newNode;
    }
    
    public void pop() throws QueueIsEmptyException {
        System.out.println("pop");
        if(first.get() != null) {
            Node<T> firstNode = first.get();
        //    if(firstNode != null){
                System.out.println("firstNode = " + firstNode);
                first = new AtomicReference(firstNode.next);
    //            first.prev = first;
                System.out.println("deleted");
        } else {
            throw new QueueIsEmptyException();
        }
    }
}
