import java.util.HashMap;
import java.util.Map;

public class CharFinder {
    public char firstNonRepeatedCharacter(String str)
    {
        Map<Character,Integer> map = new HashMap<>(); 

        var chars = str.toCharArray();
        for (char character : chars) 
        {
            if(!map.containsKey(character))
                map.put(character, 1); 
            else
            {
                int freq = map.get(character);
                freq++;
                map.put(character, freq);
            }
        } 

        for (char character : chars) 
            if(map.get(character) == 1)
                return character;

        return Character.MIN_VALUE;
    }

    public char firstRepeatedCharacter(String input)
    {
        Map<Character,Integer> map = new HashMap<>(); 

        var chars = input.toCharArray();
        for (char c : chars)
            map.put(c,map.getOrDefault(c, 0)+1);
        
        for (char character : chars) 
        if(map.get(character) > 1)
            return character;

        return Character.MIN_VALUE;
        
    }
}
