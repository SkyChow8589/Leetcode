package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public static List<Integer> preorderTraversal(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                ans.add(head.val);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        return ans;
    }
}
