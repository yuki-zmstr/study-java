public class BasicLinkedList implements ListADT {
    public ListNode head;
    public int num_nodes;

    public boolean isEmpty() {
        return num_nodes == 0;
    };

    public int size() {
        return num_nodes;
    };

    public int indexOf(int item) {
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            if (cur.val == item) {
                return i;
            }
            cur = cur.next;
            i++;
        }
        return -1;
    };

    public int getFirst() {
        return head.val;
    };

    public boolean contains(int item) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    };

    public int getItemAtIndex(int index) {
        if (index < 0 || index > size() - 1) {
            System.out.println("invalid index");
        }
        ;
        // move through the list index amount of times.
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.getVal();
    }

    public int getLast() {
        return getItemAtIndex(num_nodes - 1);
    };

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size()) {
            System.out.println("invalid index");
        }
        ListNode n = new ListNode(val);
        ListNode cur = head;
        if (cur == null) {
            this.head = n;
            num_nodes = 1;
            return;
        }
        if (index == 0) {
            n.next = head;
            head = n;
            num_nodes++;
            return;
        }
        // move cur to idx before index.
        while (index > 1) {
            cur = cur.next;
            index--;
        }
        n.setNext(cur.next);
        cur.setNext(n);
        num_nodes++;
    }

    public void addFront(int item) {
        addAtIndex(0, item);
    };

    public void addBack(int item) {
        addAtIndex(num_nodes, item);

    };

    public int removeAtIndex(int index) {
        if (index < 0 || index > size() - 1) {
            System.out.println("invalid index");
        }
        ListNode cur = head;
        int res;
        if (cur == null) { // empty
            return -1;
        }
        if (index == 0) {
            res = head.val;
            head = head.next;
            num_nodes--;
            return res;
        }
        // move cur to index before index.
        while (index > 1) {
            cur = cur.next;
            index--;
        }
        res = cur.next.val;
        cur.setNext(cur.next.next);
        num_nodes--;
        return res;
    };

    public int removeFront() {
        return removeAtIndex(0);
    };

    public int removeBack() {
        return removeAtIndex(num_nodes - 1);
    };

    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    };

    public static void main(String[] args) {
        BasicLinkedList list = new BasicLinkedList();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addBack(4);
        list.addAtIndex(2, 5);
        list.print();
        System.out.println("Testing removal");
        list.removeFront();
        list.removeBack();
        list.removeAtIndex(1);
        list.print();
        if (list.contains(1))
            list.addFront(6);
        list.print();
    }
}
