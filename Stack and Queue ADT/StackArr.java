import java.util.EmptyStackException;

// implement stack adt using an array

public class StackArr implements StackADT {
    private int[] arr;
    private int top; // able to return size of the stack too.
    private int maxSize;
    private final int INITSIZE = 1;

    public StackArr() {
        // constructor
        arr = new int[INITSIZE];
        top = -1;
        maxSize = INITSIZE;
    }

    public boolean empty() {
        return (top == -1);
    }

    public int peek() throws EmptyStackException {
        if (!empty()) {
            return arr[top];
        } else
            throw new EmptyStackException();
    };

    public int pop() throws EmptyStackException {
        int popped = peek();
        // arr[top] = null;
        top--;
        return popped;
    };

    public void push(int item) {
        // if the array is at its max, have to enlarge the array
        if (top == maxSize - 1) {
            System.out.println("enlarging array");
            enlarge();
        }
        top++;
        arr[top] = item;
    }

    private void enlarge() {
        maxSize *= 2;
        int[] newArray = new int[maxSize];
        for (int i = 0; i <= top; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    public static void main(String[] args) {
        StackArr arr = new StackArr();
        arr.push(1);
        arr.push(2);
        System.out.println(arr.pop());
        arr.pop();
        System.out.println(arr.empty());
    }
}
