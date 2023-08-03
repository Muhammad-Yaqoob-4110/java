import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public QueueUsingStacks()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item)
    {
        stack1.push(item);
    }

    public int dequeue()
    {
        if(isEmpty())
            throw new IllegalStateException();
        else
        {
            if(stack2.empty())
            {
                moveStack1ToStack2();
                return stack2.pop();
            }
            else
                return stack2.pop();
        }
    }

    public boolean isEmpty()
    {
        return stack1.empty() && stack2.empty();
    }

    public int peek()
    {
        if(isEmpty())
            throw new IllegalStateException();
        else
        {
            if(stack2.empty())
            {
                moveStack1ToStack2();
                return stack2.peek();
            }
            else
                return stack2.peek();
        }
    }

    private void moveStack1ToStack2() {
        while (!stack1.empty()) 
        {
            stack2.push(stack1.pop());
        }
    }

    public void print()
    {
        System.out.println(stack1);
        System.out.println(stack2);
    }
}
