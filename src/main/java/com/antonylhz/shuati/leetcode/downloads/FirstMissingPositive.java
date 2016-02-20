public class Solution {
    public int firstMissingPositive(int[] A) {
        int size  = A.length;
        for(int i=0; i<size; i++) {
            if(A[i] <= 0) A[i] = size+1;
        }

        for(int i=0; i<size; i++) {
            int num = A[i];
            if(num < 0) num = -num;
            if(num < size+1) {
                if(A[num-1] > 0) A[num-1] = -A[num-1];
            }
        }

        for(int i=0; i<size; i++) {
            if(A[i] < 0) continue;
            return i+1;
        }

        return size+1;
    }
}