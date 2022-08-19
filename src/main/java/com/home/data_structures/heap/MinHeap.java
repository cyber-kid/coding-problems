package com.home.data_structures.heap;

import java.util.Arrays;
import java.util.StringJoiner;

public class MinHeap {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int[] items;

    public MinHeap(int capacity) {
        this.items = new int[capacity];
    }

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    private int getParentIndexByChildIndex(int index) {
        return index / 2;
    }

    private boolean hasParentByChildIndex(int index) {
        return getParentIndexByChildIndex(index) < size;
    }

    private boolean hasLeftChildByParentIndex(int index) {
        return getLeftChildIndexByParentIndex(index) < size;
    }

    private boolean hasRightChildByParentIndex(int index) {
        return getRightChildIndexByParentIndex(index) < size;
    }

    private int getLeftChildIndexByParentIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndexByParentIndex(int index) {
        return (index * 2) + 2;
    }

    private void ensureCapacity() {
        if (size == items.length) {
            items = Arrays.copyOf(items, size * 2);
        }
    }

    private void heapifyUp() {
        int currentItemIndex = size - 1;

        while (hasParentByChildIndex(currentItemIndex) && (items[currentItemIndex] < items[getParentIndexByChildIndex(currentItemIndex)])) {
            swap(currentItemIndex, getParentIndexByChildIndex(currentItemIndex));

            currentItemIndex = getParentIndexByChildIndex(currentItemIndex);
        }
    }

    private void heapifyDown() {
        int currentItemIndex = 0;

        while (hasLeftChildByParentIndex(currentItemIndex)) {
            int minItemIndex = getLeftChildIndexByParentIndex(currentItemIndex);
            if (hasRightChildByParentIndex(currentItemIndex) && (items[getLeftChildIndexByParentIndex(currentItemIndex)] > items[getRightChildIndexByParentIndex(currentItemIndex)])) {
                minItemIndex = getRightChildIndexByParentIndex(currentItemIndex);
            }

            if (items[minItemIndex] > items[currentItemIndex]) {
                break;
            } else {
                swap(minItemIndex, currentItemIndex);
                currentItemIndex = minItemIndex;
            }
        }

    }

    private void swap(int fromIndex, int toIndex) {
        int temp = items[toIndex];
        items[toIndex] = items[fromIndex];
        items[fromIndex] = temp;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("The Heap is empty!");
        }
        return items[0];
    }

    public void addItem(int value) {
        ensureCapacity();

        items[size] = value;
        size++;

        heapifyUp();
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("The Heap is empty!");
        }

        int returnValue = items[0];
        size--;

        swap(size, 0);

        heapifyDown();

        return returnValue;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(items[i]));
        }

        return stringJoiner.toString();
    }
}
