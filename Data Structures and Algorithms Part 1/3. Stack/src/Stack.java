import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int size = 5;
    private int index = 0;
    private int min = Integer.MAX_VALUE;
    private int[] stack = new int[size];

    public void push(int item)
    {
        if(index == size)
        {
            size = size * 2;
            int[] temp = new int[size];
            for (int i = 0; i < index; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
            if(item < min)
                min = item;
            stack[index] = item;
            index++;
        }
        else
        {
            if(item < min)
                min = item;
            stack[index] = item;
            index++;
        }
    }
    public int peek()
    {
        if(index == 0) throw new EmptyStackException();
        else return stack[index - 1];
    }
    public void pop()
    {
        if(index == 0) throw new EmptyStackException();
        else index--;
    }

    public boolean isEmpty()
    {
        return index == 0;
    }
    
    public int min(){
        if(index == 0) throw new EmptyStackException();
        else return min;
    }
    
    @Override
    public String toString()
    {
        var content = Arrays.copyOfRange(stack, 0, index);
        return Arrays.toString(content);
    }
}
