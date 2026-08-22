class Solution {
    // Solution 1
    // public int numDecodings(String s) {
    //     Map<Integer, Integer> dp = new HashMap<>();
    //     dp.put(s.length(), 1);
    //     return dfs(0, dp, s);
    // }

    // public int dfs(int index, Map<Integer, Integer> dp, String s) {
    //     if(dp.containsKey(index))
    //         return dp.get(index);
    //     else if(s.charAt(index) == '0')
    //         return 0;
    //     int result = dfs(index + 1, dp, s);
    //     if((index + 1) < s.length() && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6')))
    //         result += dfs(index + 2, dp, s);
    //     dp.put(index, result);
    //     return result;
    // }

    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        for(int index = s.length() - 1; index >= 0; index--) {
            if(s.charAt(index) == '0')
                dp.put(index, 0);
            else {
                dp.put(index, dp.get(index + 1));

                if((index + 1) < s.length() && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6')))
                dp.put(index, dp.get(index) + dp.get(index + 2));
            }
        }
        return dp.get(0);
    }
}
