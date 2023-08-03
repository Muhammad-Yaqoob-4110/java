import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private int count;
    private int peek;

    public void push(int item)
    {
        // O(1)
        queue1.add(item);
        count++;
        peek = item;
    }
    public int pop()
    {
        // O(n)
        if(!queue1.isEmpty())
        {
            int item = 0;
            Queue<Integer> queue2 = new ArrayDeque<>();
            int idx = 0;
            while (!queue1.isEmpty()) 
            {
                if(idx == count - 1)
                {
                    item = queue1.remove();
                }
                else if(idx == count - 2)
                {
                    int temp = queue1.remove();
                    queue2.add(temp);
                    peek = temp;
                }
                else
                    queue2.add(queue1.remove());
                idx++;
            }
            count--;
            queue1 = queue2;
            return item;
        }
        else 
            throw new IllegalStateException();
    }

    public int peek()
    {
        // O(1)
        if(queue1.isEmpty())
            throw new IllegalStateException();
        return peek;
    }

    public int size()
    {
        return queue1.size();
    }

    public boolean isEmpty()
    {
        return queue1.isEmpty();
    }
    public void print()
    {
        System.out.println(queue1);
    }
}
