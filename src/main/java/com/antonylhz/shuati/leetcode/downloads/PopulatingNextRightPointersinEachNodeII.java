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
            if(cur.left!=null||cur.right!=null) {
                if(cur.left!=null) {
                    if(nexthead==null) {
                        nexthead = cur.left;
                        last = cur.left;
                    } else {
                        last.next = cur.left;
                        last = last.next;
                    }
                }
                if(cur.right!=null) {
                    if(nexthead==null) {
                        nexthead = cur.right;
                        last = cur.right;
                    } else {
                        last.next = cur.right;
                        last = last.next;
                    }
                }
            }
            cur = cur.next;
        }
        if(nexthead!=null) connect(nexthead);
    }
}
