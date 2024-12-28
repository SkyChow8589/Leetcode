package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交如下的方法
    public static List<List<Integer>> pathSum(TreeNode root, int aim) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            f(root, aim, 0, path, ans);
        }
        return ans;
    }

    public static void f(TreeNode cur, int aim, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (cur.left == null && cur.right == null) {
            // 叶节点
            if (cur.val + sum == aim) {
                path.add(cur.val);
                copy(path, ans);
                path.remove(path.size() - 1);
            }
        } else {
            // 不是叶节点
            path.add(cur.val);
            if (cur.left != null) {
                f(cur.left, aim, sum + cur.val, path, ans);
            }
            if (cur.right != null) {
                f(cur.right, aim, sum + cur.val, path, ans);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void copy(List<Integer> path, List<List<Integer>> ans) {
        List<Integer> copy = new ArrayList<>();
        for (Integer num : path) {
            copy.add(num);
        }
        ans.add(copy);
    }
}
