public class DynQueue<E> { // outer class (= generic class)

    private Node head;

    private class Node { // inner class
        E data;
        Node next;

        Node(E data) { // constructor of inner class
            this.data = data;
            next = null;
        }
    }

    // constructor, creats an empty queue
    public DynQueue() {
        head = null;
    }

    // inserts item at the end of this queue,
    // no inserting if item==null
    public void enqueue(E item) {
        if (item == null) {
        } else {
            Node n = new Node(item); // create new node

            if (head == null) // if queue is empty
                head = n;
            else {
                Node p = head;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = n;
            }
        }
    }

    // returns the first item of this queue and removes it
    // reutrns null, if this queue is empty
    public E dequeue() { // generic return value
        if (head == null) {
            return null;
        } else {
            Node first = head;
            head = first.next;
            return first.data;
        }
    }

    // returns the first item of this queue without removing it
    // returns null, if this queue is empty
    public E peek() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }

    // returns true if this queue contains no elements, returns false otherwise
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    // returns the number of elements in this queue
    public int size() {
        Node p = head;
        int cnt = 0;

        if (head == null)
            return 0;
        else
            while (p.next != null) {
                p = p.next;
                cnt++;
            }
        cnt++; // inclusive the last element
        return cnt;
    }

    // returns the item on position pos without removing it
    // returns null if position pos does not exist
    public E get(int pos) {
        if (pos < 0 || pos >= size()) {
            return null;
        }
        Node p = head;
        for (int i = 0; i < pos; i++) {
            p = p.next;
        }
        return p.data;
    }

    // returns the position of item in this queue, the first positon has count 0
    // returns -1 if item is not on this queue; compares items with equals!
    public int contains(E item) {
        Node p = head;
        int cnt = 0;

        if (head == null) { // if queue is empty
            return -1;
        } else {
            while (p.next != null && p.data != item) {
                p = p.next;
                cnt++;
            }
            if ((cnt + 1) == size() && p.data != item)
                return -1;
            else
                return cnt;
        }
    }

    // deletes all items from this queue
    public void clear() {
        head = null;
    }

    // returns a String-representation of this queue as
    // [item0, item1, ...] with item0 as the first item
    public String toString() {
        String result = "[";
        Node current = head;
        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    }
}
