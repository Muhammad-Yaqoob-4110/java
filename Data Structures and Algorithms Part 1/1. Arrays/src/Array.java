public class Array {
    private int size;
    private int[] list;
    private int index = 0;

    public Array(int size){
        this.size = size;
        this.list = new int[size];
    }

    public void insert(int item){
        if (size-1 >= index) {
            this.list[index] = item;
            index++;
        }
        else{
            int[] temp = new int[this.size + 1];
            this.size++;
            for (int i = 0; i < list.length; i++) {
                temp[i]  = list[i];
            }
            this.list = temp;
            this.list[index] = item;
            index++;
        }
    }

    public void removeAt(int idx){
        if (size-1 >= idx) {
            int[] temp = new int[this.size - 1];
            this.size--;
            int j = 0;
            for (int i = 0; i < list.length; i++) {
                if (i == idx) {
                    continue;
                }
                else{
                    temp[j]  = list[i];
                    j++;
                }
            }
            this.list = temp;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
    public int indexOf(int item){
        for (int i = 0; i < list.length; i++) {
            if(item == list[i])
            {
                return i;
            }
        }
        return -1;
    }

    public void length(){
        System.out.println(size);
    }
    public void print()
    {
        for (int item : list) {
            System.out.println(item);
        }
    }
}
