import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = {};
        SortingAlgo s = new SortingAlgo();
        // s.bubbleSort(numbers);
        s.bucketSort(numbers,3);
        System.out.println(Arrays.toString(numbers));
    }
}
