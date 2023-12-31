package HashMap;

    public class MyHashMap <K, V> {
        private static final int DEFAULT_CAPACITY = 16;
        private Node<K, V>[] table;
        private int size;

        public MyHashMap() {
            table = new Node[DEFAULT_CAPACITY];
            size = 0;
        }

        public void put(K key, V value) {
            int index = getIndex(key);
            Node<K, V> newNode = new Node(key, value);

            if (table[index] == null) {
                table[index] = newNode;
            } else {
                Node<K,V> currentNode = table[index];
                while (currentNode.next != null) {
                    if (currentNode.key.equals(key)) {
                        currentNode.value = value;
                        return;
                    }
                    currentNode = currentNode.next;
                }
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                } else {
                    currentNode.next = newNode;
                }
            }
            size++;
        }

        public void remove(K key) {
            int index = getIndex(key);
            Node<K, V> currentNode = table[index];
            Node<K, V> prevNode = null;

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    if (prevNode == null) {
                        table[index] = currentNode.next;
                    } else {
                        prevNode.next = currentNode.next;
                    }
                    size--;
                    return;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        public void clear() {
            table = new Node[DEFAULT_CAPACITY];
            size = 0;
        }

        public int size() {
            return size;
        }

        public Object get(K key) {
            int index = getIndex(key);
            Node<K,V> currentNode = table[index];

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }

            return null;
        }

        private int getIndex(K key) {
            if (key == null) {
                return 0;
            }
            return Math.abs(key.hashCode()) % table.length;
        }

        private static class Node <K, V>{
            K key;
            V value;
            Node<K, V> next;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

}
