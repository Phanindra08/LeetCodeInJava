class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == -1)
            return "";
        Map<Character, Integer> characterMapForT = new HashMap<>();
        for(int index = 0; index < t.length(); index++)
            characterMapForT.put(t.charAt(index), characterMapForT.getOrDefault(t.charAt(index), 0) + 1);
        
        int minumumLength = Integer.MAX_VALUE;
        int leftPointer = 0;
        int startPointer = -1;
        Map<Character, Integer> characterMapForS = new HashMap<>();
        int have = 0, need = characterMapForT.size();
        for(int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            characterMapForS.put(s.charAt(rightPointer), characterMapForS.getOrDefault(s.charAt(rightPointer), 0) + 1);
            if(characterMapForT.containsKey(s.charAt(rightPointer)) && (int)characterMapForT.get(s.charAt(rightPointer)) == (int)characterMapForS.get(s.charAt(rightPointer)))
                have++;
            
            while(have == need) {
                if(minumumLength > (rightPointer - leftPointer + 1)) {
                    minumumLength = rightPointer - leftPointer + 1;
                    startPointer = leftPointer;
                }
                characterMapForS.put(s.charAt(leftPointer), characterMapForS.get(s.charAt(leftPointer)) - 1);
                if(characterMapForT.containsKey(s.charAt(leftPointer)) && (int)characterMapForS.get(s.charAt(leftPointer)) < (int)characterMapForT.get(s.charAt(leftPointer)))
                    have--;
                leftPointer++;
            }
        }
        return (minumumLength == Integer.MAX_VALUE) ? "" : s.substring(startPointer, startPointer + minumumLength);
    }
}
