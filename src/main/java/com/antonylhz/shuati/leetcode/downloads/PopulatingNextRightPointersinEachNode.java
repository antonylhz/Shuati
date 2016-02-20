/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root, last = null, nexthead = null;
        while(cur!=null) {
            if(cur.left==null) break;
            if(last==null) nexthead = cur.left;
            else last.next = cur.left;
            cur.left.next = cur.right;
            last = cur.right;
            cur = cur.next;
        }
        if(nexthead!=null) connect(nexthead);
    }
}