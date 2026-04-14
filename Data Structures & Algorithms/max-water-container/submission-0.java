class Solution {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length - 1;
        int area = 0;
        while(start < end) {
            area = Math.max(area, Math.min(heights[start], heights[end]) * (end - start));
            if(heights[start] < heights[end])
                start++;
            else
                end--;
        }
        return area;
    }
}
