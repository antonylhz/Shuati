public class Solution {
    public int trap(int[] height) {
        int water =0, left = 0, right = height.length-1, i = 0;
        while(left<right) {
            if(height[left]<=height[right]) {
                for(i=left+1; i<right&&height[i]<height[left]; i++) water += height[left] - height[i];
                left = i;
            } else {
                for(i=right-1; i>left&&height[i]<height[right]; i--) water += height[right] - height[i];
                right = i;
            }
        }
        return water;
    }
}