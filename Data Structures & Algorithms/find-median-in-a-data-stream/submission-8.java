class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek())
            minHeap.add(maxHeap.poll());
        
        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size() + 1)
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return ((double)minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
