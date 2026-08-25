class Solution {
    public int maxArea(int[] heights) {
        int startIndex = 0, endIndex = heights.length - 1;
        int maximumArea = 0;
        while(startIndex < endIndex) {
            int area = Math.min(heights[startIndex], heights[endIndex]) * (endIndex - startIndex);
            maximumArea = Math.max(maximumArea, area);
            if(heights[startIndex] < heights[endIndex])
                startIndex++;
            else
                endIndex--;
        }
        return maximumArea;
    }
}
