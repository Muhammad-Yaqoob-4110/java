import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SortingAlgo {
    public void bubbleSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++)
            for (int j = 0; j < numbers.length - 1; j++) 
                if(numbers[j] > numbers[j+1])
                    swap(numbers, j, j+1);
    }

    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    public void selectionSort(int[] numbers)
    {
        int sortedIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = getMin(numbers, i);
            swap(numbers, sortedIndex, minIndex); 
            sortedIndex++;
        }
    }

    private int getMin(int[] numbers, int start)
    {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = start; i < numbers.length; i++) {
            if(numbers[i] < min)
            {
                min = numbers[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void insertionSort(int[] numbers)
    {
        for (int i = 1; i < numbers.length; i++) {
            int num = numbers[i];
            for (int j = i; j >= 0; j--) {
                if(numbers[i] < numbers[j-1])
                    numbers[i] = numbers[j-1];
                else
                {
                    numbers[j-1] = num;
                    break;
                }
            }

        }
    }

    public void mergeSort(int[] numbers)
    {
        // divide the array into half
        if(numbers.length < 2)
            return;

        int middle = numbers.length/2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = numbers[i];

        int[] right = new int[numbers.length - middle];
        for (int i = middle; i < numbers.length; i++)
            right[i - middle] = numbers[i];
        
        // sort each half
        mergeSort(left);
        mergeSort(right);

        // merge the result
        merge(left, right, numbers);
    }
    private void merge(int[] left, int[] right, int[] result)
    {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];
        
        while (j < right.length)
            result[k++] = right[j++];
    }

    public void quickSort(int[] numbers)
    {
        quickSort(numbers, 0, numbers.length - 1);
    }
    private void quickSort(int[] numbers, int start, int end)
    {
        if(start >= end)
            return;
        // partition
        int boundary = partition(numbers,start, end);
        // sort left
        quickSort(numbers, start, boundary - 1);
        // sort right
        quickSort(numbers, boundary + 1, end);
    }
    private int partition(int[] numbers, int start, int end)
    {
        int pivot = numbers[end];
        int boundary = start - 1;
        for (int i = start; i <= end; i++)
            if(numbers[i] <= pivot)
                swap(numbers, i, ++boundary);
        
        return boundary;
    }

    public void countingSort(int[] numbers, int max)
    {
        int[] count = new int[max + 1];
        for (int item  : numbers)
            count[item]++;
        
        int k = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++) 
                numbers[k++] = i;
    }

    public void bucketSort(int[] numbers, int numberOfBuckets)
    {
        int index = 0;
        for (var bucket : createBuckets(numbers, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket) 
                numbers[index++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] numbers, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int item : numbers) {
            buckets.get(item / numberOfBuckets).add(item);
        }
        return buckets;
    }
}
