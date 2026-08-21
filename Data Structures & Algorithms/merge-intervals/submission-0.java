class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalsAfterSorting = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals)
            intervalsAfterSorting.add(interval);
        intervalsAfterSorting = intervalsAfterSorting.stream().sorted(Comparator.comparing(x -> x[0])).toList();
        result.add(intervalsAfterSorting.get(0));
        for(int index = 1; index < intervalsAfterSorting.size(); index++) {
            if(intervalsAfterSorting.get(index)[0] <= result.getLast()[1])
                result.getLast()[1] = Math.max(result.getLast()[1], intervalsAfterSorting.get(index)[1]);
            else
                result.add(intervalsAfterSorting.get(index));
        }
        return result.toArray(int[][]::new);
    }
}
