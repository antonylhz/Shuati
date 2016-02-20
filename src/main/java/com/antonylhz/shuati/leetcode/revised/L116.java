package com.antonylhz.shuati.leetcode.revised;

//Populating Next Right Pointers in Each Node

import java.util.ArrayList;
import java.util.List;

public class L116 {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        List<TreeLinkNode> q = new ArrayList<TreeLinkNode>();
        q.add(root);
        while(!q.isEmpty()) {
            List<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
            TreeLinkNode last = q.get(0);
            for(int i=1; i<q.size(); i++) {
                if(last.left!=null) level.add(last.left);
                if(last.right!=null) level.add(last.right);
                last.next = q.get(i);
                last = last.next;
            }
            last.next = null;
            if(last.left!=null) level.add(last.left);
            if(last.right!=null) level.add(last.right);
            q = level;
        }
    }
    
    //constant space
    public void connect2(TreeLinkNode root) {
        TreeLinkNode cur = root, last = null, nexthead = null;
        while(cur!=null) {
            if(cur.left==null) break;
            if(last==null) nexthead = cur.left;
            else last.next = cur.left;
            cur.left.next = cur.right;
            last = cur.right;
            cur = cur.next;
        }
        if(nexthead!=null) connect2(nexthead);
    }
}
