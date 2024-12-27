package BinaryTree;

public class MinimumDepthofBinaryTree111 {
    // 测试链接 : https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if (root == null) {
            // 当前的树是空树
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 当前root是叶节点
            return 1;
        }
        int ldeep = Integer.MAX_VALUE;
        int rdeep = Integer.MAX_VALUE;
        if (root.left != null) {
            ldeep = minDepth(root.left);
        }
        if (root.right != null) {
            rdeep = minDepth(root.right);
        }
        return Math.min(ldeep, rdeep) + 1;
    }
}
