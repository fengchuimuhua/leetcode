/**
 * Created by zhangrunfeng on 1/20/20
 */
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BuildBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy, p2 = dummy;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }


        ListNode rightHead = p1.next.next;
        TreeNode root = new TreeNode(p1.next.val);
        p1.next = null;
        ListNode leftHead = dummy.next;

        root.left = sortedListToBST(leftHead);
        root.right = sortedListToBST(rightHead);
        return root;
    }

    public ListNode getList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        for (int num : nums) {
            ListNode currNode = new ListNode(num);
            last.next = currNode;
            last = currNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        BuildBinarySearchTree bbst = new BuildBinarySearchTree();
        ListNode head = bbst.getList(new int[]{-10,-3,0,5,9});

        TreeNode root = bbst.sortedListToBST(head);
        System.out.println("Hello!");
    }
}
