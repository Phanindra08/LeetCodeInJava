class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        int maximumCount = 0;
        for(int num : nums)
            numberSet.add(num);
        
        for(int number: numberSet) {
            if(numberSet.contains(number - 1))
                continue;
            else {
                int count = 1;
                for(int currentNumber = number + 1; numberSet.contains(currentNumber); currentNumber++)
                count++;
            maximumCount = (maximumCount > count) ? maximumCount : count;
            }
        }
        return maximumCount;
    }
}
