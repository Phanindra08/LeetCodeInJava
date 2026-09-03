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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return (subRoot == null) ? true : false;
        else if(subRoot == null)
            return true;
        
        if(root.val == subRoot.val && isSameTree(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode treeNode1, TreeNode treeNode2) {
        if(treeNode1 == null && treeNode2 == null)
            return true;
        else if(treeNode1 == null || treeNode2 == null || treeNode1.val != treeNode2.val)
            return false;
        return isSameTree(treeNode1.left, treeNode2.left) && isSameTree(treeNode1.right, treeNode2.right);
    }
}
