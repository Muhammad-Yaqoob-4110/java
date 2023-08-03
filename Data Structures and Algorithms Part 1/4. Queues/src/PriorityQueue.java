import java.util.Arrays;
import java.util.Stack;

public class PriorityQueue {
    private int[] priorityQueue;
    private int index;
    private int front;
    public PriorityQueue(int capacity)
    {
        priorityQueue = new int[capacity];
    }
    public void insert(int item)
    {
        if(!isFull())
        {
            if(index > 0)
            {
                int i = shiftItemsToInsert(item);
                priorityQueue[i] = item;
                index++;
                return;
            }
            priorityQueue[index++] = item;
        }
        else   
            throw new IllegalStateException();
    }
    private int shiftItemsToInsert(int item) {
        int i;
        for (i = index; i > 0 ; i--) 
        {
            if (item < priorityQueue[i-1]) 
                priorityQueue[i] = priorityQueue[i-1];
            else
                break;
        }
        return i;
        
    }

    public int remove()
    {
        if(!isEmpty())
        {
            int removedItem = priorityQueue[front];
            priorityQueue[front++] = 0;
            return removedItem;
        }
        else
            throw new IllegalStateException();
    }

    public void reverse(int k)
    {
        // reverse the order of the first K elements of the queue
        if(k > priorityQueue.length || k < 0)
            throw new IllegalArgumentException();
        else
        {
            int[] temp = priorityQueue;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < k; i++) 
            {
                stack.push(temp[i]);
            }

            int idx = 0;
            while (!stack.isEmpty())
            {
                temp[idx] = stack.pop();
                idx++;
            }
            System.out.println(Arrays.toString(temp));
        }
    }
    public boolean isEmpty()
    {
        return index == 0;
    }

    public boolean isFull()
    {
        return index == priorityQueue.length;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(priorityQueue);
    }

}
