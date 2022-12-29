import java.util.*;

public class StackLL implements StackADT {
    private BasicLinkedList list;

    public StackLL() {
        list = new BasicLinkedList();
    }

    public boolean empty() {
        return list.num_nodes == 0;
    }

    public int peek() throws EmptyStackException {
        try {
            return list.getFirst();
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }

    public int pop() throws EmptyStackException {
        int popped = peek();
        list.removeFront();
        return popped;
    };

    public void push(int item) {
        list.addFront(item);
    };

    public static void main(String[] args) {
        // You can use any of the following 4 implementations of Stack
        // StackArr<String> stack = new StackArr<String>(); // Array
        // StackLL stack = new StackLL(); // LinkedList composition
        // StackLLE <String> stack = new StackLLE <String>(); // LinkedList
        Stack<String> stack = new Stack<String>(); // Java API
        System.out.println("stack is empty? " + stack.empty());
        stack.push("1");
        stack.push("2");
        System.out.println("top of stack is " + stack.peek());
        stack.push("3");
        System.out.println("top of stack is " + stack.pop());
        stack.push("4");
        stack.pop();
        stack.pop();
        System.out.println("top of stack is " + stack.peek());
    };
};
