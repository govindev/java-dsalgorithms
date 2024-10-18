package com.sdesheet.blind;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> smallHeap;
    Queue<Integer> largeHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<Integer>((a, b) -> b-a);
        largeHeap = new PriorityQueue<Integer>((a, b) -> a-b);
    }

    public void addNum(int num) {
        smallHeap.add(num);
        while (smallHeap.size()-1 > largeHeap.size()) {
            largeHeap.add(smallHeap.remove());
        }
        while (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            int high = smallHeap.remove();
            int low = largeHeap.remove();
            smallHeap.add(low);
            largeHeap.add(high);
        }
    }

    public double findMedian() {
        int size = smallHeap.size() + largeHeap.size();
        if (size % 2 == 0) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
        return smallHeap.peek();
    }
}
