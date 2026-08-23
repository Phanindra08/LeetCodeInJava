class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0, new ArrayList<>());
        return resultList;
    }

    public void dfs(int[] nums, int target, int index, int totalSum, List<Integer> combinationList) {
        if(index >= nums.length)
            return;
        else if(totalSum > target)
            return;
        else if(totalSum == target) {
            resultList.add(new ArrayList<>(combinationList));
            return;
        }
        combinationList.add(nums[index]);
        dfs(nums, target, index, totalSum + nums[index], combinationList);
        combinationList.remove(combinationList.size() - 1);
        dfs(nums, target, index + 1, totalSum, combinationList);
    }
}