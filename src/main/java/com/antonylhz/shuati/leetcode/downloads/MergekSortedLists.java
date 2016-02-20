/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode x, ListNode y) {
                return x.val - y.val;
            }
        });
        for (ListNode node : lists) if (node != null) q.add(node);
        ListNode dumb = new ListNode(0), node = dumb;
        while (!q.isEmpty()) {
            node = (node.next = q.poll());
            if (node.next != null) q.add(node.next);
        }
        return dumb.next;
    }
}
