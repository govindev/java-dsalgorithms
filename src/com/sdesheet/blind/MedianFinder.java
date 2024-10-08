package com.sdesheet.blind;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }

    public void addNum(int num) {
        smallHeap.add(num);
        while (smallHeap.size() > largeHeap.size()+1) {
            int maxElement = smallHeap.remove();
            largeHeap.add(maxElement);
        }
        if (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            int smallHeapMax = smallHeap.remove();
            int largeHeapMin = largeHeap.remove();
            smallHeap.add(largeHeapMin);
            largeHeap.add(smallHeapMax);
        }
    }

    public double findMedian() {
        if (!largeHeap.isEmpty() && (smallHeap.size() + largeHeap.size()) % 2 == 0) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
        return !smallHeap.isEmpty() ? smallHeap.peek() : null;
    }
}
