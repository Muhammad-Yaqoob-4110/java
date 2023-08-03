import java.util.Arrays;
import java.util.Stack;
import java.util.List;

public class Expression {
    private final List<Character> leftBrackets = Arrays.asList('{','[','(','<');
    private final List<Character> rightBrackets = Arrays.asList('}',']',')','>');

    public boolean isBalanced(String input)
    {
        Stack<Character> stack = new Stack<>();
        for (Character character : input.toCharArray()) {
            if (isLeftBracket(character))
                stack.push(character);
            else if(isRightBracket(character)){
                if(stack.empty())
                    return false;
                else if(isRightBracket(character))
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
    private boolean isLeftBracket(char character)
    {
        return leftBrackets.contains(character);
    }
    private boolean isRightBracket(char character)
    {
        return rightBrackets.contains(character);
    }
}
