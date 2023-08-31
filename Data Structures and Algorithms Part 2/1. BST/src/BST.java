import java.util.ArrayList;

public class BST {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        
        public Node(int value, Node leftChild, Node rightChild)
        {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    private int size;
    private Node root;
    public void insert(int value)
    {
        Node node = new Node(value, null, null);
        if(root == null)
            root = node;
        else
        {
            Node current = root;
            while (true) 
            {
                if(current.value > value)
                {
                    if(current.leftChild == null)
                    {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }
                else
                {
                    if(current.rightChild == null)
                    {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
        size++;
    }

    public boolean find(int value)
    {
        if(root == null)
            throw new IllegalStateException();
        else
        {
            Node current = root;
            while (true) 
            {
                if(current.value > value)
                {
                    if(current.leftChild == null)
                        return false;
                    if(current.value == value)
                        return true;
                    current = current.leftChild;
                }
                else
                    if(current.leftChild == null)
                        return false;
                    if(current.value == value)
                        return true;
                    current = current.rightChild;
            }
        }
    }

    public void traversePreOrder()
    {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root)
    {
        if(root == null)
            return;

        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder()
    {
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root)
    {
        if(root == null)
            return;

            traverseInOrder(root.leftChild);
            System.out.print(root.value + " ");
            traverseInOrder(root.rightChild);
    }
    public void traversePostOrder()
    {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root)
    {
        if(root == null)
            return;

            traversePostOrder(root.leftChild);
            traversePostOrder(root.rightChild);
            System.out.print(root.value + " ");
    }
    public int height()
    {
        return height(root);
    }
    private int height(Node root)
    {
        if(root == null)
            return -1;
        if(isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public int min()
    {
        if(root == null)
            throw new IllegalStateException();

        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }
    
    public boolean equals(BST other)
    {
        if(other == null)
            return false;
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second)
    {
        if(first == null && second == null)
            return true;
        if(first != null && second != null)
            return first.value == second.value 
            && equals(first.leftChild, second.leftChild)
            && equals(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree()
    {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max)
    {
        if(root == null)
            return true;
        if(root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1) 
        && isBinarySearchTree(root.rightChild,root.value + 1, max); 
    }
    public ArrayList<Integer> getNodesAtDistance(int distance)
    {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance,list);
        return list;
    }
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) 
    {
        if(root == null)
            return;
        if(distance == 0)
        {
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance - 1,list);
        getNodesAtDistance(root.rightChild, distance - 1,list);
    }
    
    public void traverseLeverOrder()
    {
        
        for (int i = 0; i <= height(); i++) {
            for (var value : getNodesAtDistance(i)) {
                System.out.print(value + " ");
            }
        }
    }

    public int size()
    {
        return size;
    }

    private int leafCount = 0;
    public int countLeaves()
    {
        countLeaves(root);
        return leafCount;
    }
    private void countLeaves(Node root)
    {
        if(root == null)
            return;
        if(isLeaf(root))
            leafCount++;
        countLeaves(root.leftChild);
        countLeaves(root.rightChild);
    }

    public int max()
    {
        if(root == null)
            throw new IllegalStateException();

        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last.value;   
    }


    public boolean contains(int value)
    {
        Node current = root;
        while (current != null) {
            if(current.value == value)
                return true;
            current = current.rightChild;
        }
        Node current2 = root;
        while (current2 != null) {
            if(current2.value == value)
                return true;
            current2 = current2.leftChild;
        }
        return false;
    }
}
