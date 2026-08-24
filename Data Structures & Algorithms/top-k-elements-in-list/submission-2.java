class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        for(int num: nums)
            numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);

        List<List<Integer>> countOfElements = new ArrayList<>(nums.length + 1);
        for(int index = 0; index < nums.length + 1; index++)
            countOfElements.add(new ArrayList<>());
        for(Map.Entry<Integer, Integer> entry: numberCountMap.entrySet())
            countOfElements.get(entry.getValue()).add(entry.getKey());

        int[] result = new int[k];
        int startIndex = 0;
        for(int index = nums.length; index >= 0; index--) {
            for(int value: countOfElements.get(index)) {
                result[startIndex++] = value;
                if(startIndex == k)
                    return result;
            }
        }
        return new int[]{};
    }
}