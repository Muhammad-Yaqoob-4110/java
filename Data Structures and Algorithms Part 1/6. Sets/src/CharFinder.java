import java.util.HashSet;
import java.util.Set;

public class CharFinder {
    public char firstRepeatedCharacter(String input)
    {
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if(set.contains(c))
                return c;
            else
                set.add(c);
        }
        return Character.MIN_VALUE;
    }
}
