package com.home.data_structures.heap;

public class Solution {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.addItem(6);
        minHeap.addItem(4);
        minHeap.addItem(10);
        minHeap.addItem(3);

        System.out.println(minHeap);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());

        System.out.println(minHeap);
        System.out.println(minHeap.peek());

        minHeap.addItem(3);
        minHeap.addItem(3);

        System.out.println(minHeap);
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap);

        minHeap.addItem(25);
        System.out.println(minHeap);
    }
}
