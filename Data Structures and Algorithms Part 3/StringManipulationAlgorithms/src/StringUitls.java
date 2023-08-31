import java.util.Arrays;
import java.util.Stack;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUitls {
    public static int countVowels(String input)
    {
        if(input == null)
            return 0;
        int count = 0;
        String vowels = "aeiou";
        for (var ch : input.toLowerCase().toCharArray())
            if(vowels.contains(Character.toString(ch)))
                count++;

        return count;
    }

    public static String revrseString(String input)
    {
        Stack<Character> stack = new Stack<>();
        for (var ch : input.toCharArray()) {
            stack.push(ch);
        }
        
        StringBuffer output = new StringBuffer();
        while (!stack.empty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

    public static String reverseOrderOfWords(String input)
    {
        String[] WordsArray = input.trim().split(" ");
        Collections.reverse(Arrays.asList(WordsArray));
        return String.join(" ", WordsArray);
    }

    public static String removeDublicates(String input)
    {
        if(input == null)
            return "";

        Set<Character> set = new HashSet<>();
        StringBuffer output = new StringBuffer();
        for (var ch : input.toCharArray()) {
            if(!set.contains(ch))
                output.append(ch);
            set.add(ch);
        }
        return output.toString();
    }

    public static Character mostRepeatedCharacter(String input)
    {

        if(input == "" || input == null)
            throw new IllegalStateException();

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            if(map.containsKey(ch))
            {
                var freq = map.get(ch);
                freq++;
                map.put(ch, freq);
            }
            else
                map.put(ch, 1);
        }
        Character repeated = ' ';
        int frequency = 1;
        for (var item : map.entrySet()) {
            if(item.getValue() > frequency)
            {
                frequency = item.getValue();
                repeated = item.getKey();
            }
        }
        return repeated;
    }
    
}
