package com.github.dudiao.code;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。</br>
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。</br>
 *
 * 比如，
 * 输入：(6 -> 5) + (2 -> 1) </br>
 * 输出：（8 -> 6）</br>
 *
 * 原因：56 + 12 = 68
 *
 * @author songyinyin
 * @date 2020/7/19 下午 06:40
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        return result.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public void print() {
            ListNode head = this;
            while (head != null) {
                System.out.print(head.val);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        // 56: 6-5
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        // 12: 2-1
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(1);
        // 56 + 12 = 68 --> print: 86
        addTwoNumbers(l1, l2).print();
    }
}
