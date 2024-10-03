package com.sdesheet.blind;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private Queue<Integer> smallHeap;
    private Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b-a);
        largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }

    public void addNum(int num) {
        smallHeap.add(num);
        if (smallHeap.size() > largeHeap.size()+1
                || !largeHeap.isEmpty()
                && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() > smallHeap.size()+1) {
            smallHeap.add(largeHeap.poll());
        }

    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        } else if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        } else {
            return largeHeap.peek();
        }
    }
}
