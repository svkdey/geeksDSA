package Algorithms.DynamicProblems;

import java.util.Collections;
import java.util.PriorityQueue;

class FindMedian
{
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static Double prevMed = Double.MIN_VALUE;

    public static void insertHeap(int num) {
        int min = minHeap.size();
        int max = maxHeap.size();
        if (max > min) {
            if ((double) num < prevMed) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else minHeap.offer(num);
        } else if (max < min) {
            if ((double) num > prevMed) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else maxHeap.offer(num);
        } else {
            if ((double) num < prevMed) {
                maxHeap.offer(num);
                prevMed = (double) maxHeap.peek();
            } else {
                minHeap.offer(num);
                prevMed = (double) minHeap.peek();
            }
            return;
        }
        prevMed = (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public static void balanceHeaps() {
        return;
    }

    public static double getMedian() {
        return prevMed;
    }

    public static void main(String[] args) {
        insertHeap(5);
        System.out.println(maxHeap+" "+minHeap);
        System.out.println(getMedian());
        insertHeap(15);
        System.out.println(maxHeap+" "+minHeap);
        System.out.println(getMedian());
        insertHeap(1);
        System.out.println(maxHeap+" "+minHeap);
        System.out.println(getMedian());
        insertHeap(3);
        System.out.println(maxHeap+" "+minHeap);
        System.out.println(getMedian());
    }

}