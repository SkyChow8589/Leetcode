package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergekSortedLists23 {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 提交以下的方法
    public static ListNode mergeKLists(ArrayList<ListNode> arr) {
        // 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode h : arr) {
            // 遍历所有的头！
            if (h != null) {
                heap.add(h);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        // 先弹出一个节点，做总头部
        ListNode h = heap.poll();
        ListNode pre = h;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return h;
    }
}
