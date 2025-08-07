package edu.charlotte.data_structures.arrays;

public class SearchInRotatedSortedArray {
    public int searchSolution1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid]) {
                if(target < nums[left] || target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if(target > nums[right] || target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[start] <= nums[mid]) {
                if(target > nums[mid] || target < nums[start])
                    return binarySearch(nums, target,  mid + 1, end);
                else
                    return binarySearch(nums, target,  start, mid - 1);
            }
            else {
                if(target < nums[mid] || target > nums[end])
                    return binarySearch(nums, target,  start, mid - 1);
                else
                    return binarySearch(nums, target,  mid + 1, end);
            }
        }
        return -1;
    }

    public int searchSolution2(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.searchSolution1(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchInRotatedSortedArray.searchSolution1(new int[] {1}, 0));
        System.out.println(searchInRotatedSortedArray.searchSolution2(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
