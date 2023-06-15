package Queue;

import java.util.NoSuchElementException;

public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.value;
    }

    public Object poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
}
