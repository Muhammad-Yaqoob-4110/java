public class SerachAlgos {
    public boolean linearSearch(int[] input, int target)
    {
        for (var item : input)
            if(target == item)
                return true;
        return false;
    }
    
    public int binarySearchRec(int[] input, int target)
    {
        return binarySearchRec(input, target, 0, input.length - 1);
    }
    private int binarySearchRec(int[] input, int target, int left, int right)
    {
        if(right < left)
            return -1;

        int middleIndex = getMiddle(left, right);
        if(input[middleIndex] == target)
            return middleIndex;

        if(input[middleIndex] < target)
            return binarySearchRec(input, target, middleIndex + 1, right);
            
        return binarySearchRec(input, target, left, middleIndex - 1);
    }

    public int binarySearchItter(int[] input, int target)
    {
        int left = 0, right = input.length - 1;

        while (left <= right) {
            int middleIndex = getMiddle(left, right);

            if(input[middleIndex] == target)
                return middleIndex;
            
            if(target > input[middleIndex])
                left = middleIndex + 1;
            if(target < input[middleIndex])
                right = middleIndex - 1;
        }
        return -1;
    }

    private int getMiddle(int left, int right) {
        return (left + right)/2;
    }
}
