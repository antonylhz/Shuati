public class Solution {
    public boolean canJump(int[] A) {
        int exit = A.length-1;
        for(int i=A.length-2; i>=0; i--) if(i+A[i]>=exit) exit = i;
        return exit==0;
    }
}