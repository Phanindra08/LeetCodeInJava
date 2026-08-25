class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str: strs) {
            result.append(str.length() + "#").append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        while(startIndex < str.length()) {
            int hashIndex = startIndex;
            while(str.charAt(hashIndex) != '#')
                hashIndex++;
            int stringLength = Integer.parseInt(str.substring(startIndex, hashIndex));
            result.add(str.substring(hashIndex + 1, hashIndex + 1 + stringLength));
            startIndex = hashIndex + 1 + stringLength;
        }
        return result;
    }
}
