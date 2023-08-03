import java.util.Queue;
import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.print();

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
