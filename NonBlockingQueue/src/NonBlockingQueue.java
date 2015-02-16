
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author vsa
 */
class QueueIsFullException extends Exception{
}
class QueueIsEmptyException extends Exception{
}
public class NonBlockingQueue<T> {
    
    AtomicReference <T> [] massive ;
    AtomicInteger head;
    AtomicInteger tail;
     
    public NonBlockingQueue(int capacity){
        massive = new AtomicReference[capacity];
        for(int elem =0 ; elem < capacity; elem++ ){
            massive[elem] = new AtomicReference<>();
        }
        head = new AtomicInteger(0);
        tail =  new AtomicInteger(0);
    }

    public void offer(T element) throws QueueIsFullException{
        tail.compareAndSet(Integer.MAX_VALUE , Integer.MAX_VALUE % massive.length);
        if (!massive[tail.getAndIncrement() % massive.length].compareAndSet(null,element)) {
            throw new QueueIsFullException();
        }
    }
    
    public T pop() throws QueueIsEmptyException{
        head.compareAndSet(Integer.MAX_VALUE , Integer.MAX_VALUE % massive.length);
        T element = massive[head.getAndIncrement()% massive.length].getAndSet(null);
        if(element == null){
            throw new QueueIsEmptyException();
        }
        return element;
    }
    
}
