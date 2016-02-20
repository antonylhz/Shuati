public class Solution {
    List<String> res = new ArrayList<String>();
    Stack<Item> s = new Stack<Item>();
    public List<String> generateParenthesis(int n) {
        if(n<1) return res;
        s.push(new Item("(", 1, 0));
        while(!s.isEmpty()) process(s.pop(), n);
        return res;
    }
    void process(Item item, int n) {
        if(item.left>=n && item.right>=n) res.add(item.str);
        else if(item.left>=n) {
            s.push(new Item(item.str+")", item.left, item.right+1));
        } else{
            s.push(new Item(item.str+"(", item.left+1, item.right));
            if(item.left>item.right) s.push(new Item(item.str+")", item.left, item.right+1));
        }
    }
    class Item {
        String str;
        int left;
        int right;
        public Item(String str, int left, int right){
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
}