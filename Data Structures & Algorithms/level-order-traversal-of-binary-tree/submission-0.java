/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root != null)
            queue.add(root);
        TreeNode temp;
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for(int index = 0; index < length; index++) {
                temp = queue.pollFirst();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            resultList.add(list);
        }   
        return resultList;     
    }
}
