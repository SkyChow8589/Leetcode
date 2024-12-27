package BinaryTree;

public class MaximumDepthofBinaryTree104 {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 测试链接 : https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
