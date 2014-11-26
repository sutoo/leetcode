/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * For example,
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p/>
 * Created by sutao on 14/11/25.
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String a[]) {


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int visited = 0;
        ListNode target = null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            visited++;
            if (visited == n + 1) {
                pre = head;
            } else if (visited > n + 1) {
                pre = pre.next;
            }

            if (visited == n) {
                target = head;
            } else if (visited > n) {
                target = target.next;
            }
            cur = cur.next;
        }
        if (target == head) {
            return head.next;
        }

        if (pre != null && target != null) {
            pre.next = target.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


