package Linked_List;

public class PartitionList86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null; // < x的区域
        ListNode rightHead = null, rightTail = null; // >=x的区域
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        // < x的区域有内容！
        leftTail.next = rightHead;
        return leftHead;
    }
}
