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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, int left, int right) {
        if(node == null)
            return true;
        else if(!(node.val < right && node.val > left))
            return false;
        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
    }
}
