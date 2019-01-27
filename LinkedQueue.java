import java.util.NoSuchElementException;

/**
 * Your implementation of a linked queue. It should NOT be circular.
 *
 * @author Davis White
 * @userid dwhite300
 * @GTID 903270705
 * @version 1.0
 */
public class LinkedQueue<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 10; i += 2) {
            queue.enqueue(i);

        }
    }

    /**
     * Adds the given data to the queue.
     *
     * This method should be implemented in O(1) time.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }

        LinkedNode<T> temp = new LinkedNode<>(data);
        if (size == 0) {
            head = temp;
            tail = temp;
        } else if (size == 1) {
            head.setNext(temp);
            tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
        size++;

    }

    /**
     * Removes the data from the front of the queue.
     *
     * This method should be implemented in O(1) time.
     *
     * @return the data from the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty");
        }

        T data = head.getData();
        head = head.getNext();
        size--;
        return data;

    }

    /**
     * Retrieves the next data to be dequeued without removing it.
     *
     * This method should be implemented in O(1) time.
     *
     * @return the next data or null if the queue is empty
     */
    public T peek() {
        return head.getData();

    }

    /**
     * Return the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return number of items in the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the head node of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the tail node
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }
}