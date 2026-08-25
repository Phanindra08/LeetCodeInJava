class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder inputStringAfterFiltering = new StringBuilder();
        int difference = 'a' - 'A';
        for(int index = 0; index < s.length(); index++) {
            if(s.charAt(index) >= 'A' && s.charAt(index) <= 'Z')
                inputStringAfterFiltering.append((char)(s.charAt(index) + difference));
            else if((s.charAt(index) >= 'a' && s.charAt(index) <= 'z') || 
            (s.charAt(index) >= '0' && s.charAt(index) <= '9'))
                inputStringAfterFiltering.append(s.charAt(index));
        }

        s = inputStringAfterFiltering.toString();
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
