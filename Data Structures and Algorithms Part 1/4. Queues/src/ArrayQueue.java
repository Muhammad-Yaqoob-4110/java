import java.util.Arrays;

public class ArrayQueue {
    private int[] queue = new int[6];
    private int front = 0;
    private int rear = 0;
    
    public void enqueue(int item)
    {
        if(!isFull())
            queue[rear++] = item;
        
        else 
            throw new IllegalStateException();
    }
    
    public int dequeue()
    {
        if(isEmpty())
            throw new IllegalArgumentException();
        else
        {
            queue[front] = 0;
            return queue[front++];
        }
    }
    public boolean isFull()
    {
        return queue.length == rear;
    }

    public boolean isEmpty()
    {
        return rear == 0;
    }
    @Override
    public String toString()
    {
        // var content = Arrays.copyOfRange(queue, front,rear);
        return Arrays.toString(queue);
    }
}
