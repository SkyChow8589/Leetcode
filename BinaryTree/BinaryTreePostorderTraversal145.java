package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {
    public static List<Integer> postorderTraversalTwoStacks(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                ans.add(collect.pop().val);
            }
        }
        return ans;
    }

    // 用一个栈完成后序遍历
    // 提交时函数名改为postorderTraversal
    // 测试链接 : https://leetcode.cn/problems/binary-tree-postorder-traversal/
    public static List<Integer> postorderTraversalOneStack(TreeNode h) {
        List<Integer> ans = new ArrayList<>();
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    stack.push(cur.right);
                } else {
                    ans.add(cur.val);
                    h = stack.pop();
                }
            }
        }
        return ans;
    }
}
