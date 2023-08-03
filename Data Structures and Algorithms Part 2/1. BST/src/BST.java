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
    private Node root;
    public void insert(int value)
    {
        Node node = new Node(value, null, null);
        // 7(null,null), 4(null,null)
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
        if(root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    

}
