// import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        // Stack<Integer> s = new Stack<>();
        // s.peek();
        Stack stack = new Stack();

        System.out.println(stack.isEmpty());
        stack.isEmpty();
        stack.push(7);
        stack.push(7);
        stack.push(7);
        stack.push(9);
        stack.push(9);
        stack.push(90);
        stack.push(109);
        stack.push(1);
        stack.pop();
        System.out.println(stack.min());
        System.out.println(stack);
        // System.out.println(stack.peek());
    }
}
