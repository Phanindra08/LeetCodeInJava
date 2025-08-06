package edu.charlotte.data_structures.arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
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

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchInRotatedSortedArray.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(searchInRotatedSortedArray.search(new int[] {1}, 0));
    }
}
