public class App {
    public static void main(String[] args) throws Exception { 

        BST tree = new BST();
        // tree.insert(20);
        // tree.insert(10);
        // tree.insert(30);
        // tree.insert(6);
        // tree.insert(14);
        // tree.insert(24);
        // tree.insert(3);
        // tree.insert(8);
        // tree.insert(26);
        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();
        System.out.println();
        System.out.println(tree.height());


    }
    public static int factorial(int number)
    {
        if(number == 0)
            return 1;
        return number * factorial(number - 1);
    }
}
