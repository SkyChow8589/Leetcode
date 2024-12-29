package BinaryTree;

public class TrimaBinarySearchTree669 {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交以下的方法
    // [low, high]
    public static TreeNode trimBST(TreeNode cur, int low, int high) {
        if (cur == null) {
            return null;
        }
        if (cur.val < low) {
            return trimBST(cur.right, low, high);
        }
        if (cur.val > high) {
            return trimBST(cur.left, low, high);
        }
        // cur在范围中
        cur.left = trimBST(cur.left, low, high);
        cur.right = trimBST(cur.right, low, high);
        return cur;
    }
}
