import java.util.Arrays;

public class CircularQueue {
    private int[] queue;
    private int index;
    private int front;
    private int size;
    private int count;
    public CircularQueue(int capacity)
    {
        queue = new int[capacity];
        size = capacity;
    }
    public boolean isFull()
    {
        return queue.length == count;
    }
    public void enqueue(int item)
    {
        if(!isFull()){
            queue[index % size] = item;
            index++;
            count++;
        }
        else
            throw new IllegalStateException();
    }
    public boolean isEmpty()
    {
        return index == 0;
    }
    public int dequeue()
    {
        if(isEmpty())
            throw new IllegalArgumentException();
        else
        {
            queue[front % size] = 0;
            count--;
            return queue[front++];
        }
    }
    // public boolean isFull()
    // {
         
    // }
    public String toString()
    {
        return Arrays.toString(queue);
    }
}
