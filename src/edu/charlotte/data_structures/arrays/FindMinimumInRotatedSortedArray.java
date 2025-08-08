package edu.charlotte.data_structures.arrays;

public class FindMinimumInRotatedSortedArray {
    public int findMinSolution1(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if(mid != 0 && nums[mid - 1] > nums[mid])
                return nums[mid];
            else if(nums[start] <= nums[mid]) {
                if(nums[start] < nums[end])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if(nums[mid] <= nums[end])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return nums[0];
    }

    public int findMinSolution2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low < high) {
            mid = low + (high - low) / 2;
            if( (nums[mid] < nums[high]))
                high = mid;
            else
                low = mid+1;
        }
        return nums[low];
    }

    public int findMinSolution3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int minimumValue = nums[0];
        while(left <= right) {
            if(nums[left] < nums[right]) {
                minimumValue = Math.min(minimumValue, nums[left]);
                break;
            }
            mid = left + (right - left) / 2;
            minimumValue = Math.min(minimumValue, nums[mid]);
            if( (nums[left] > nums[mid]))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return minimumValue;
    }

    public int binarySearch(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if(nums[start] <= nums[end])
            return nums[start];
        else if((mid + 1) < nums.length && nums[mid] > nums[mid + 1])
            return nums[mid + 1];
        else if(nums[start] > nums[mid])
            return binarySearch(nums, start, mid);
        else
            return binarySearch(nums, mid + 1, end);
    }

    public int findMinSolution4(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        System.out.println(findMinimumInRotatedSortedArray.findMinSolution1(new int[] {3, 4, 5, 1, 2}));
        System.out.println(findMinimumInRotatedSortedArray.findMinSolution2(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMinimumInRotatedSortedArray.findMinSolution3(new int[] {11, 13, 15, 17}));
        System.out.println(findMinimumInRotatedSortedArray.findMinSolution4(new int[] {4, 5, 6, 7, 0, 1, 2}));
    }
}