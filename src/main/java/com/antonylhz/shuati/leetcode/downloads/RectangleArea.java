public class Solution {
    private int findOverlap(int x11, int x12, int x21, int x22) {
        if(x11>=x22||x12<=x21) return 0;
        else if(x11<=x21&&x12>=x22) return x22-x21;
        else if(x21<=x11&&x22>=x12) return x12-x11;
        else if(x11<=x21&&x12<=x22) return x12-x21;
        else return x22-x11;
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C-A)*(D-B) + (G-E)*(H-F) - findOverlap(A, C, E, G)*findOverlap(B, D, F, H);
    }
}