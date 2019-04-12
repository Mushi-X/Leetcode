/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class _002_Add_Two_Numbers {

    /**
     * 时间复杂度 O(N)
     *
     * 循环判断两个链表是否存在值，存在值时相加，若上一次有进位需要加上进位值。取余表示当前结果位置。比记录进位多少
     *
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = new ListNode(0);
        ListNode current = root;
        for (; ; ) {
            int sum = 0;
            if (l1 == null && l2 == null) {
                if (carry > 0) {
                    current.next = new ListNode(carry);
                }
                break;
            } else if (l1 == null) {
                sum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (carry > 0) {
                sum += carry;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return root.next;
    }

}

class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}