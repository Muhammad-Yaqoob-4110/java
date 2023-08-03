import java.util.NoSuchElementException;

public class LinkList {

    private class Node {
        private int value;
        private Node next;
        
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public void addLast(int value){
        // O(1) time complixity
        Node item = new Node(value, null);
        if(first == null)
        {
            this.first = item;
            this.last = item;
        }
        else
        {
            last.next = item;
            last = item;
        }
        size++;
    }

    public void addFirst(int value)
    {
        // O(1) time complixity
        Node addFirst = new Node(value, first);
        if(first == null && last == null)
        {
            this.first = addFirst;
            this.last = addFirst;
        }
        else
            first = addFirst;
        size++;
    }

    public void deleteFirst()
    {
        // O(1) time complixity
        if(first != null)
        {
            first = first.next;
            size--;
        }
        else
            throw new NoSuchElementException();
    }

    public void deleteLast()
    {
        if(first != null)
        {
            Node temp = this.first;
            Node previousNode = null;
                while (temp.next != last.next) {
                    previousNode = temp;
                    temp = temp.next;
                }
                previousNode.next = null;
                size--;
        }
        else
            throw new NoSuchElementException();
    }

    public int contains(int value)
    {
        if(first != null)
        {
            Node temp = this.first;
            while (temp.next != last.next) {
                 temp = temp.next;
                if(temp.value == value)
                {
                    return 0;
                }
            }
            return -1;
        }
        else
            throw new NoSuchElementException();
    }

    public int indexOf(int value)
    {
        if(first !=null)
        {
            int count = 0;
        Node temp = this.first;
        while (temp.next != last.next) {
            if(temp.value == value)
            {
                return count;
            }
            temp = temp.next;
            count++;
            }
            return -1;
        }
        else
            throw new NoSuchElementException();
    }

    public int size()
    {
        // O(1)
        return size;
    }

    public int[] toArray()
    {
        int[] Array = new int[size];
        Node current = first;
        int count = 0;
        while (current!=null) {
            Array[count] = current.value;
            count++;
            current = current.next;
        }
        return Array;
    }
    
    public void reverse()
    {
        if(first == null)
        {
            return;
        }
        else
        {
            Node prev = null;
            Node current = first;
            Node next = null;

            while (current != null) 
            {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            first = prev;
            print();
        }
    }
    public void print(){
        Node current = first;
        while (current!=null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
