package Stack;

import java.util.EmptyStackException;

public class MyStack {
    private Node top;
    private int size;

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            top = top.next;
        } else {
            Node previousNode = getNode(index - 1);
            Node currentNode = previousNode.next;
            previousNode.next = currentNode.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object value = top.value;
        top = top.next;
        size--;
        return value;
    }

    private Node getNode(int index) {
        Node currentNode = top;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
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
