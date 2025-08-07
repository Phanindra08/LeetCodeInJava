package edu.charlotte.data_structures.arrays;

public class ContainerWithMostWater {
    public int maxAreaSolution1(int[] height) {
        int maximumArea = 0;
        int area, start = 0, end = height.length - 1;
        while(start < end) {
            area = (end - start) * Math.min(height[start], height[end]);
            maximumArea = Math.max(maximumArea, area);
            if(height[start] < height[end])
                start++;
            else
                end--;
        }
        return maximumArea;
    }

    public int maxAreaSolution2(int[] height) {
        int maximumArea = 0, leftPointer = 0;
        int area;
        int rightPointer = height.length - 1;
        int minimumHeight;
        while(leftPointer < rightPointer) {
            minimumHeight = (height[leftPointer] < height[rightPointer])? height[leftPointer] : height[rightPointer];
            area = (rightPointer - leftPointer) * minimumHeight;
            maximumArea = (area > maximumArea)? area : maximumArea;
            while(leftPointer < rightPointer && height[leftPointer] <= minimumHeight) leftPointer++;
            while(leftPointer < rightPointer && height[rightPointer] <= minimumHeight) rightPointer--;
        }
        return maximumArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxAreaSolution1(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(containerWithMostWater.maxAreaSolution2(new int[] {1, 1}));
    }
}
