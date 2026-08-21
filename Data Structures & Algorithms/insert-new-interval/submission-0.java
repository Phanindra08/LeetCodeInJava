class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int index = 0; index < intervals.length; index++) {
            if(newInterval[1] < intervals[index][0]) {
                result.add(newInterval);
                for(int index1 = index; index1 < intervals.length; index1++)
                    result.add(intervals[index1]);
                return result.toArray(int[][]::new);
            } else if(newInterval[0] > intervals[index][1])
                result.add(intervals[index]);
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            }
        }
        result.add(newInterval);
        return result.toArray(int[][]::new);
    }
}
