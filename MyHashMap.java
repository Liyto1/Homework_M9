package HashMap;

    public class MyHashMap <K, V> {
        private static final int DEFAULT_CAPACITY = 16;
        private Node[] table;
        private int size;

        public MyHashMap() {
            table = new Node[DEFAULT_CAPACITY];
            size = 0;
        }

        public void put(K key, V value) {
            int index = getIndex(key);
            Node newNode = new Node(key, value);

            if (table[index] == null) {
                table[index] = newNode;
            } else {
                Node currentNode = table[index];
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

        public void remove(Object key) {
            int index = getIndex(key);
            Node currentNode = table[index];
            Node prevNode = null;

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

        public Object get(Object key) {
            int index = getIndex(key);
            Node currentNode = table[index];

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }

            return null;
        }

        private int getIndex(Object key) {
            if (key == null) {
                return 0;
            }
            return Math.abs(key.hashCode()) % table.length;
        }

        private static class Node {
            Object key;
            Object value;
            Node next;

            public Node(Object key, Object value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

}
