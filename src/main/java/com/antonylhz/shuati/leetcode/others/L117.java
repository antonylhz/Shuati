package com.antonylhz.shuati.leetcode.others;

//Populating Next Right Pointers in Each Node II
//
//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?

public class L117 {
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
