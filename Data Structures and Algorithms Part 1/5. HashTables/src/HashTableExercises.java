import java.util.HashMap;
import java.util.Map;

public class HashTableExercises {
    public int mostFrequent(int[] numbers)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : numbers) {
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        int maxFreq = Integer.MIN_VALUE;
        int element = 0;
        for (int i : map.keySet()) {
            int frq = map.get(i);
            if(frq > maxFreq){
                maxFreq = frq;
                element = i;
            }
        }

        return element;
    }

    public int countPairsWithDiff(int k, int[] numbers){
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if(Math.abs(numbers[i] - numbers[j]) == k)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public void twoSum(int target, int[] numbers)
    {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target)
                {
                    System.out.println("["+ i + " " + j +  "]");
                }
            }
        }
    }
}
