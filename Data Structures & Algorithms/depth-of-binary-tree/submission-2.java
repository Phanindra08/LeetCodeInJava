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
    // public int maxDepth(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     Queue<TreeNode> queue = new ArrayDeque<>();
    //     int length;
    //     int level = 0;
    //     queue.offer(root);
    //     while(!queue.isEmpty()) {
    //         length = queue.size();
    //         level++;
    //         for(int index = 0; index < length; index++) {
    //             TreeNode node = queue.poll();
    //             if(node.left != null)
    //                 queue.offer(node.left);
    //             if(node.right != null)
    //                 queue.offer(node.right);
    //         }
    //     }
    //     return level;
    // }

    // Solution 3
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int maxDepth = 0;
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            if(pair.getKey() != null) {
                stack.push(new Pair<>(pair.getKey().right, pair.getValue() + 1));
                stack.push(new Pair<>(pair.getKey().left, pair.getValue() + 1));
                maxDepth = Math.max(maxDepth, pair.getValue());
            }
        }
        return maxDepth;
    }
}
