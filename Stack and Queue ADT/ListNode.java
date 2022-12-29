public class ListNode {
    // attributes
    public int val;
    public ListNode next;

    // constructors
    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode n) {
        this.val = val;
        this.next = n;
    }

    public ListNode getNext() {
        return this.next;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode n) {
        this.next = n;
    }
}
