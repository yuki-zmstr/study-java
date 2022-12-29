public interface QueueADT {
    public boolean empty(); // not necessary?

    public int peek();

    public int dequeue();

    public void enqueue(int item);

}