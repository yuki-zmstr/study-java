public interface ListADT { // service class
    // assume that all element are integers.

    public boolean isEmpty();

    public int size();

    public int indexOf(int item);

    public boolean contains(int item);

    public int getItemAtIndex(int index);

    public int getFirst();

    public int getLast();

    public void addAtIndex(int index, int item);

    public void addFront(int item);

    public void addBack(int item);

    public int removeAtIndex(int index);

    public int removeFront();

    public int removeBack();

    public void print();

}
