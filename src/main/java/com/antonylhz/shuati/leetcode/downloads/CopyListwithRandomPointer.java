/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newhead=null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode it = head, newit = null;
        while(it!=null) {
            RandomListNode newnode = new RandomListNode(it.label);
            if(newhead==null) newhead = newit = newnode;
            else {
                newit.next = newnode;
                newit = newit.next;
            }
            map.put(it, newit);
            it = it.next;
        }
        it = head; newit = newhead;
        while(it!=null) {
            if(it.random!=null) {
                newit.random = map.get(it.random);
            }
            it = it.next;
            newit = newit.next;
        }
        return newhead;
    }
}
