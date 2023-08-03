public class LinkedListQueue {
    private Node first;
    private Node last;
    private int length;

    private class Node
    {
        private int value;
        private Node next;
        public Node(int value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }

    public void enqueue(int item)
    {
        // runtime complexty  = O(1)
        Node temp = new Node(item,null);
        if(first == null && last == null)
        {
            first = temp;
            last = temp;
        }
        else
        {
            last.next = temp;
            last = temp;
        }
        length++;
    }
    
    public int dequeue()
    {
        // runtime complexty  = O(1)
        if(isEmpty())
            throw new IllegalStateException();

        int value = first.value;
        first = first.next;

        length--;

        return value;
    }

    public int peek()
    {
        // runtime complexty  = O(1)
        if(isEmpty())
            throw new IllegalStateException();

        return first.value;
    }

    public int size()
    {
        // runtime complexty  = O(1)
        return length;
    }
    public boolean isEmpty()
    {
        // runtime complexty  = O(1)
        return first == null;
    }
    public void print()
    {
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
