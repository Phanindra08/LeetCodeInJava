class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        for(int num: nums)
            numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
        
        List<Integer> valuesList = new ArrayList<>(numberCountMap.values());
        valuesList.sort(Collections.reverseOrder());

        valuesList.subList(k, valuesList.size()).clear();
        Set<Integer> resultSet = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: numberCountMap.entrySet()) {
            if(valuesList.contains(entry.getValue()))
                resultSet.add(entry.getKey());
        }

        int[] result = resultSet.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
