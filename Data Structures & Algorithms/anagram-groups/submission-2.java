class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringMap = new HashMap<>();
        List<String> arrayList;
        boolean isAdded = false;
        for(String str: strs) {
            int[] countOfCharacters = new int[26];
            isAdded = false;
            for(int index = 0; index < str.length(); index++)
                countOfCharacters[str.charAt(index) - 'a']++;
            String word = Arrays.toString(countOfCharacters);
            for(String key: stringMap.keySet()) {
                if(key.equals(word)) {
                    isAdded = true;
                    stringMap.get(key).add(str);
                }
            }
            if(!isAdded){
                arrayList = new ArrayList<>();
                arrayList.add(str);
                stringMap.put(word, arrayList);
            }
        }
        return new ArrayList<>(stringMap.values());
    }

    private boolean isSameKey(int[] characterOfString1, int[] characterOfString2) {
        for(int index = 0; index < 26; index++) {
            if(characterOfString1[index] != characterOfString2[index])
                return false;
        }
        return true;
    }
}
