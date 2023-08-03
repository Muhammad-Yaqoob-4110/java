import java.util.LinkedList;
import java.util.Arrays;
public class App {
    public static void main(String[] args) throws Exception {
        LinkList list = new LinkList();

        // System.out.println(list.size());
        list.addFirst(20);
        list.addFirst(10);
        list.addFirst(14);
        // System.out.println(list.size());
        
        list.addFirst(30);
        list.addLast(44);
        list.addFirst(4);
        // System.out.println(list.size());
        // list.reverse();
        list.print();
        // System.out.println(Arrays.toString(list.toArray()));
    }
}
