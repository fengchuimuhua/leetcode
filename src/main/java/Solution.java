/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode resDummy = new ListNode(0);
        ListNode resLast = resDummy;

        ListNode p = new ListNode(0);
        p.next = head;

        while (true) {
            ListNode lastP = p;

            boolean flag = true;
            for (int ix = 0; ix < k; ix++) {
                if (p.next != null) {
                    p = p.next;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ListNode realLast = null;
                ListNode nextNode = lastP.next;
                for (int ix = 0; ix < k; ix++) {
                    ListNode currNode = nextNode;
                    nextNode = currNode.next;

                    currNode.next = resLast.next;
                    resLast.next = currNode;

                    if (realLast == null) {
                        realLast = currNode;
                    }
                }
                resLast = realLast;
            } else {
                resLast.next = lastP.next;
                // exit the while loop
                break;
            }
        }

        return resDummy.next;
    }

    private ListNode createList(int[] valArr) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        for (int val : valArr) {
            lastNode.next = new ListNode(val);
            lastNode = lastNode.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] valArr = {1, 2, 3, 4, 5};
        ListNode head = s.createList(valArr);
        ListNode newList = s.reverseKGroup(head, 2);
        System.out.println("Hello!");
    }
}