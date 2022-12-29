import java.util.*;

public class QueueArr implements QueueADT { // FIFO
    private int[] arr;
    private int front, back;
    private int maxSize;
    private final int INITSIZE = 1000;

    public QueueArr() {
        arr = new int[INITSIZE];
        front = 0;
        back = 0;
        maxSize = INITSIZE;
    }

    public boolean empty() {
        return front == back; // front and back point to the same index in the array.
    }

    public int peek() {
        if (empty())
            return -1;
        return arr[front];
    };

    public int dequeue() {
        if (empty()) {
            return -1;
        }
        int item = arr[front];
        arr[front] = -1;
        front = (front + 1) % maxSize;
        return item;
    };

    public void enqueue(int item) {
        // if the array is one more to full, have to enlarge the array
        if ((back + 1) % maxSize == front) {
            enlarge();
        }
        arr[back] = item;
        back = (back + 1) % maxSize;
    };

    private void enlarge() {
        int newSize = maxSize * 2;
        int[] newArray = new int[maxSize];
        for (int i = 0; i < maxSize - 1; i++) {
            // rotate the original array so that front points to 0 again.
            newArray[i] = arr[(front + i) % maxSize];
        }
        front = 0;
        back = maxSize - 1;
        maxSize = newSize;
        arr = newArray;
    };

    public static void main(String[] args) {
        QueueArr q = new QueueArr();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        System.out.println(q.peek());
    }
}
