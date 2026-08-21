class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> intervalsList = new ArrayList<>();
        for(int[] interval: intervals)
            intervalsList.add(interval);
        intervalsList = intervalsList.stream().sorted(Comparator.comparing(x -> x[0])).toList();
        int lastEndInterval = intervalsList.get(0)[1];
        int countOfIntervalsToRemove = 0;
        for(int index = 1; index < intervalsList.size(); index++) {
            if(intervalsList.get(index)[0] < lastEndInterval) {
                lastEndInterval = Math.min(lastEndInterval, intervalsList.get(index)[1]);
                countOfIntervalsToRemove++;
            } else
                lastEndInterval = intervalsList.get(index)[1];
        }
        return countOfIntervalsToRemove;
    }
}
