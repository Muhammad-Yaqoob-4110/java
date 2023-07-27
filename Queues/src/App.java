import java.util.Queue;
import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue q = new ArrayQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.isFull());
        System.out.println(q);
    }
    public static void reverse(Queue<Integer> queue)
    {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) 
            stack.push(queue.remove());
        
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
