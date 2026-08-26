class Solution {
    // Solution 1
    // public int characterReplacement(String s, int k) {
    //     int maximumLength = 0;
    //     Map<Character, Integer> charactersMap = new HashMap<>(26);
    //     int leftPointer = 0;
    //     for(int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
    //         charactersMap.put(s.charAt(rightPointer), charactersMap.getOrDefault(s.charAt(rightPointer), 0) + 1);
    //         int currentLength = rightPointer - leftPointer + 1;
    //         while((currentLength - countOfMaximumFrequentCharacter(charactersMap)) > k) {
    //             charactersMap.put(s.charAt(leftPointer), charactersMap.get(s.charAt(leftPointer)) - 1);
    //             leftPointer++;
    //             currentLength--;
    //         }
    //         maximumLength = Math.max(maximumLength, currentLength);
    //     }
    //     return maximumLength;
    // }

    // private int countOfMaximumFrequentCharacter(Map<Character, Integer> charactersMap) {
    //     int maximumCount = 0;
    //     for(Map.Entry<Character, Integer> entry: charactersMap.entrySet())
    //         maximumCount = (entry.getValue() > maximumCount) ? entry.getValue() : maximumCount;
    //     return maximumCount;
    // }

    // Solution 2
    public int characterReplacement(String s, int k) {
        int maximumLength = 0;
        int maximumFrequency = 0;
        Map<Character, Integer> charactersMap = new HashMap<>(26);
        int leftPointer = 0;
        for(int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            charactersMap.put(s.charAt(rightPointer), charactersMap.getOrDefault(s.charAt(rightPointer), 0) + 1);
            maximumFrequency = Math.max(maximumFrequency, charactersMap.get(s.charAt(rightPointer)));
            int currentLength = rightPointer - leftPointer + 1;
            while((currentLength - maximumFrequency) > k) {
                charactersMap.put(s.charAt(leftPointer), charactersMap.get(s.charAt(leftPointer)) - 1);
                leftPointer++;
                currentLength--;
            }
            maximumLength = Math.max(maximumLength, currentLength);
        }
        return maximumLength;
    }
}
