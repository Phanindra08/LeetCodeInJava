class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder inputStringAfterFiltering = new StringBuilder();
        for(int index = 0; index < s.length(); index++) {
            if((s.charAt(index) >= 'a' && s.charAt(index) <= 'z') || 
            (s.charAt(index) >= '0' && s.charAt(index) <= '9') || 
            s.charAt(index) >= 'A' && s.charAt(index) <= 'Z')
                inputStringAfterFiltering.append(s.charAt(index));
        }

        s = inputStringAfterFiltering.toString().toLowerCase();
        System.out.println(s);
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while(startIndex < endIndex) {
            if(s.charAt(startIndex) != s.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
