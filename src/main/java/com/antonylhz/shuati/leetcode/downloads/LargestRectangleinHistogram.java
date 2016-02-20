public class Solution {
    private int[] height;

    public int largestRectangleArea(int[] height) {
        this.height = height;
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> h = new ArrayList<Integer>();
        int newh, neww, i = 0, max = 0;
        while (i < height.length + 1) {
            if (s.empty() || getHeight(i) > height[s.peek()]) s.push(i++);
            else {
                newh = height[s.pop()];
                neww = s.empty() ? i : (i - s.peek() - 1);
                max = Math.max(max, newh * neww);
            }
        }
        return max;
    }

    private int getHeight(int index) {
        return index >= height.length ? 0 : height[index];
    }
}