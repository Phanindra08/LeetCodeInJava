class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int start = 0, end = list.size() - 1;
        if(end >= 0 && list.get(start) > num)
            start = 0;
        else if(end >= 0 && list.get(end) < num)
            start = end + 1;
        else {
            while(start <= end) {
                int mid = (start + end) / 2;
                if(list.get(mid) == num) {
                    start = mid;
                    break;
                } else if(list.get(mid) < num)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        list.add(start, num);
    }
    
    public double findMedian() {
        int length = list.size();
        if(length % 2 == 0)
            return ((double) list.get(length / 2) + list.get((length / 2) - 1)) / 2;
        else
            return (double)list.get((length - 1) / 2);
    }
}
