package LinkedList;

import java.util.Objects;


public class MyLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public void add(E value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public Object remove(int index) {
        Objects.checkIndex(index, size);

        Node removedNode;

        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.prev;
        } else {
            Node currentNode = getNode(index);
            removedNode = currentNode;

            Node prevNode = currentNode.prev;
            Node nextNode = currentNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        removedNode.prev = null;
        removedNode.next = null;
        size--;

        return removedNode.value;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        Node node = getNode(index);
        return node.value;
    }

    private Node getNode(int index) {
        Node currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    private static class Node <E> {
        E value;
        Node prev;
        Node next;

        public Node(E value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
