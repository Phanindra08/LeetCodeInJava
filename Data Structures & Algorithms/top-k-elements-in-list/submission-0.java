class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countOfElements = new HashMap<>();
        int[] topKFrequentElements = new int[k];
        for(int num : nums) {
            if(countOfElements.containsKey(num))
                countOfElements.put(num, countOfElements.get(num) + 1);
            else
                countOfElements.put(num, 1);
        }

        countOfElements = countOfElements.entrySet().stream().sorted(
            Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int index = 0;
        for(Map.Entry<Integer, Integer> mapEntry : countOfElements.entrySet()) {
            topKFrequentElements[index] = mapEntry.getKey();
            index++;
            if(index == k)
                break;
        }

        return topKFrequentElements;
    }
}
