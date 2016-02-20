import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public 	List<List<Integer>> threeSum(int[] num) {
            if (num == null) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = num.length;

        // Sort
        Arrays.sort(num);

        for (int i=0; i<len-2; i++) {
            for (int j=i+1; j<len-1; j++) {
                for (int k=j+1; k<len; k++) {
                    if (num[i] + num[j] + num[k] == 0) {

                        // Save result
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(num[i]); l.add(num[j]); l.add(num[k]);
                        result.add(l);

                        // Bypass second and third elements
                        int K = k;
                        while (k<len && num[k++] == num[K]);
                        k = k == len ? k : k-2;
                        int J = j;
                        while (j<len-1 && num[j++] == num[J]);
                        j = j == len-1 ? j : j-2;
                    }
                }
            }

            // Bypass first element
            int I = i;
            while (i<len-2 && num[i++] == num[I]);
            i = i == len-2 ? i : i-2;
        }

        return result;
    }
}