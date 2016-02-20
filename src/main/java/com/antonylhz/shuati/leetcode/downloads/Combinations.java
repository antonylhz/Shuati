public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<k; i++) {
        	List<List<Integer>> shadow = new ArrayList<List<Integer>>(result);
        	result.clear();
            for(int j=1+i; j<=i+n-k+1; j++) {
                if(i==0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(j);
                    result.add(temp);
                } else {
                    for(int m=0; m<shadow.size(); m++) {
                        List<Integer> temp = new ArrayList<Integer>(shadow.get(m));
                        if(j>temp.get(i-1)) {
                            temp.add(j);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }
}