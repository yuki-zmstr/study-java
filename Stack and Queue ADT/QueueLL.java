public class QueueLL implements QueueADT {

    public TailedLinkedList list;

    public QueueLL() {
        list = new TailedLinkedList();
    }

    public boolean empty() {
        return list.isEmpty();
    };

    public int peek() {
        return list.getFirst();
    };

    public int dequeue() {
        int item = list.removeFront();
        return item;
    };

    public void enqueue(int item) {
        list.addBack(item);
    };

    public static void main(String[] args) {
        // you can use any one of the following implementation
        // QueueArr<String> queue = new QueueArr<String>(); // Array
        QueueLL queue = new QueueLL(); // LinkedList composition
        // QueueLLE <String> queue= new QueueLLE <String> (); // LinkedList inheritance
        System.out.println("queue is empty? " + queue.empty());
        queue.enqueue(1);
        System.out.println("queue is empty? " + queue.empty());
        System.out.println("front now is: " + queue.peek());
        queue.enqueue(2);
        System.out.println("front now is: " + queue.peek());
        queue.dequeue();
        System.out.println("front now is: " + queue.peek());
    }

}
