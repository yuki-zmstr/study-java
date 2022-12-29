import javax.xml.tr

// add validation.
// implement using names defined in interface file
// insert and remove belong as non-interface helper methods.
public class ListUsingArray implements ListADT {
    public int capacity = 1000; // size of the array
    public int num_items = 0; // number of items in the array
    public int[] arr = new int[capacity];

    public boolean isEmpty() {
        return num_items == 0;
    };

    public int size() {
        return num_items;
    };

    public int indexOf(int item) {
        for (int i = 0; i < num_items; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    };

    public boolean contains(int item) {
        for (int i = 0; i < num_items; i++) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    };

    public int getItemAtIndex(int index) {
        return arr[index];
    }

    public int getFirst() {
        // if (num_items == 0) {
        // return
        // }
        return arr[0];
    }

    public int getLast() {
        // if (num_items == 0) {
        // return
        // }
        return arr[num_items - 1];
    };

    public void insert(int index, int item) {
        if (num_items == capacity) {
            System.out.println("enlarging array!");
            enlargeArr();
        }
        for (int i = num_items; i > index; i--) { // have to start from the back!
            arr[i] = arr[i - 1];
        }
        num_items += 1;
        arr[index] = item;
    }

    public void addFront(int item) {
        insert(0, item);
    }

    public void addBack(int item) {
        insert(num_items, item);
    }

    public int remove(int index) {
        int item = arr[index];
        for (int i = index; i < num_items - 1; i++) {
            arr[i] = arr[i + 1];
        }
        num_items -= 1;
        return item;
    }

    public int removeFront() {
        return remove(0);
    };

    public int removeBack() {
        return remove(num_items - 1);
    };

    public void print() {
        for (int i = 0; i < num_items; i++) {
            System.out.print(arr[i] + " ");
        }
    };

    public void enlargeArr() {

        int newSize = capacity * 2;
        int temp[] = new int[newSize];

        // if (temp == null) {
        // System.out.println("ran out of memory");
        // System.exit(1);
        // }
        for (int i = 0; i < num_items; i++) {
            temp[i] = arr[i];
        }
        arr = temp; // point arr to the new array
        capacity = newSize;
    }

    public static void main(String[] args) {
        ListUsingArray list = new ListUsingArray();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addBack(4);
        list.insert(2, 5);
        list.print();
        System.out.println("Testing removal");
        list.removeFront();
        list.removeBack();
        list.remove(1);
        // list.print();
        if (list.contains(1))
            list.addFront(6);
        list.print();
    }
}
