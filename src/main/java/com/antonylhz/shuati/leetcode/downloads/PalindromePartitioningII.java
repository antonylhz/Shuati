public class Solution {
    /**
     * cut[i]: mincut from index i
     *
     * From i, find all palindromes. For each[i,j], cut at j, and append cut[j+1];
     *
     * pal[i]: a list storing all the j's as defined
     */
    public int minCut(String s) {
        if(s==null || s.length()<2) return 0;
        int n = s.length();
        List<Integer> pal = new ArrayList<>(), tmp = new ArrayList<>();
        int[] cut = new int[n+1];
        Arrays.fill(cut, Integer.MAX_VALUE);
        cut[n] = -1;
        for(int i=n-1; i>=0; i--) {
            tmp.add(i);                 // [i,i]
            if(i<n-1) {
                if(s.charAt(i)==s.charAt(i+1)) {
                    tmp.add(i+1);       // [i, i+1]
                }
                for(int j : pal) {
                    if(j+1<n && s.charAt(i)==s.charAt(j+1)) {
                        tmp.add(j+1);
                    }
                }
            }

            for(int j : tmp) {
                cut[i] = Math.min(cut[i], 1+cut[j+1]);
            }
            pal.clear();
            pal.addAll(tmp);
            tmp.clear();
        }
        return cut[0];
    }
}