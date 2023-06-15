package ArrayList;

import java.util.Objects;

public class MyArrayList<E> {
    private int size;
    private Object[] elementData;

    public MyArrayList() {
        elementData = new Object[10];
        size = 0;
    }

    private void add(E value) {
        ensureCapacity(size + 1);
        elementData[size++] = value;
    }
    private E remove(int index){
        Objects.checkIndex(index, size);
        @SuppressWarnings("unchecked")
        E oldValue = (E) elementData[index];
        fastRemove(index);

        return oldValue;
    }

    private void clear(){
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    private int size(){
        return size;
    }

    private E get(int index){
        Objects.checkIndex(index, size);
        @SuppressWarnings("unchecked")
        E element = (E) elementData[index];
        return element;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            int newCapacity = Math.max(elementData.length * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }


}