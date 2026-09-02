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
    // Solution 1
    // public int maxDepth(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     int leftTreeHeight = 1 + maxDepth(root.left);
    //     int rightTreeHeight = 1 + maxDepth(root.right);
    //     return Math.max(leftTreeHeight, rightTreeHeight);
    // }

    // Solution 2
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int length;
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            length = queue.size();
            level++;
            for(int index = 0; index < length; index++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return level;
    }
}
