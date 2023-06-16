package LinkedList;

import java.util.Objects;


public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void add(E value) {
        Node<E> newNode = new Node(value);

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

        Node<E> removedNode;

        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.prev;
        } else {
            Node<E> currentNode = getNode(index);
            removedNode = currentNode;

            Node<E> prevNode = currentNode.prev;
            Node<E> nextNode = currentNode.next;

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
        Node<E> node = getNode(index);
        return node.value;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
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
        Node<E> prev;
        Node<E> next;

        public Node(E value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
