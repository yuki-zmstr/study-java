import java.util.EmptyStackException;

public interface StackADT {
    public boolean empty(); // not necessary?

    public int peek() throws EmptyStackException;

    public int pop() throws EmptyStackException;

    public void push(int item);

}