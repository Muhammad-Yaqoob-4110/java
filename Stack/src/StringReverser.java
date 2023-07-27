import java.util.Stack;

public class StringReverser {
    public String reverse(String str)
    {
        if(str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (Character character : str.toCharArray())
            stack.push(character); 
        

        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()) {
            char element = stack.peek();
            reversed.append(element);
            stack.pop();
        }

        return reversed.toString();
    }
}
